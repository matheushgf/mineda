package com.fatec.lab.mineda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Autorizacao implements GrantedAuthority{

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUT_ID")
	private Long id;
	
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
