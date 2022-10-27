package com.ceuma.chepple.dto.test;

import com.ceuma.chepple.model.entity.Test;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestDTO {
    private String disciplineName;
    private String teacherName;
    private String filePath;
    private LocalDateTime publicationDate;

    public TestDTO(Test test) {
        this.disciplineName = test.getDiscipline().getName();
        this.teacherName = String.format("%s %s",test.getTeacher().getFirstName(),test.getTeacher().getLastName());
        this.filePath = test.getFilePath();
        this.publicationDate = test.getPublicationDate();
    }
}
