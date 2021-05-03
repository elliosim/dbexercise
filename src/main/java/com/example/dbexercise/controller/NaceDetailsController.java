package com.example.dbexercise.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("api")
public class NaceDetailsController {

    @Autowired
    private NaceService naceService;

    @PostMapping("/putNaceDetails")
    public void putNaceDetails(@RequestParam("file") MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            List<NaceItem> naceItems = new CsvToBeanBuilder<NaceItem>(reader)
                    .withType(NaceItem.class).build().parse();

            naceService.saveNaceItems(naceItems);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping(value = "/getNaceDetails/{orderId}")
    public NaceItem getNaceDetails(@PathVariable("orderId") long orderId) {
        return naceService.getNaceDetails(orderId);
    }
}
