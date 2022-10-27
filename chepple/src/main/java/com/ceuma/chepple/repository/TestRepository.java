package com.ceuma.chepple.repository;

import com.ceuma.chepple.model.entity.Teacher;
import com.ceuma.chepple.model.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {
}
