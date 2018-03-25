package com.cxtx.service;

import com.cxtx.entity.Entities;

public interface EntityService {
    Entities findById(Long id);

    Entities addEntity(Entities entities);

    Entities findByName(String name);
}
