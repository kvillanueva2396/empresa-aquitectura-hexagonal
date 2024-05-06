package com.codigo.msvillanuevareyna.application.controller;

import com.codigo.msvillanuevareyna.domain.aggregates.dto.EmpresaDto;
import com.codigo.msvillanuevareyna.domain.aggregates.request.EmpresaRequest;
import com.codigo.msvillanuevareyna.domain.ports.in.EmpresaServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examen-hexagonal/v1/empresa")
@AllArgsConstructor
public class EmpresaController {
    private final EmpresaServiceIn empresaServiceIn;

    @PostMapping
    public ResponseEntity<EmpresaDto> crearEmpresa(@RequestBody EmpresaRequest empresaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaServiceIn.crearEmpresaIn(empresaRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDto> buscarPorid(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaServiceIn.buscarPorIdIn(id).get());
    }

    @GetMapping("/todos")
    public ResponseEntity<List<EmpresaDto>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaServiceIn.buscarTodosIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDto> actualizar(@PathVariable Long id, @RequestBody EmpresaRequest empresaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaServiceIn.actualizarIn(id, empresaRequest));
    }
}
