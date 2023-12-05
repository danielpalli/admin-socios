package com.copal.gestion.services.implementations;

import com.copal.gestion.domain.dtos.requests.UsuarioRequest;
import com.copal.gestion.domain.dtos.responses.UsuarioResponse;
import com.copal.gestion.domain.entities.Usuario;
import com.copal.gestion.domain.mappers.UsuarioMapper;
import com.copal.gestion.domain.repositories.UsuarioRepository;
import com.copal.gestion.services.interfaces.IUsuarioService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    @Override
    public UsuarioResponse create(UsuarioRequest request) {
        Usuario usuarioEntity = this.usuarioMapper.dtoToEntity(request);
        UsuarioResponse usuarioDto = this.usuarioMapper.entityToDto(this.usuarioRepository.save(usuarioEntity));
        return usuarioDto;
    }

    @Override
    public UsuarioResponse update(UsuarioRequest request, Long id) {
        Usuario usuarioEntity = this.usuarioRepository.findById(id).orElse(null);
        UsuarioResponse usuarioDto = this.usuarioMapper.entityToDto(usuarioEntity);
        return usuarioDto;
    }

    @Override
    public boolean delete(Long id) {
        this.usuarioRepository.deleteById(id);
        return true;
    }

    @Override
    public UsuarioResponse getById(Long id) {
        Usuario usuarioEntity = this.usuarioRepository.findById(id).orElse(null);
        UsuarioResponse usuarioDto = this.usuarioMapper.entityToDto(usuarioEntity);
        return usuarioDto;
    }

    @Override
    public Iterable<UsuarioResponse> getAll() {
        Iterable<Usuario> usuarios = this.usuarioRepository.findAll();
        Iterable<UsuarioResponse> usuariosDto = this.usuarioMapper.entitiesToDtos(usuarios);
        return usuariosDto;
    }
}
