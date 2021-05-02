package com.example.dbexercise.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NaceDetailsController.class)
public class NaceDetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NaceService service;

    @Test
    public void testPutNaceDetailsAcceptsAFile() throws Exception {

        String csvData = "\"Order\",\"Level\",\"Code\",\"Parent\",\"Description\",\"This item includes\"," +
                "\"This item also includes\",\"Rulings\",\"This item excludes\",\"Reference to ISIC Rev. 4\"\n" +
                "\"398481\",\"1\",\"A\",,\"AGRICULTURE, FORESTRY AND FISHING\",\"This section includes the exploitation of\",,,,\"A\"";

        MockMultipartFile file = new MockMultipartFile(
                "file",
                "NACE_REV2_TEST.csv",
                "text/plain", csvData.getBytes());

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/putNaceDetails")
                .file(file))
                .andExpect(status().isOk());
    }
}
