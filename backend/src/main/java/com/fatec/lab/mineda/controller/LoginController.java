package com.fatec.lab.mineda.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fatec.lab.mineda.entity.Usuario;
import com.fatec.lab.mineda.security.JwtUtils;
import com.fatec.lab.mineda.security.Login;

@RestController
public class LoginController {
	
		@Autowired
	    private AuthenticationManager auth;
	    
	    @Autowired
	    private UserDetailsService segurancaService;

	    public void setAuth(AuthenticationManager auth) {
	        this.auth = auth;
	    }
	    
	    public void setSegurancaService(UserDetailsService segurancaService) {
	    	this.segurancaService = segurancaService;
	    }
	    
	    @RequestMapping(path = "/login", method = RequestMethod.POST)
	    @CrossOrigin(exposedHeaders = "Token")
	    public ResponseEntity<Usuario> login(@RequestBody Login login, HttpServletResponse response) throws JsonProcessingException {
	        Authentication credentials = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
	        Usuario usuario = (Usuario) auth.authenticate(credentials).getPrincipal();
	        response.setHeader("Token", JwtUtils.generateToken(usuario));
	        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	    }
	    
	    private String md5(String senha) {
			try {
				MessageDigest algorithm = MessageDigest.getInstance("MD5");
				byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		
				StringBuilder hexString = new StringBuilder();
				hexString.append("{MD5}");
				for (byte b : messageDigest) {
				  hexString.append(String.format("%02x", 0xFF & b));
				}
				return hexString.toString();
			} catch (NoSuchAlgorithmException exception) {
				exception.printStackTrace();
				// Unexpected - do nothing
			} catch (UnsupportedEncodingException exception) {
				exception.printStackTrace();
				// Unexpected - do nothing			
			} 
			return senha;
		}

}
