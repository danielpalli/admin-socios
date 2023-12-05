package com.copal.gestion.domain.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.copal.gestion.domain.dtos.requests.DepartamentoRequest;
import com.copal.gestion.domain.dtos.responses.DepartamentoResponse;
import com.copal.gestion.domain.entities.Departamento;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper { 
    DepartamentoResponse entityToDto(Departamento departamento);
    @Mappings(
        {
            @Mapping(target = "idDepartamento", ignore = true),
        }
    )
    Departamento dtoToEntity(DepartamentoRequest request);
    Iterable<DepartamentoResponse> entitiesToDtos(Iterable<Departamento> departamentos);
    Iterable<Departamento> dtosToEntities(Iterable<DepartamentoResponse> departamentoResponses);   
}
