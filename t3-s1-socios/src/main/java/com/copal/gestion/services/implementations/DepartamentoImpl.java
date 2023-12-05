package com.copal.gestion.services.implementations;

import com.copal.gestion.domain.entities.Departamento;
import com.copal.gestion.domain.mappers.DepartamentoMapper;
import com.copal.gestion.domain.repositories.DepartamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.copal.gestion.domain.dtos.requests.DepartamentoRequest;
import com.copal.gestion.domain.dtos.responses.DepartamentoResponse;
import com.copal.gestion.services.interfaces.IDepartamentoService;

import jakarta.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class DepartamentoImpl implements IDepartamentoService{
    private final DepartamentoRepository departamentoRepository;
    private final DepartamentoMapper departamentoMapper;
    @Override
    public DepartamentoResponse create(DepartamentoRequest request) {
        Departamento departamentoEntity = this.departamentoMapper.dtoToEntity(request);
        DepartamentoResponse departamentoDto = this.departamentoMapper.entityToDto(this.departamentoRepository.save(departamentoEntity));
        return departamentoDto;
    }

    @Override
    public DepartamentoResponse update(DepartamentoRequest request, Long id) {
        Departamento departamentoEntity = this.departamentoRepository.findById(id).orElse(null);
        DepartamentoResponse departamentoDto = this.departamentoMapper.entityToDto(departamentoEntity);
        return departamentoDto;
    }

    @Override
    public boolean delete(Long id) {
        this.departamentoRepository.deleteById(id);
        return true;
    }

    @Override
    public DepartamentoResponse getById(Long id) {
        Departamento departamentoEntity = this.departamentoRepository.findById(id).orElse(null);
        DepartamentoResponse departamentosDto = this.departamentoMapper.entityToDto(departamentoEntity);
        return departamentosDto;
    }

    @Override
    public Iterable<DepartamentoResponse> getAll() {
        Iterable<Departamento> departamentos = this.departamentoRepository.findAll();
        Iterable<DepartamentoResponse> departamentosDto = this.departamentoMapper.entitiesToDtos(departamentos);
        return departamentosDto;
    }
    
}
