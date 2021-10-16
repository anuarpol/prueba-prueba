package com.misiontic.materialesapi.validators;

import com.misiontic.materialesapi.entity.Materiales;

public class MaterialesValidator {

	public static void save(Materiales materiales) {
		
		if(materiales.getNombre() == null || materiales.getNombre().trim().isEmpty()) {
			throw new RuntimeException("El nombre del material es obligatorio.");
		}
		
		if(materiales.getNombre().length() > 100) {
			throw new RuntimeException("El nombre del material es muy largo maximo 100 caracteres.");
		}
	}
	
}
