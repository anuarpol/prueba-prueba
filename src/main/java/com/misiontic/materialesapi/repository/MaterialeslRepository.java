package com.misiontic.materialesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.materialesapi.entity.Materiales;

@Repository
public interface MaterialeslRepository extends JpaRepository<Materiales, Long> {

}
