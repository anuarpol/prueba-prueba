package com.misiontic.materialesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.materialesapi.entity.Materiales;
import com.misiontic.materialesapi.services.MaterialesService;

@RestController
public class MaterialesController {

	@Autowired
	private MaterialesService materialesService;

	@GetMapping(value = "/materiales/{materialesId}")
	public ResponseEntity<Materiales> findById(@PathVariable("materialesId") Long materialesId) {
		Materiales materiales = materialesService.findById(materialesId);
		return new ResponseEntity<Materiales>(materiales, HttpStatus.OK);
	}

	@DeleteMapping(value = "/materiales/{materialesId}")
	public ResponseEntity<Void> delete(@PathVariable("materialesId") Long materialesId) {
		materialesService.delete(materialesId);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping(value = "/materiales")
	public ResponseEntity<List<Materiales>> findAll() {
		List<Materiales> materiales = materialesService.findAll();
		return new ResponseEntity<List<Materiales>>(materiales, HttpStatus.OK);
	}

	@PostMapping(value = "/materiales")
	public ResponseEntity<Materiales> create(@RequestBody Materiales materiales) {
		Materiales nuevoMaterial = materialesService.create(materiales);
		return new ResponseEntity<Materiales>(nuevoMaterial, HttpStatus.CREATED);
	}

	@PutMapping(value = "/materiales")
	public ResponseEntity<Materiales> update(@RequestBody Materiales materiales) {
		Materiales existeMaterial = materialesService.update(materiales);
		return new ResponseEntity<Materiales>(existeMaterial, HttpStatus.OK);
	}

}
