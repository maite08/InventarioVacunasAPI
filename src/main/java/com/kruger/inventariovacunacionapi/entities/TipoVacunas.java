package com.kruger.inventariovacunacionapi.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author MaiteMejia
 */
@Entity
@Table(name = "TIPO_VACUNAS", uniqueConstraints = {})
public class TipoVacunas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacunas;
    
    private String nombreVacuna;

    public Long getIdVacunas() {
        return idVacunas;
    }

    public void setIdVacunas(Long idVacunas) {
        this.idVacunas = idVacunas;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    @Override
    public String toString() {
        return "TipoVacunas{" + "idVacunas=" + idVacunas + ", nombreVacuna=" + nombreVacuna + '}';
    }
    
    
}
