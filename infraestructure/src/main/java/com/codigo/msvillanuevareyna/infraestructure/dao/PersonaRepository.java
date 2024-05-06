package com.codigo.msvillanuevareyna.infraestructure.dao;

import com.codigo.msvillanuevareyna.infraestructure.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
