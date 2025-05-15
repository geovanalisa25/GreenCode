package com.itb.tcc.mif3an.greencode.model.entity;

public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    DOADOR_READ("doador:read"),
    DOADOR_UPDATE("doador:update"),
    DOADOR_CREATE("doador:create"),
    DOADOR_DELETE("doador:delete"),
    COLETOR_READ("coletor:read"),
    COLETOR_UPDATE("coletor:update"),
    COLETOR_CREATE("coletor:create"),
    COLETOR_DELETE("coletor:delete");



    private final String permission;
    Permission(String permission) {this.permission = permission;}
    public String getPermission() {return this.permission;}

}
