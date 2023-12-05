package com.copal.gestion.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.copal.gestion.domain.entities.PosibleCargo;

@Repository
public interface PosibleCargoRepository extends JpaRepository<PosibleCargo , Long> {}