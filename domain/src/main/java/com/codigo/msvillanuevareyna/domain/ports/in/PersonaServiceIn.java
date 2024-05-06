package com.codigo.msvillanuevareyna.domain.ports.in;

import com.codigo.msvillanuevareyna.domain.aggregates.dto.PersonaDto;
import com.codigo.msvillanuevareyna.domain.aggregates.request.PersonaRequest;

import java.util.List;
import java.util.Optional;

public interface PersonaServiceIn {
    PersonaDto crearPersonaIn(PersonaRequest personaRequest);
    Optional<PersonaDto> buscarPorIdIn(Long id);
    List<PersonaDto> buscarTodosIn();
    PersonaDto actualizarIn();
    PersonaDto deleteIn();
}
