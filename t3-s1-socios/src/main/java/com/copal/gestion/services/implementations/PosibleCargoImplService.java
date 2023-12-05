package com.copal.gestion.services.implementations;

import com.copal.gestion.domain.entities.PosibleCargo;
import com.copal.gestion.domain.mappers.PosibleCargoMapper;
import com.copal.gestion.domain.repositories.PosibleCargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.copal.gestion.domain.dtos.requests.PosibleCargoRequest;
import com.copal.gestion.domain.dtos.responses.PosibleCargoResponse;
import com.copal.gestion.services.interfaces.IPosibleCargoService;

import jakarta.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PosibleCargoImplService implements IPosibleCargoService {
    private final PosibleCargoRepository posibleCargoRepository;
    private final PosibleCargoMapper posibleCargoMapper;
    @Override
    public PosibleCargoResponse create(PosibleCargoRequest request) {
        PosibleCargo posibleCargoEntity = this.posibleCargoMapper.dtoToEntity(request);
        PosibleCargoResponse posibleCargoDto = this.posibleCargoMapper.entityToDto(this.posibleCargoRepository.save(posibleCargoEntity));
        return posibleCargoDto;
    }

    @Override
    public PosibleCargoResponse update(PosibleCargoRequest request, Long id) {
        PosibleCargo posibleCargoEntity = this.posibleCargoRepository.findById(id).orElse(null);
        PosibleCargoResponse posibleCargoDto = this.posibleCargoMapper.entityToDto(this.posibleCargoRepository.save(posibleCargoEntity));
        return posibleCargoDto;
    }

    @Override
    public boolean delete(Long id) {
        this.posibleCargoRepository.deleteById(id);
        return true;
    }

    @Override
    public PosibleCargoResponse getById(Long id) {
        PosibleCargo posibleCargpEntity = this.posibleCargoRepository.findById(id).orElse(null);
        PosibleCargoResponse posibleCargoDto = this.posibleCargoMapper.entityToDto(posibleCargpEntity);
        return posibleCargoDto;
    }

    @Override
    public Iterable<PosibleCargoResponse> getAll() {
        Iterable<PosibleCargo> posiblesCargos = this.posibleCargoRepository.findAll();
        Iterable<PosibleCargoResponse> posibleCargosDto = this.posibleCargoMapper.entitiesToDtos(posiblesCargos);
        return posibleCargosDto;
    }
}
