package com.andreiyusupau.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExampleRepository2 extends JpaRepository<ExampleEntity, Long> {

    ExampleEntity findFirstByOrderByCreatedAtDesc();

}
