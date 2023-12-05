package com.copal.gestion.services.implementations;

import com.copal.gestion.domain.entities.Domicilio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.copal.gestion.domain.dtos.requests.SocioRequest;
import com.copal.gestion.domain.dtos.responses.SocioResponse;
import com.copal.gestion.domain.entities.Socio;
import com.copal.gestion.domain.mappers.SocioMapper;
import com.copal.gestion.domain.repositories.SocioRepository;
import com.copal.gestion.services.interfaces.ISocioService;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class SocioServiceImpl implements ISocioService {
    private final SocioRepository socioRepository;
    private final SocioMapper socioMapper;

    @Override
    public SocioResponse create(SocioRequest request) {

        Domicilio domicilio = Domicilio.builder().calle(request.getDomicilio().getCalle())
                .altura(request.getDomicilio().getAltura()).departamento(request.getDomicilio().getDepartamento())
                .piso(request.getDomicilio().getPiso()).localidad(request.getDomicilio().getLocalidad())
                .provincia(request.getDomicilio().getProvincia()).build();

        Socio socioEntity = this.socioMapper.dtoToEntity(request);
        socioEntity.setDomicilio(domicilio);
        socioEntity.setFechaAlta(LocalDateTime.now());
        socioEntity.setFechaModificacion(LocalDateTime.now());
        socioEntity.setFechaBaja(null);
        socioEntity.setActivo(true);

        socioEntity = this.socioRepository.save(socioEntity);

        SocioResponse socioDto = this.socioMapper.entityToDto(socioEntity);
        return socioDto;
    }

    @Override
    public SocioResponse update(SocioRequest request, Long id) {
        Optional<Socio> searchSocio = this.socioRepository.findById(id);

        if (searchSocio.isEmpty()) {
            return null;
        }

        Socio socioEntity = searchSocio.get();

        if (Objects.equals(socioEntity.getNombreSocio(), request.getNombreSocio()) &&
                Objects.equals(socioEntity.getCuit(), request.getCuit()) &&
                Objects.equals(socioEntity.getEmail(), request.getEmail()) &&
                Objects.equals(socioEntity.getPaginaWeb(), request.getPaginaWeb()) &&
                Objects.equals(socioEntity.getDomicilio().getCalle(), request.getDomicilio().getCalle()) &&
                Objects.equals(socioEntity.getDomicilio().getAltura(), request.getDomicilio().getAltura()) &&
                Objects.equals(socioEntity.getDomicilio().getDepartamento(), request.getDomicilio().getDepartamento())
                &&
                Objects.equals(socioEntity.getDomicilio().getPiso(), request.getDomicilio().getPiso()) &&
                Objects.equals(socioEntity.getDomicilio().getLocalidad(), request.getDomicilio().getLocalidad()) &&
                Objects.equals(socioEntity.getDomicilio().getProvincia(), request.getDomicilio().getProvincia()) &&
                Objects.equals(socioEntity.getTipoSocio(), request.getTipoSocio()) &&
                Objects.equals(socioEntity.getArea(), request.getArea())) {
            return null;
        }

        socioEntity.setFechaModificacion(LocalDateTime.now());
        this.socioMapper.updateSocioFromDto(request, socioEntity);
        SocioResponse socioDto = this.socioMapper.entityToDto(socioEntity);
        return socioDto;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Socio> searchSocio = this.socioRepository.findById(id);

        if (searchSocio.isEmpty()) {
            return false;
        }

        this.socioRepository.deleteById(id);

        return true;
    }

    @Override
    public SocioResponse getById(Long id) {
        Socio socioEntity = this.socioRepository.findById(id).orElse(null);
        SocioResponse socioDto = this.socioMapper.entityToDto(socioEntity);
        return socioDto;
    }

    @Override
    public Iterable<SocioResponse> getAll() {
        Iterable<Socio> socios = this.socioRepository.findAll();
        Iterable<SocioResponse> sociosDto = this.socioMapper.entitiesToDtos(socios);
        return sociosDto;
    }

    @Override
    public Iterable<SocioResponse> findByNombreSocios(String nombre) {
        return this.socioMapper.entitiesToDtos(this.socioRepository.findByNombreSocios(nombre));
    }

    @Override
    public Iterable<SocioResponse> findByFechaAlta(LocalDateTime fechaAlta) {
        return this.socioMapper.entitiesToDtos(this.socioRepository.findByFechaAlta(fechaAlta));
    }

    @Override
    public Iterable<SocioResponse> findByTipoSocio(String tipoSocio) {
        return this.socioMapper.entitiesToDtos(this.socioRepository.findByTipoSocio(tipoSocio));
    }

    @Override
    public SocioResponse findByEmail(String email) {
        Socio socioEntity = this.socioRepository.findByEmail(email);
        SocioResponse socioDto = this.socioMapper.entityToDto(socioEntity);
        return socioDto;
    }

    @Override
    public SocioResponse findByCuit(String cuit) {
        Socio socioEntity = this.socioRepository.findByCuit(cuit);
        SocioResponse socioDto = this.socioMapper.entityToDto(socioEntity);
        return socioDto;
    }

    @Override
    public SocioResponse findByNombreSocio(String nombreSocio) {
        Socio socioEntity = this.socioRepository.findByNombreSocio(nombreSocio);
        SocioResponse socioDto = this.socioMapper.entityToDto(socioEntity);
        return socioDto;
    }

    @Override
    public SocioResponse findByPaginaWeb(String paginaWeb) {
        Socio socioEntity = this.socioRepository.findByPaginaWeb(paginaWeb);
        SocioResponse socioDto = this.socioMapper.entityToDto(socioEntity);
        return socioDto;
    }
}
