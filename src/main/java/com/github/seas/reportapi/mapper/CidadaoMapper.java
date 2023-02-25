package com.github.seas.reportapi.mapper;

import com.github.seas.reportapi.domain.dto.CidadaoDto;
import com.github.seas.reportapi.domain.Cidadao;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class CidadaoMapper {

    private final MapperFacade mapperFacade;

    public CidadaoMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Cidadao.class, CidadaoDto.class).exclude("id")
//                .field("nome","nome")
//                .field("dataNascimento","dataNascimento")
//                .field("sexo","sexo")
//                .field("cor","cor")
//                .field("cidadeNascimento","cidadeNascimento")
//                .field("fonteDeRenda","fonteDeRenda")
//                .field("querSairDasRuas","querSairDasRuas")
//                .field("motivos","motivos")
//                .field("casosEspeciais","casosEspeciais")
//                .field("beneficios","beneficios")
                .register();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    public Cidadao convertCidadaoCreateDtoToCidadao(CidadaoDto cidadaoDto) {
        return mapperFacade.map(cidadaoDto, Cidadao.class);
    }

    public CidadaoDto convertCidadaoToCidadaoCreateDto(Cidadao cidadao){
        return mapperFacade.map(cidadao, CidadaoDto.class);
    }

}
