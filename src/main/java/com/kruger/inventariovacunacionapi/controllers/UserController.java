package com.kruger.inventariovacunacionapi.controllers;

import com.kruger.inventariovacunacionapi.entities.Usuarios;
import com.kruger.inventariovacunacionapi.message.request.EmpleadosRequest;
import com.kruger.inventariovacunacionapi.message.response.JwtRespuesta;
import com.kruger.inventariovacunacionapi.repositories.EmpleadosRepository;
import com.kruger.inventariovacunacionapi.services.EmpleadosServiceImpl;
import com.kruger.inventariovacunacionapi.services.UsuarioServiceImpl;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
   @Autowired
   UsuarioServiceImpl usuarioServiceImpl;
   @Autowired
   EmpleadosServiceImpl empleadosServiceImpl;
   @Autowired
   EmpleadosRepository empleadosRepository;

   @PostConstruct
   public void initRoleAndUser() {
      this.usuarioServiceImpl.initRoleAndUser();
   }

   @PostMapping({"/registrar"})
   @PreAuthorize("hasRole('Admin')")
   public JwtRespuesta registrar(@RequestBody Usuarios user) throws Exception {
      return this.usuarioServiceImpl.registrar(user);
   }

   @PostMapping({"/actualizarEmpleado"})
   public JwtRespuesta actualizarEmpleado(@RequestBody EmpleadosRequest empleadosRequest) throws Exception {
      return this.empleadosServiceImpl.actualizarEmpleado(empleadosRequest);
   }

   @GetMapping({"/listarEstadoVacunacion"})
   @PreAuthorize("hasRole('Admin')")
   @ResponseBody
   public ResponseEntity<?> listarEstadoVacunacion(@RequestBody Boolean estadoVacunacion) throws Exception {
      return ResponseEntity.ok(this.empleadosRepository.findByEstadoDeVacunacion(estadoVacunacion));
   }

   @GetMapping({"/listarTipoVacuna"})
   @PreAuthorize("hasRole('Admin')")
   @ResponseBody
   public ResponseEntity<?> listarTipoVacuna(@RequestBody int tipoVacuna) throws Exception {
      return ResponseEntity.ok(this.empleadosRepository.findByTipoVacuna(tipoVacuna));
   }

   @GetMapping({"/listarRangoVacunacion"})
   @PreAuthorize("hasRole('Admin')")
   @ResponseBody
   public ResponseEntity<?> listarRangoVacunacion(@RequestParam(required = true) @DateTimeFormat(pattern = "yyy-MM-dd") Date dateInicio, @RequestParam(required = true) @DateTimeFormat(pattern = "yyy-MM-dd") Date dateFin) throws Exception {
      return ResponseEntity.ok(this.empleadosRepository.findByFechaBetween(dateInicio, dateFin));
   }

   @DeleteMapping({"/eliminarEmpleado/{username}"})
   @PreAuthorize("hasRole('Admin')")
   public JwtRespuesta eliminarEmpleado(@PathVariable("username") String username) throws Exception {
      return this.empleadosServiceImpl.eliminarTrabajador(username);
   }
}