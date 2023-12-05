package com.copal.gestion.services.interfaces;

import com.copal.gestion.domain.dtos.requests.DepartamentoRequest;
import com.copal.gestion.domain.dtos.responses.DepartamentoResponse;

public interface IDepartamentoService extends CrudService<DepartamentoRequest, DepartamentoResponse, Long> {}
