package com.ceuma.chepple.controller;

import com.ceuma.chepple.dto.teacher.TeacherRegisterDTO;
import com.ceuma.chepple.model.entity.Teacher;
import com.ceuma.chepple.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    @PostMapping
    public ResponseEntity save(@RequestBody Teacher teacher){
        Teacher savedTeacher = teacherRepository.save(teacher);
        return new ResponseEntity(savedTeacher.getId(),HttpStatus.OK);
    }
    public ResponseEntity findAll(){
        List<TeacherRegisterDTO> teacherRegisterDTOList = new ArrayList();
        teacherRepository.findAll().forEach((teacher)->{
            teacherRegisterDTOList.add(new TeacherRegisterDTO(teacher));
        });
        return new ResponseEntity(teacherRegisterDTOList,HttpStatus.OK);
    }
    public ResponseEntity findById(@RequestParam Integer id){
        return new ResponseEntity(new TeacherRegisterDTO(teacherRepository.findById(id).get()),HttpStatus.OK);
    }
    public ResponseEntity update(){
        return new ResponseEntity(HttpStatus.OK);
    }
    public ResponseEntity delete(){
        return new ResponseEntity(HttpStatus.OK);
    }

}
