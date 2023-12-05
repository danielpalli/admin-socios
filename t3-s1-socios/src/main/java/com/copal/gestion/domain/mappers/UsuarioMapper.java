package com.copal.gestion.domain.mappers;

import com.copal.gestion.domain.dtos.requests.UsuarioRequest;
import com.copal.gestion.domain.dtos.responses.UsuarioResponse;
import com.copal.gestion.domain.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioResponse entityToDto(Usuario usuario);
    @Mappings(
            {
                    @Mapping(target = "idUsuario", ignore = true),
            }
    )
    Usuario dtoToEntity(UsuarioRequest request);
    Iterable<UsuarioResponse> entitiesToDtos(Iterable<Usuario> usuarios);
    Iterable<Usuario> dtosToEntities(Iterable<UsuarioResponse> usuarioResponses);
}
