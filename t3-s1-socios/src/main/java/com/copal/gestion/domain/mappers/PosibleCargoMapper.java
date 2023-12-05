package com.copal.gestion.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.copal.gestion.domain.dtos.requests.PosibleCargoRequest;
import com.copal.gestion.domain.dtos.responses.PosibleCargoResponse;
import com.copal.gestion.domain.entities.PosibleCargo;

@Mapper(componentModel = "spring")
public interface PosibleCargoMapper {
    PosibleCargoResponse entityToDto(PosibleCargo posibleCargo);
    @Mappings(
        {
            @Mapping(target = "idPosibleCargo", ignore = true),
        }
    )
    PosibleCargo dtoToEntity(PosibleCargoRequest request);
    Iterable<PosibleCargoResponse> entitiesToDtos(Iterable<PosibleCargo> posibleCargos);
    Iterable<PosibleCargo> dtosToEntities(Iterable<PosibleCargoResponse> posibleCargoResponses);
}
