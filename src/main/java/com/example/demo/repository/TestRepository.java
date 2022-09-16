package com.example.demo.repository;

import com.example.demo.entity.TestEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity,Long> { // generic

    boolean existsByPhoneNumber(String phoneNumber);

    List<TestEntity> gmailContaining(String gmail);

//TestEntity findByPhoneNumber(String name);
}
