package com.ceuma.chepple.controller;

import com.ceuma.chepple.dto.discipline.DisciplineDTO;
import com.ceuma.chepple.model.entity.Discipline;
import com.ceuma.chepple.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {
    @Autowired
    private DisciplineRepository disciplineRepository;
    @PostMapping
    public ResponseEntity save(@RequestBody Discipline discipline){
        Discipline savedDiscipline = disciplineRepository.save(discipline);
        return new ResponseEntity(savedDiscipline.getId(), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity findAll(){
        List<DisciplineDTO> disciplineDTOList = new ArrayList<>();
        disciplineRepository.findAll().forEach((discipline)->{
            disciplineDTOList.add(new DisciplineDTO(discipline));
        });
        return new ResponseEntity(disciplineDTOList,HttpStatus.OK);
    }
}
