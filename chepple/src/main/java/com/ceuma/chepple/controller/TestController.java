package com.ceuma.chepple.controller;

import com.ceuma.chepple.dto.test.TestDTO;
import com.ceuma.chepple.dto.test.TestRegisterDTO;
import com.ceuma.chepple.model.entity.Test;
import com.ceuma.chepple.repository.DisciplineRepository;
import com.ceuma.chepple.repository.TeacherRepository;
import com.ceuma.chepple.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tests")
public class TestController {
    private Test savedTest;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @PostMapping
    public ResponseEntity save(@RequestBody TestRegisterDTO testRegisterDTO){
        savedTest = testRepository.save(testRegisterDTO.toTest(disciplineRepository,teacherRepository));
        return new ResponseEntity(savedTest.getId(),HttpStatus.CREATED);
    }
    @PostMapping
    @RequestMapping("/upload")
    public ResponseEntity upload(@RequestParam("id") Integer id,@RequestParam("file") MultipartFile file){
        String folderPath = "test-uploads//";
        Path saveFilePath = Paths.get(folderPath + UUID.randomUUID() + "-" + file.getOriginalFilename());
        File directory = new File(folderPath);
        if(!directory.exists()){
            directory.mkdir();
        }
        try{
            byte[] fileBytes = file.getBytes();
            Files.write(saveFilePath,fileBytes);
            Test test = testRepository.findById(id).get();
            test.setFilePath(saveFilePath.toString());
            testRepository.save(test);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity("Falha ao realizar o upload do arquivo" + file.getOriginalFilename(),HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity(saveFilePath.toString(),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity findAll(){
        List<TestDTO> testDTOList = new ArrayList<>();
        testRepository.findAll().forEach((test)->{
            testDTOList.add(new TestDTO(test));
        });
        return new ResponseEntity(testDTOList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id){
        return new ResponseEntity(new TestDTO(testRepository.findById(id).get()),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity update(){
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
    @DeleteMapping
    public ResponseEntity delete(){
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
}
