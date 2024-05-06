package com.codigo.msvillanuevareyna.domain.impl;

import com.codigo.msvillanuevareyna.domain.aggregates.dto.EmpresaDto;
import com.codigo.msvillanuevareyna.domain.aggregates.request.EmpresaRequest;
import com.codigo.msvillanuevareyna.domain.ports.in.EmpresaServiceIn;
import com.codigo.msvillanuevareyna.domain.ports.out.EmpresaServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaServiceIn {
    private final EmpresaServiceOut empresaServiceOut;

    @Override
    public EmpresaDto crearEmpresaIn(EmpresaRequest empresaRequest) {
        return empresaServiceOut.crearEmpresaOut(empresaRequest);
    }

    @Override
    public Optional<EmpresaDto> buscarPorIdIn(Long id) {
        return empresaServiceOut.buscarPorIdOut(id);
    }

    @Override
    public List<EmpresaDto> buscarTodosIn() {
        return empresaServiceOut.buscarTodosOut();
    }

    @Override
    public EmpresaDto actualizarIn(Long id, EmpresaRequest empresaRequest) {
        return empresaServiceOut.actualizarOut(id, empresaRequest);
    }

    @Override
    public EmpresaDto deleteIn(Long id) {
        return empresaServiceOut.deleteOut(id);
    }
}
