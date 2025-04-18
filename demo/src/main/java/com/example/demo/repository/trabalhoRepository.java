package com.example.demo.repository;

import com.example.demo.models.TrabalhoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface trabalhoRepository extends JpaRepository<TrabalhoModel, Long> {

}