package com.copal.gestion.services.interfaces;

public interface CrudService <RQ, RS, ID>{
    RS create(RQ request);
    RS update(RQ request, ID id);
    boolean delete(ID id);
    RS getById(ID id);
    Iterable<RS> getAll();
}
