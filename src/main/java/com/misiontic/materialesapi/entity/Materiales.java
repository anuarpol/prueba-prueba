package com.misiontic.materialesapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="Materiales")
public class Materiales {
	
	
	@Id
	@Column(name="cod")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;
	@Column(name="un")
	private String un;

	@Column(name="categoria")
	private String categoria;	
	@Column(name="vunitario")
	private String vunitario;	
	
	@Column(name="iva")
	private Integer iva;
	@Column(name="estado")
	private String estado;	
	

}
