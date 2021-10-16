package com.misiontic.materialesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.materialesapi.entity.Materiales;
import com.misiontic.materialesapi.repository.MaterialeslRepository;
import com.misiontic.materialesapi.validators.MaterialesValidator;

@Service
public class MaterialesService {
	
	@Autowired
	private MaterialeslRepository materialesRepo;

	public Materiales findById(Long materialesId) {
		Materiales materiales = materialesRepo.findById(materialesId).
				orElseThrow(() -> new RuntimeException("No existe el material."));
		return materiales;
	}

	@Transactional
	public void delete(Long materialesId) {
		Materiales materiales = materialesRepo.findById(materialesId)
				.orElseThrow(() -> new RuntimeException("No existe el material."));
		materialesRepo.delete(materiales);
	}

	public List<Materiales> findAll() {
		List<Materiales> materiales = materialesRepo.findAll();
		return materiales;
	}

	@Transactional
	public Materiales create(Materiales materiales) {
		MaterialesValidator.save(materiales);
			
		Materiales nuevoMaterial = materialesRepo.save(materiales);
		return nuevoMaterial;
	}

	@Transactional
	public Materiales update(Materiales materiales) {
		MaterialesValidator.save(materiales);
		
		Materiales existeMaterial = materialesRepo.findById(materiales.getId())
				.orElseThrow(() -> new RuntimeException("No existe el Material."));

		existeMaterial.setNombre(materiales.getNombre());
		existeMaterial.setUn(materiales.getUn());
		existeMaterial.setCategoria(materiales.getCategoria());
		existeMaterial.setVunitario(materiales.getVunitario());
		existeMaterial.setIva(materiales.getIva());
		existeMaterial.setEstado(materiales.getEstado());
		
		materialesRepo.save(existeMaterial);
		return existeMaterial;
	}
}
