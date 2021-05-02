package com.example.dbexercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaceService {

    @Autowired
    private NaceRepository repository;

    public void saveNaceItems(List<NaceItem> naceItems) {
        System.out.println("Saving all items");
        System.out.println(naceItems);
        repository.saveAll(naceItems);
    }
}
