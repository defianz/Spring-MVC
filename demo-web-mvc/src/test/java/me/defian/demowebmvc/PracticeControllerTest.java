package me.defian.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class PracticeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void problem() throws Exception {
        mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/events/2"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(get("/events/3"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(post("/events")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(delete("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(delete("/events/2"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(delete("/events/3"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(put("/events/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(put("/events/2")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }
}