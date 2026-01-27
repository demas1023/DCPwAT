package com.demas.dcpa.data.dto;

import com.demas.dcpa.data.rol.ClientRoles;

public class ClientDTO {
    String nickname;
    String email;
    ClientRoles rol;

    public ClientDTO(String nickname, String email, ClientRoles rol) {
        this.nickname = nickname;
        this.email = email;
        this.rol = rol;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientRoles getRol() {
        return rol;
    }

    public void setRol(ClientRoles rol) {
        this.rol = rol;
    }
}
