package com.ceuma.chepple.dto.discipline;

import com.ceuma.chepple.model.entity.Discipline;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DisciplineDTO {
    private String name;
    public DisciplineDTO(Discipline discipline){
        this.name = discipline.getName();
    }
    public Discipline toDiscipline(){
        Discipline discipline = new Discipline();
        discipline.setName(this.name);
        return discipline;
    }
}
