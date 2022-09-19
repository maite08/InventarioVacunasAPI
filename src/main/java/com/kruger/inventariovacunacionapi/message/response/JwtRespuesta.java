/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kruger.inventariovacunacionapi.message.response;

/**
 *
 * @author MaiteMejia
 */
public class JwtRespuesta {
    private boolean respuesta;
    private String mensaje;

    public JwtRespuesta(boolean respuesta, String mensaje) {
        this.respuesta = respuesta;
        this.mensaje = mensaje;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}