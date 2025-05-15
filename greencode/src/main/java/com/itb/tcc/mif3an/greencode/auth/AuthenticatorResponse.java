package com.itb.tcc.mif3an.greencode.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticatorResponse {
    @JsonProperty("acess_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;

    public AuthenticatorResponse(String accessToken, String refreshToken) {
        
    }


}
