package com.ceuma.chepple.dto.test;

import com.ceuma.chepple.model.entity.Test;
import com.ceuma.chepple.repository.DisciplineRepository;
import com.ceuma.chepple.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestRegisterDTO {
    private Integer disciplineId;
    private Integer teacherId;
    private LocalDateTime publicationDate;
    public Test toTest(DisciplineRepository disciplineRepository, TeacherRepository teacherRepository){
        Test test = new Test();
        test.setDiscipline(disciplineRepository.findById(this.disciplineId).get());
        test.setTeacher(teacherRepository.findById(this.teacherId).get());
        test.setPublicationDate(LocalDateTime.now());
        return test;
    }
}
