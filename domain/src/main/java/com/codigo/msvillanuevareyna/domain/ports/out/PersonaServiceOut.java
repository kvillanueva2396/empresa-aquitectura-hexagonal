package com.codigo.msvillanuevareyna.domain.ports.out;

import com.codigo.msvillanuevareyna.domain.aggregates.dto.PersonaDto;
import com.codigo.msvillanuevareyna.domain.aggregates.request.PersonaRequest;

import java.util.List;
import java.util.Optional;

public interface PersonaServiceOut {
    PersonaDto crearPersonaOut(PersonaRequest personaRequest);
    Optional<PersonaDto> buscarPorIdOut(Long id);
    List<PersonaDto> buscarTodosOut();
    PersonaDto actualizarOut();
    PersonaDto deleteOut();
}
