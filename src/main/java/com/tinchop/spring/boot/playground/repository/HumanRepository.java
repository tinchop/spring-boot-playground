package com.tinchop.spring.boot.playground.repository;

import com.tinchop.spring.boot.playground.model.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Human, Long> {
}
