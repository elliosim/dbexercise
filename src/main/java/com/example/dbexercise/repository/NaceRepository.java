package com.example.dbexercise.repository;

import com.example.dbexercise.model.NaceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceRepository
        extends JpaRepository<NaceItem, Long> {
}
