package com.kruger.inventariovacunacionapi.services;
import com.kruger.inventariovacunacionapi.entities.Usuarios;
import com.kruger.inventariovacunacionapi.message.request.JwtRequest;
import com.kruger.inventariovacunacionapi.message.response.JwtResponse;
import com.kruger.inventariovacunacionapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.kruger.inventariovacunacionapi.util.JwUtil;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author MaiteMejia
 */
@Service
public class JwtService implements UserDetailsService {
    @Autowired
    private JwUtil jwtUtil;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String username = jwtRequest.getUsername();
        String password = jwtRequest.getPassword();
        authenticate(username, password);

        UserDetails userDetails = loadUserByUsername(username);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        Usuarios user = usuarioRepository.findById(username).get();
        return new JwtResponse(user, newGeneratedToken);
    }
    

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios user = usuarioRepository.findById(username).get();

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
    
    private Set getAuthority(Usuarios usuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        usuario.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNombre()));
        });
        return authorities;
    }
    
    private void authenticate(String cedula, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(cedula, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
