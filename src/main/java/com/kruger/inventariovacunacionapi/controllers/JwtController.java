package com.kruger.inventariovacunacionapi.controllers;
import com.kruger.inventariovacunacionapi.message.request.JwtRequest;
import com.kruger.inventariovacunacionapi.message.response.JwtResponse;
import com.kruger.inventariovacunacionapi.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author MaiteMejia
 */
@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
