/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kruger.inventariovacunacionapi.repositories;

import com.kruger.inventariovacunacionapi.entities.TipoVacunas;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MaiteMejia
 */
@Repository
public interface TipoVacunasRepository extends JpaRepository<TipoVacunas, Long>{
    @Override
    Optional<TipoVacunas> findById(Long id);

    @Query("SELECT VACUNAS FROM TipoVacunas VACUNAS")
    public List<TipoVacunas> findVacuna();

    
    
}
