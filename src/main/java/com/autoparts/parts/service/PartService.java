package com.autoparts.parts.service;

import com.autoparts.parts.entity.PartEntity;

import java.util.List;

public interface PartService {

    void addPart(PartEntity part);

    List<PartEntity> findAllParts();
}
