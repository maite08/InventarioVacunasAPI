/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kruger.inventariovacunacionapi.repositories;
import com.kruger.inventariovacunacionapi.entities.Usuarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author MaiteMejia
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuarios, String> {
 
   @Query("SELECT s FROM Usuarios s WHERE s.username=?1")
    Usuarios findByCedula(String username);
}
