package com.tinchop.spring.boot.playground.repository;

import com.tinchop.spring.boot.playground.model.Owl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwlRepository extends JpaRepository<Owl, Long> {
}
