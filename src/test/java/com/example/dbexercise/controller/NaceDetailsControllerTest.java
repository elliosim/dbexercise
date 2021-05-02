package com.example.dbexercise.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class NaceDetailsControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testPutNaceDetailsAcceptsAFile() throws Exception {

        String data = "\"Order\",\"Level\",\"Code\",\"Parent\",\"Description\",\"This item includes\"," +
                "\"This item also includes\",\"Rulings\",\"This item excludes\",\"Reference to ISIC Rev. 4\"\n" +
                "\"398481\",\"1\",\"A\",,\"AGRICULTURE, FORESTRY AND FISHING\",\"This section includes the exploitation of\",,,,\"A\"";

        MockMultipartFile file = new MockMultipartFile(
                "file",
                "NACE_REV2_TEST.csv",
                "text/plain", data.getBytes());

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/putNaceDetails")
                .file(file))
            .andExpect(status().isOk());
    }
}
