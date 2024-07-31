package com.andreiyusupau.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {

    Optional<ExampleEntity> findFirstByOrderByCreatedAtDesc();

}
