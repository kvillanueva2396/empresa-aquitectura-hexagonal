package com.codigo.msvillanuevareyna.domain.ports.out;

import com.codigo.msvillanuevareyna.domain.aggregates.dto.EmpresaDto;
import com.codigo.msvillanuevareyna.domain.aggregates.request.EmpresaRequest;

import java.util.List;
import java.util.Optional;

public interface EmpresaServiceOut {
    EmpresaDto crearEmpresaOut(EmpresaRequest empresaRequest);
    Optional<EmpresaDto> buscarPorIdOut(Long id);
    List<EmpresaDto> buscarTodosOut();
    EmpresaDto actualizarOut(Long id, EmpresaRequest empresaRequest);
    EmpresaDto deleteOut(Long id);
}
