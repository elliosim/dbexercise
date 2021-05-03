package com.example.dbexercise.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NaceDetailsController.class)
public class NaceDetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NaceService service;

    @Test
    public void testPutNaceDetailsAcceptsAFile() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "NACE_REV2_TEST.csv",
                "text/plain", getCsvData().getBytes());

        mockMvc.perform(
                MockMvcRequestBuilders.multipart("/api/putNaceDetails").file(file)
        ).andDo(print()).andExpect(
                status().isOk());

        verify(service).saveNaceItems(anyList());
    }

    @Test
    public void shouldGetNaceDetails() throws Exception {
        when(service.getNaceDetails(398481L)).thenReturn(getNaceItem());

        mockMvc.perform(get("/api/getNaceDetails/398481"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.order", is(398481)))
                .andExpect(jsonPath("$.level", is(1)))
                .andExpect(jsonPath("$.code", is("A")))
                .andExpect(jsonPath("$.description", is("AGRICULTURE, FORESTRY AND FISHING")))
                .andExpect(jsonPath("$.thisItemIncludes", is("This section includes the exploitation of")))
                .andExpect(jsonPath("$.referenceToISICRev4", is("A"))
        );
    }

    private NaceItem getNaceItem() {
        return new NaceItem(
                398481L,1,"A", "",
                "AGRICULTURE, FORESTRY AND FISHING",
                "This section includes the exploitation of",
                "", "", "", "A"
        );
    }

    private String getCsvData() {
        String csvData = "\"Order\",\"Level\",\"Code\",\"Parent\",\"Description\",\"This item includes\"," +
                "\"This item also includes\",\"Rulings\",\"This item excludes\",\"Reference to ISIC Rev. 4\"\n" +
                "\"398481\",\"1\",\"A\",,\"AGRICULTURE, FORESTRY AND FISHING\",\"This section includes the exploitation of\",,,,\"A\"";
        return csvData;
    }
}
