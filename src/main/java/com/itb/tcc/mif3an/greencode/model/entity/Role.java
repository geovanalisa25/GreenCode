package com.itb.tcc.mif3an.greencode.model.entity;




import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


import static com.itb.tcc.mif3an.greencode.model.entity.Permission.*;

public enum Role {

    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    DOADOR_READ,
                    DOADOR_UPDATE,
                    DOADOR_DELETE,
                    DOADOR_CREATE,
                    COLETOR_READ,
                    COLETOR_UPDATE,
                    COLETOR_DELETE,
                    COLETOR_CREATE
            )
    ),

    DOADOR (
            Set.of(

                    DOADOR_READ,
                    DOADOR_UPDATE,
                    DOADOR_DELETE,
                    DOADOR_CREATE

            )
    ),

    COLETOR (
            Set.of(

                    COLETOR_READ,
                    COLETOR_UPDATE,
                    COLETOR_DELETE,
                    COLETOR_CREATE

            )
    );


    private final Set<Permission> permissions;
    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }


    public Collection<? extends GrantedAuthority> getAuthorities () {
        var authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + name()));
        return authorities;
    }


}





