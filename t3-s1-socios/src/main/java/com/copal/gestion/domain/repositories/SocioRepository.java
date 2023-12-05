package com.copal.gestion.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.copal.gestion.domain.entities.Socio;

import java.time.LocalDateTime;

@Repository
public interface SocioRepository extends JpaRepository<Socio,Long> {
    @Query("SELECT s FROM Socio s WHERE s.nombreSocio LIKE %?1%")
    Iterable<Socio> findByNombreSocios(String nombreSocio);
    Iterable<Socio> findByFechaAlta(LocalDateTime fechaAlta);
    Iterable<Socio> findByTipoSocio(String tipoSocio);
    Socio findByNombreSocio(String nombreSocio);
    Socio findByEmail(String email);
    Socio findByCuit(String cuit);
    Socio findByPaginaWeb(String paginaWeb);
}