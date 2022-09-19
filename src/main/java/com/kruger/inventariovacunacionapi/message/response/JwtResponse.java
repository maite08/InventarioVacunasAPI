/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kruger.inventariovacunacionapi.message.response;

import com.kruger.inventariovacunacionapi.entities.Usuarios;

/**
 *
 * @author MaiteMejia
 */
public class JwtResponse {

    private Usuarios usuario;
    private String jwtToken;

    public JwtResponse(Usuarios usuario, String jwtToken) {
        this.usuario = usuario;
        this.jwtToken = jwtToken;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
