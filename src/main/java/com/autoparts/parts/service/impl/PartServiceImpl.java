package com.autoparts.parts.service.impl;

import com.autoparts.parts.entity.PartEntity;
import com.autoparts.parts.repository.PartRepository;
import com.autoparts.parts.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartRepository partRepository;

    @Override
    public void addPart(PartEntity part) {
            partRepository.save(part);
    }

    @Override
    public List<PartEntity> findAllParts() {
        List<PartEntity> parts = partRepository.findAll();
        return parts;
    }
}
