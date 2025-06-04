package com.itb.tcc.mif3an.greencode.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {
    @JsonProperty("acess_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;

    public AuthenticationResponse(){

    }

    public AuthenticationResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
