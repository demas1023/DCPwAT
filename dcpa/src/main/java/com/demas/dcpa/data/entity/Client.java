package com.demas.dcpa.data.entity;

import com.demas.dcpa.data.rol.ClientRoles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue
    int id;
    ClientRoles rol;
    String nickname;
    String email;
    String password;

    //for register pruposes
    public Client(String nickname, String email, String password, ClientRoles rol) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    //what's actually going in the DTO
    public Client(String nickname, String email, ClientRoles rol) {
        this.nickname = nickname;
        this.email = email;
        this.rol = rol;
    }

    public Client() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientRoles getRol() {
        return rol;
    }

    public void setRol(ClientRoles rol) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
