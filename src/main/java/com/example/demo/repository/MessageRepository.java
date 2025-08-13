package com.example.demo.repository;

import com.example.demo.repository.entity.Message;
import com.example.demo.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
}


