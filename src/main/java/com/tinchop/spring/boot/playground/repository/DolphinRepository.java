package com.tinchop.spring.boot.playground.repository;

import com.tinchop.spring.boot.playground.model.animal.Dolphin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DolphinRepository extends JpaRepository<Dolphin, Long> {
}
