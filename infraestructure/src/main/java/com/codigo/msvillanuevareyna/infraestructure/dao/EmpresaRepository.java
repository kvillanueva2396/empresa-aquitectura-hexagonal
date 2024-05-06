package com.codigo.msvillanuevareyna.infraestructure.dao;

import com.codigo.msvillanuevareyna.infraestructure.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
