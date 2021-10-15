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
				orElseThrow(() -> new RuntimeException("No existe el perfil."));
		return materiales;
	}

	@Transactional
	public void delete(Long materialesId) {
		Materiales materiales = materialesRepo.findById(materialesId)
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));
		materialesRepo.delete(materiales);
	}

	public List<Materiales> findAll() {
		List<Materiales> perfiles = materialesRepo.findAll();
		return perfiles;
	}

	@Transactional
	public Materiales create(Materiales materiales) {
		MaterialesValidator.save(materiales);
		
		Materiales nuevoPerfil = materialesRepo.save(materiales);
		return nuevoPerfil;
	}

	@Transactional
	public Materiales update(Materiales materiales) {
		MaterialesValidator.save(materiales);
		
		Materiales existePerfil = materialesRepo.findById(materiales.getId())
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));

		existePerfil.setNombre(materiales.getNombre());
		
		materialesRepo.save(existePerfil);
		return existePerfil;
	}
}
