package com.kruger.inventariovacunacionapi.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MaiteMejia
 */
@Entity
@Table(name = "EMPLEADOS", uniqueConstraints = {})
public class Empleados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;


    @Size(max = 10)
    private String cedula;


    @NotNull(message = "Este campo es obligatorio")
    private String nombres;


    @NotNull(message = "Este campo es obligatorio")
    private String apellidos;

    @Size(max = 100)
    @Email
    @NotNull(message = "Este campo es obligatorio")
    private String correo;


    private Date fechaNacimiento;
    
    private String direccion;
    
    private String telefono;
    
    private boolean estadoVacuna;
    
     @JoinColumn(name="TipoVacuna", referencedColumnName = "idVacunas")
     @OneToOne
    private TipoVacunas TipoVacuna;
    
    private String numeroDosis;
    
    private Date fechaVacunacion;

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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

    public TipoVacunas getTipoVacuna() {
        return TipoVacuna;
    }

    public void setTipoVacuna(TipoVacunas TipoVacuna) {
        this.TipoVacuna = TipoVacuna;
    }


    public String getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(String numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    public Date getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(Date fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    @Override
    public String toString() {
        return "Empleados{" + "idEmpleado=" + idEmpleado + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", telefono=" + telefono + ", estadoVacuna=" + estadoVacuna + ", TipoVacuna=" + TipoVacuna + ", numeroDosis=" + numeroDosis + ", fechaVacunacion=" + fechaVacunacion + '}';
    }


}
