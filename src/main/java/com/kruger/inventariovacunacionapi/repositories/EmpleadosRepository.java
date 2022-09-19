package com.kruger.inventariovacunacionapi.repositories;

import com.kruger.inventariovacunacionapi.entities.Empleados;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {

    @Query("SELECT empl FROM Empleados empl WHERE empl.estadoVacuna=?1")
    List<Empleados> findByEstadoDeVacunacion(Boolean estado);

    @Query(nativeQuery = true, value = "SELECT * FROM empleados p WHERE p.tipo_vacuna = ?1"
    )
    List<Empleados> findByTipoVacuna(int idVacuna);

    @Query(nativeQuery = true, value = "SELECT * FROM empleados p WHERE p.cedula = ?1 limit 1"
    )
    Empleados findByCedula(String cedula);

    @Query(value = "SELECT * FROM empleados t WHERE t.fecha_vacunacion BETWEEN ?1 AND ?2",
            nativeQuery = true)
    List<Empleados> findByFechaBetween(Date dateInicio, Date dateFin);
}
