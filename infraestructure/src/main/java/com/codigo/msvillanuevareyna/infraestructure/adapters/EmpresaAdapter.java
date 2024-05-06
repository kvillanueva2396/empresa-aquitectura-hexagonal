package com.codigo.msvillanuevareyna.infraestructure.adapters;

import com.codigo.msvillanuevareyna.domain.aggregates.constants.Constants;
import com.codigo.msvillanuevareyna.domain.aggregates.dto.EmpresaDto;
import com.codigo.msvillanuevareyna.domain.aggregates.dto.SunatDto;
import com.codigo.msvillanuevareyna.domain.aggregates.request.EmpresaRequest;
import com.codigo.msvillanuevareyna.domain.ports.out.EmpresaServiceOut;
import com.codigo.msvillanuevareyna.infraestructure.client.ClientSunat;
import com.codigo.msvillanuevareyna.infraestructure.dao.EmpresaRepository;
import com.codigo.msvillanuevareyna.infraestructure.entity.EmpresaEntity;
import com.codigo.msvillanuevareyna.infraestructure.mapper.EmpresaMapper;
import com.codigo.msvillanuevareyna.infraestructure.redis.RedisService;
import com.codigo.msvillanuevareyna.infraestructure.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaAdapter implements EmpresaServiceOut {
    private final EmpresaRepository empresaRepository;
    private final ClientSunat clientSunat;
    private final RedisService redisService;

    @Value("${token.reniec}")
    private String tokenReniec;

    @Override
    public EmpresaDto crearEmpresaOut(EmpresaRequest empresaRequest) {
        EmpresaEntity empresaEntity = getEmpresaCreate(empresaRequest);
        empresaEntity.setUsuaCrea(Constants.USER_ADMIN);
        empresaEntity.setDateCreate(getTimestamp());
        return EmpresaMapper.fromEntity(empresaRepository.save(empresaEntity));
    }

    private EmpresaEntity getEmpresaCreate(EmpresaRequest empresaRequest) {
        SunatDto sunatDto = getExecutionSunat(empresaRequest.getNumDoc());

        EmpresaEntity entity = new EmpresaEntity();
        entity.setRazonSocial(sunatDto.getRazonSocial());
        entity.setTipoDocumento(sunatDto.getTipoDocumento());
        entity.setNumeroDocumento(sunatDto.getNumeroDocumento());
        entity.setEstado(Constants.STATUS_ACTIVE);
        entity.setCondicion(sunatDto.getCondicion());
        entity.setDireccion(sunatDto.getDireccion());
        entity.setDistrito(sunatDto.getDistrito());
        entity.setProvincia(sunatDto.getProvincia());
        entity.setDepartamento(sunatDto.getDepartamento());
        entity.setEsAgenteRetencion(sunatDto.getEsAgenteRetencion());
        return entity;
    }

    private Timestamp getTimestamp(){
        long currenTIme = System.currentTimeMillis();
        return new Timestamp(currenTIme);
    }

    private SunatDto getExecutionSunat(String numero) {
        String authorization = "Bearer " + tokenReniec;
        SunatDto datosSunat = clientSunat.getInfoSunat(numero, authorization);
        return datosSunat;
    }

    private Optional<EmpresaDto> buscarEmpresa(Long id) {
        String redisInfo = redisService.getFromRedis(Constants.REDIS_KEY_OBTENERPERSONA + id);

        if (redisInfo == null) {
            EmpresaDto empresaDto = EmpresaMapper.fromEntity(empresaRepository.findById(id).get());
            String dataForReds = Util.convertirAString(empresaDto);
            redisService.saveInRedis(Constants.REDIS_KEY_OBTENERPERSONA + id, dataForReds, 2);
            return Optional.of(empresaDto);
        }

        return Optional.of(Util.convertirDesdeString(redisInfo, EmpresaDto.class));
    }

    @Override
    public Optional<EmpresaDto> buscarPorIdOut(Long id) {
        return buscarEmpresa(id);
    }

    @Override
    public List<EmpresaDto> buscarTodosOut() {
        List<EmpresaDto> listDto = new ArrayList<>();
        List<EmpresaEntity> entidades = empresaRepository.findAll();
        for (EmpresaEntity dato :entidades) {
            listDto.add(EmpresaMapper.fromEntity(dato));
        }
        return listDto;
    }

    @Override
    public EmpresaDto actualizarOut(Long id, EmpresaRequest empresaRequest) {
//        Optional<EmpresaEntity> datoExtraido = empresaRepository.findById(id);
//
//        if (datoExtraido.isPresent()) {
//            EmpresaEntity entity = buscarEmpresa(id);
//            entity.setUsuaModif(Constants.USER_ADMIN);
//            entity.setDateModif(getTimestamp());
//
//            return EmpresaMapper.fromEntity(empresaRepository.save(entity));
//        } else {
//            throw new RuntimeException();
//        }
        //Aqui me quede...
        return null;
    }

    @Override
    public EmpresaDto deleteOut(Long id) {
        return null;
    }
}
