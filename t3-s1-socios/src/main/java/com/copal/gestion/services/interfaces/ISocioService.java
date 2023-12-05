package com.copal.gestion.services.interfaces;

import com.copal.gestion.domain.dtos.requests.SocioRequest;
import com.copal.gestion.domain.dtos.responses.SocioResponse;
import java.time.LocalDateTime;

public interface ISocioService extends CrudService<SocioRequest, SocioResponse, Long> {
    Iterable<SocioResponse> findByNombreSocios(String nombreSocio);
    Iterable<SocioResponse> findByFechaAlta(LocalDateTime fechaAlta);
    Iterable<SocioResponse> findByTipoSocio(String tipoSocio);
    SocioResponse findByNombreSocio(String nombreSocio);
    SocioResponse findByEmail(String email);
    SocioResponse findByCuit(String cuit);
    SocioResponse findByPaginaWeb(String paginaWeb);
}
