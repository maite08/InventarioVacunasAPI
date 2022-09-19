package com.kruger.inventariovacunacionapi.services;

import com.kruger.inventariovacunacionapi.entities.Role;
import com.kruger.inventariovacunacionapi.entities.Usuarios;
import com.kruger.inventariovacunacionapi.message.response.JwtRespuesta;
import com.kruger.inventariovacunacionapi.repositories.EmpleadosRepository;
import com.kruger.inventariovacunacionapi.repositories.RolesRepository;
import com.kruger.inventariovacunacionapi.repositories.TipoVacunasRepository;
import com.kruger.inventariovacunacionapi.repositories.UsuarioRepository;
import com.kruger.inventariovacunacionapi.util.NumberUtil;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl {
   @Autowired
   private UsuarioRepository usuarioRepository;
   @Autowired
   private RolesRepository rolesRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;
   @Autowired
   EmpleadosRepository empleadosRepository;
   @Autowired
   TipoVacunasRepository tipoVacunasRepository;

   public void initRoleAndUser() {
      Role adminRole = new Role();
      adminRole.setNombre("Admin");
      adminRole.setRoleDescription("Rol administrador");
      adminRole.setEstadoRegistro(Boolean.TRUE);
      this.rolesRepository.save(adminRole);
      Role userRole = new Role();
      userRole.setNombre("Empleado");
      userRole.setRoleDescription("Rol por defecto: empleado");
      userRole.setEstadoRegistro(Boolean.TRUE);
      this.rolesRepository.save(userRole);
      Usuarios adminUser = new Usuarios();
      adminUser.setUsername("0831021028");
      adminUser.setPassword(this.getEncodedPassword("admin@pass"));
      Set<Role> adminRoles = new HashSet();
      adminRoles.add(adminRole);
      adminUser.setRole(adminRoles);
      this.usuarioRepository.save(adminUser);
   }

   public JwtRespuesta registrar(Usuarios user) throws Exception {
      Role role = (Role)this.rolesRepository.findById("Empleado").get();
      Set<Role> userRoles = new HashSet();
      userRoles.add(role);
      user.setRole(userRoles);
      String passwordTemporal = NumberUtil.getRandomNumberCharInRange(9);
      EmpleadosServiceImpl.LOG.info(user.toString());
      EmpleadosServiceImpl.LOG.info("temporal1:" + passwordTemporal);
      user.setPassword(this.getEncodedPassword(passwordTemporal));
      user.setNombres(user.getNombres());
      user.setApellidos(user.getApellidos());
      user.setCorreo(user.getCorreo());
      this.usuarioRepository.save(user);
      return new JwtRespuesta(true, "Usuario registrado exitosamenteSu usuario es:" + user.getUsername() + " Su contraseña temporal es:" + passwordTemporal);
   }

   public String getEncodedPassword(String password) {
      return this.passwordEncoder.encode(password);
   }
}
