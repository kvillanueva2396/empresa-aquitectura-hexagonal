package com.codigo.msvillanuevareyna.infraestructure.mapper;

import com.codigo.msvillanuevareyna.domain.aggregates.dto.EmpresaDto;
import com.codigo.msvillanuevareyna.infraestructure.entity.EmpresaEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpresaMapper {
    public static EmpresaDto fromEntity(EmpresaEntity entity) {
        EmpresaDto dto = new EmpresaDto();
        dto.setId(entity.getId());
        dto.setRazonSocial(entity.getRazonSocial());
        dto.setTipoDocumento(entity.getTipoDocumento());
        dto.setEstado(entity.getEstado());
        dto.setCondicion(entity.getCondicion());
        dto.setDireccion(entity.getDireccion());
        dto.setDistrito(entity.getDistrito());
        dto.setProvincia(entity.getProvincia());
        dto.setDepartamento(entity.getDepartamento());
        dto.setEsAgenteRetencion(entity.getEsAgenteRetencion());
        dto.setUsuaCrea(entity.getUsuaCrea());
        dto.setDateCreate(entity.getDateCreate());
        dto.setUsuaModif(entity.getUsuaModif());
        dto.setDateModif(entity.getDateModif());
        dto.setUsuaDelet(entity.getUsuaDelet());
        dto.setDateDelet(entity.getDateDelet());
        return dto;
    }
}
