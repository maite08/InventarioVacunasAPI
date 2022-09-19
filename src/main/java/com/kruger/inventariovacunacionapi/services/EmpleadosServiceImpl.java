package com.kruger.inventariovacunacionapi.services;

import com.kruger.inventariovacunacionapi.entities.Empleados;
import com.kruger.inventariovacunacionapi.entities.TipoVacunas;
import com.kruger.inventariovacunacionapi.entities.Usuarios;
import com.kruger.inventariovacunacionapi.message.request.EmpleadosRequest;
import com.kruger.inventariovacunacionapi.message.response.JwtRespuesta;
import com.kruger.inventariovacunacionapi.repositories.EmpleadosRepository;
import com.kruger.inventariovacunacionapi.repositories.TipoVacunasRepository;
import com.kruger.inventariovacunacionapi.repositories.UsuarioRepository;
import com.kruger.inventariovacunacionapi.util.NumberUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadosServiceImpl {
   @Autowired
   EmpleadosRepository empleadosRepository;
   @Autowired
   TipoVacunasRepository tipoVacunasRepository;
   @Autowired
   private UsuarioRepository usuarioRepository;
   public static final Logger LOG = LoggerFactory.getLogger(EmpleadosServiceImpl.class);

   @Transactional(
      rollbackFor = {Exception.class}
   )
   public JwtRespuesta registrar(EmpleadosRequest empleadosRequest) throws Exception {
      Empleados empleado = this.empleadosRepository.findByCedula(empleadosRequest.getUsername());
      if (empleado != null) {
         LOG.info("El usuario " + empleadosRequest.getUsername() + " ya se encuentra registrado.");
         return new JwtRespuesta(false, "El usuario se encuentra registrado");
      } else {
         String passwordTemporal = NumberUtil.getRandomNumberCharInRange(9);
         empleado.setNombres(empleadosRequest.getNombres());
         empleado.setApellidos(empleadosRequest.getApellidos());
         empleado.setCedula(empleadosRequest.getUsername());
         empleado.setCorreo(empleadosRequest.getNombres());
         return new JwtRespuesta(true, "Usuario registrado exitosamenteSu usuario es:" + empleado.getCedula() + "Su contraseña temporal es:" + passwordTemporal);
      }
   }

   public JwtRespuesta actualizarEmpleado(EmpleadosRequest empleadosRequest) throws ParseException {
      Empleados empleadoResponse = null;
      Usuarios userCedula = this.usuarioRepository.findByCedula(empleadosRequest.getUsername());
      if (userCedula != null) {
         Empleados empleadoResponse2 = this.empleadosRepository.findByCedula(userCedula.getUsername());
         if (empleadoResponse2 == null) {
            empleadoResponse = new Empleados();
         } else {
            empleadoResponse = empleadoResponse2;
         }

         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
         empleadoResponse.setCedula(empleadosRequest.getUsername());
         empleadoResponse.setNombres(empleadosRequest.getNombres());
         empleadoResponse.setApellidos(empleadosRequest.getApellidos());
         empleadoResponse.setCorreo(empleadosRequest.getCorreo());
         empleadoResponse.setDireccion(empleadosRequest.getDireccion());
         empleadoResponse.setEstadoVacuna(empleadosRequest.isEstadoVacuna());
         empleadoResponse.setTelefono(empleadosRequest.getTelefono());
         Date fechaNacimiento = formato.parse(empleadosRequest.getFechaNacimiento());
         empleadoResponse.setFechaNacimiento(fechaNacimiento);
         if (empleadosRequest.isEstadoVacuna()) {
            Optional<TipoVacunas> tipoVacuna = this.tipoVacunasRepository.findById(Long.parseLong(empleadosRequest.getTipoVacuna()));
            empleadoResponse.setTipoVacuna((TipoVacunas)tipoVacuna.get());
            Date fechaVacunacion = formato.parse(empleadosRequest.getFechaVacunacion());
            empleadoResponse.setFechaVacunacion(fechaVacunacion);
            empleadoResponse.setNumeroDosis(empleadosRequest.getNumeroDosis());
         } else {
            empleadoResponse.setTipoVacuna((TipoVacunas)null);
            empleadoResponse.setFechaVacunacion((Date)null);
            empleadoResponse.setNumeroDosis((String)null);
         }
      } else if (userCedula == null) {
         return new JwtRespuesta(false, "USUARIO NO REGISTRADO, COMUNIQUESE CON EL ADMINISTRADOR PARA QUE SE LE GENERE UN USUARIO Y CONTRASEÑA");
      }

      this.empleadosRepository.save(empleadoResponse);
      return new JwtRespuesta(true, "Empleado actualizado exitosamente");
   }

   public JwtRespuesta eliminarTrabajador(String username) {
      Empleados empleadoCedula = this.empleadosRepository.findByCedula(username);
      if (empleadoCedula != null) {
         this.empleadosRepository.deleteById(empleadoCedula.getIdEmpleado());
         return new JwtRespuesta(true, "Empleado eliminado exitosamente");
      } else {
         return new JwtRespuesta(false, "Empleado no eliminado");
      }
   }
}
