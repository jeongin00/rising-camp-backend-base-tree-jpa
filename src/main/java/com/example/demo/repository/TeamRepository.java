package com.example.demo.repository;

import com.example.demo.repository.entity.Message;
import com.example.demo.repository.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
