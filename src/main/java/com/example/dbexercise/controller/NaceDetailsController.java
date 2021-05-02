package com.example.dbexercise.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("api")
public class NaceDetailsController {

    @PostMapping("/putNaceDetails")
    public void putNaceDetails(@RequestParam("file") MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            List<NaceItem> beans = new CsvToBeanBuilder(reader)
                    .withType(NaceItem.class).build().parse();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
