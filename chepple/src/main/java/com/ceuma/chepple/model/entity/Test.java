package com.ceuma.chepple.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "teacher_id")
    @ManyToOne
    private Teacher teacher;
    @JoinColumn(name = "discipline_id")
    @OneToOne
    private Discipline discipline;
    @Column(name = "file_path")
    private String filePath;
    @Column(name="publication_date")
    private LocalDateTime publicationDate;
}
