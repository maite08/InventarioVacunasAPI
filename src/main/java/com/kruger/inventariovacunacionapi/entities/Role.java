/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kruger.inventariovacunacionapi.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author MaiteMejia
 */

@Entity
@Table(name = "ROLES")
public class Role implements Serializable {

    @Id
    private String nombre;

    @Column(nullable=false)
    private Boolean estadoRegistro;
    
    private String roleDescription;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(Boolean estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return "Role{" + "nombre=" + nombre + ", estadoRegistro=" + estadoRegistro + ", roleDescription=" + roleDescription + '}';
    }

    

   
    
    
}
