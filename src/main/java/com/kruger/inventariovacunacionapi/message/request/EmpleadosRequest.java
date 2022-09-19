package com.kruger.inventariovacunacionapi.message.request;

import com.google.gson.Gson;

import javax.validation.constraints.*;

/**
 *
 * @author MaiteMejia
 */
public class EmpleadosRequest {
 

    @Size(max = 10)
    private String username;

    private String nombres;

    @NotNull(message = "Este campo es obligatorio")
    private String apellidos;

    @Size(max = 100)
    @Email
    @NotNull(message = "Este campo es obligatorio")
    private String correo;

    private String fechaNacimiento;
    
    private String direccion;
    
    private String telefono;
    
    private boolean estadoVacuna;
    
    private String tipoVacuna;
    
    private String numeroDosis;
    
    private String fechaVacunacion;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstadoVacuna() {
        return estadoVacuna;
    }

    public void setEstadoVacuna(boolean estadoVacuna) {
        this.estadoVacuna = estadoVacuna;
    }

    public String getTipoVacuna() {
        return tipoVacuna;
    }

    public void setTipoVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public String getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(String numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    public String getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(String fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
    
}
