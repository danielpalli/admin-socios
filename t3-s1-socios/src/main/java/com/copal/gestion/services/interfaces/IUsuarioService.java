package com.copal.gestion.services.interfaces;

import com.copal.gestion.domain.dtos.requests.UsuarioRequest;
import com.copal.gestion.domain.dtos.responses.UsuarioResponse;

public interface IUsuarioService extends CrudService<UsuarioRequest, UsuarioResponse, Long> {}
