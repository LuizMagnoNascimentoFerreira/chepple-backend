package com.ceuma.chepple.repository;

import com.ceuma.chepple.model.entity.FeedBack;
import com.ceuma.chepple.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack,Integer> {
}
