package com.example.dbexercise.service;

import com.example.dbexercise.model.NaceItem;
import com.example.dbexercise.repository.NaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaceService {

    @Autowired
    private NaceRepository repository;

    public void saveNaceItems(List<NaceItem> naceItems) {
        repository.saveAll(naceItems);
    }

    public NaceItem getNaceDetails(long orderId) {
        return repository.findById(orderId).get();
    }
}
