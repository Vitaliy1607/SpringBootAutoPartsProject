package com.autoparts.parts.controller;

import com.autoparts.parts.entity.PartEntity;
import com.autoparts.parts.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "parts")
public class PartController {

    @Autowired
    private PartService partService;

    @PostMapping
    private ResponseEntity<?> addPart(@RequestBody PartEntity partEntity){
        partService.addPart(partEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PartEntity>> getAllParts(){
        List<PartEntity> parts = partService.findAllParts();
        return new ResponseEntity<>(parts,HttpStatus.OK);
    }
}
