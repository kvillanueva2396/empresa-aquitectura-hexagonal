package com.codigo.msvillanuevareyna.domain.ports.in;

import com.codigo.msvillanuevareyna.domain.aggregates.dto.EmpresaDto;
import com.codigo.msvillanuevareyna.domain.aggregates.request.EmpresaRequest;

import java.util.List;
import java.util.Optional;

public interface EmpresaServiceIn {
    EmpresaDto crearEmpresaIn(EmpresaRequest empresaRequest);
    Optional<EmpresaDto> buscarPorIdIn(Long id);
    List<EmpresaDto> buscarTodosIn();
    EmpresaDto actualizarIn(Long id, EmpresaRequest empresaRequest);
    EmpresaDto deleteIn(Long id);
}
