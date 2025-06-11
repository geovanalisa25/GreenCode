

package com.itb.tcc.mif3an.greencode.auth;

import com.itb.tcc.mif3an.greencode.config.JwtService;

import com.itb.tcc.mif3an.greencode.exceptions.BadRequest;
import com.itb.tcc.mif3an.greencode.exceptions.Unauthorized;
import com.itb.tcc.mif3an.greencode.model.entity.Usuario;
import com.itb.tcc.mif3an.greencode.model.repository.UsuarioRepository;
import com.itb.tcc.mif3an.greencode.model.services.UsuarioService;
import com.itb.tcc.mif3an.greencode.model.token.Token;
import com.itb.tcc.mif3an.greencode.model.token.TokenRepository;
import com.itb.tcc.mif3an.greencode.model.token.TokenType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UsuarioRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;

    public AuthenticationService(UsuarioRepository repository,
                                 TokenRepository tokenRepository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationManager authenticationManager,
                                 UsuarioService usuarioService)
                                 {

        this.repository = repository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
    }


    public AuthenticationResponse register(RegisterRequest request) {
        String nomeClasse = String.valueOf(request.getRole());
        nomeClasse = nomeClasse.toLowerCase();
        char primeiroCharMaiusculo = Character.toUpperCase(nomeClasse.charAt(0));
        nomeClasse = nomeClasse.substring(1);
        nomeClasse = primeiroCharMaiusculo + nomeClasse;

        try {
            Class<?> clazz = Class.forName("com.itb.tcc.mif3an.greencode.model.entity." + nomeClasse);
            Usuario usuario = (Usuario) clazz.newInstance();
            usuario.setCodStatus(true);
            usuario.setNome(request.getNome());
            usuario.setEmail(request.getEmail());
            usuario.setCpf(request.getCpf());
            usuario.setPassword(passwordEncoder.encode(request.getPassword()));
            usuario.setRole(request.getRole());
            var usuarioDb = repository.findByEmail(request.getEmail());
            if (usuarioDb.isPresent()) {
                throw new BadRequest("Já existe esse e-mail cadastrado em nosso banco de dados");

            }

            var savedUser = repository.save(usuario);
            var jwtToken = jwtService.generateToken(usuario);
            var refreshToken = jwtService.generateRefreshToken(usuario);
            saveUserToken(savedUser, jwtToken);
            return new AuthenticationResponse(jwtToken, refreshToken);


        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());

            }

            }


            private void  saveUserToken(Usuario usuario, String jwtToken) {
                var token = new Token();
                token.setUsuario(usuario);
                token.setToken(jwtToken);
                token.setTokenType(TokenType.BEARER);
                token.setExpired(false);
                token.setRevoked(false);
                tokenRepository.save(token);

            }

            public AuthenticationResponse authenticate(AuthenticationRequest request) {
                try {} catch (Exception e) {
                    throw new BadRequest("Email Ou password incorreto");
                }

                var user = usuarioService.findByEmail(request.getEmail());
                if(!user.isCodStatus()){
                    throw new Unauthorized("Conta inativa, por favor procurar o administrador da conta");
                }

                var jwtToken = jwtService.generateToken(user);
                var refreshToken = jwtService.generateRefreshToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, jwtToken);

                return new AuthenticationResponse(jwtToken, refreshToken);
            }
            private void revokeAllUserTokens(Usuario usuario) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(usuario.getId());
        if(validUserTokens.isEmpty()) return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
            }
        }
