package com.itb.tcc.mif3an.greencode.model.entity;

public enum Permission {

    ADMIN_READ("ADMIN_READ"),
    ADMIN_UPDATE("ADMIN_UPDATE"),
    ADMIN_CREATE("ADMIN_CREATE"),
    ADMIN_DELETE("ADMIN_DELETE"),
    DOADOR_READ("DOADOR_READ"),
    DOADOR_UPDATE("DOADOR_UPDATEe"),
    DOADOR_CREATE("DOADOR_CREATE"),
    DOADOR_DELETE("DOADOR_DELETE"),
    COLETOR_READ("COLETOR_READ"),
    COLETOR_UPDATE("COLETOR_UPDATE"),
    COLETOR_CREATE(" COLETOR_CREATE"),
    COLETOR_DELETE("COLETOR_DELETE");



    private final String permission;
    Permission(String permission) {this.permission = permission;}
    public String getPermission() {return this.permission;}

}
