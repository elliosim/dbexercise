package com.example.dbexercise.repository;

import com.example.dbexercise.model.NaceItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NaceRepositoryTest {

    @Autowired
    private NaceRepository naceRepository;

    @Test
    public void testCanPersistAndRetrieveNaceItem() {
        NaceItem naceItem = naceRepository.save(getNaceItem());
        NaceItem foundNaceItem = naceRepository.findById(naceItem.getOrder()).get();

        assertNotNull(foundNaceItem);
        assertEquals(naceItem.getDescription(), foundNaceItem.getDescription());
    }

    private NaceItem getNaceItem() {
        return new NaceItem(
                398481L,1,"A", "",
                "AGRICULTURE, FORESTRY AND FISHING",
                "This section includes the exploitation of",
                "", "", "", "A"
        );
    }
}