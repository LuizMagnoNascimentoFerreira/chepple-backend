package com.ceuma.chepple.dto.teacher;

import com.ceuma.chepple.model.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherRegisterDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    public TeacherRegisterDTO(Teacher teacher){
        this.firstName = teacher.getFirstName();
        this.lastName = teacher.getLastName();
    }
}
