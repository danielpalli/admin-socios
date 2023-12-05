package com.copal.gestion.domain.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.copal.gestion.domain.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento ,Long> {}