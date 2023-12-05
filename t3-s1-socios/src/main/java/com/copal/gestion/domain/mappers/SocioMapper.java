package com.copal.gestion.domain.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.copal.gestion.domain.dtos.requests.SocioRequest;
import com.copal.gestion.domain.dtos.responses.SocioResponse;
import com.copal.gestion.domain.entities.Socio;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SocioMapper {
    SocioMapper INSTANCE = Mappers.getMapper(SocioMapper.class);
    SocioResponse entityToDto(Socio socio);
    @Mappings(
        {
            @Mapping(target = "idSocio", ignore = true),
            @Mapping(target = "fechaAlta", ignore = true),
            @Mapping(target = "fechaModificacion", ignore = true),
            @Mapping(target = "fechaBaja", ignore = true),
            @Mapping(target = "activo", ignore = true)
        }
    )
    Socio dtoToEntity(SocioRequest request);
    @Mappings(
        {
            @Mapping(target = "idSocio", ignore = true),
            @Mapping(target = "fechaAlta", ignore = true),
            @Mapping(target = "fechaModificacion", ignore = true),
            @Mapping(target = "fechaBaja", ignore = true),
            @Mapping(target = "activo", ignore = true)
        }
    )
    void updateSocioFromDto(SocioRequest request, @MappingTarget Socio socio);
    Iterable<SocioResponse> entitiesToDtos(Iterable<Socio> socios);
    Iterable<Socio> dtosToEntities(Iterable<SocioResponse> socioResponses);
}
