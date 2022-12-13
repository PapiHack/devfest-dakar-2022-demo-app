package sn.dakar.devfest.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import sn.dakar.devfest.demo.DemoApplication;
import sn.dakar.devfest.demo.config.ApplicationProperties;
import sn.dakar.devfest.demo.domain.dto.ApplicationInfosDTO;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DemoApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AppControllerIT {

    final static String READY_MSG = "DevFest Demo App is ready !";
    final static String HEALTHY_MSG = "DevFest Demo App is healthy !";

    @Autowired
    private MockMvc clientMockMvc;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Test
    public void testServiceHealthy() throws Exception {
        this.clientMockMvc
                .perform(get("/api/service/healthy"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
                .andExpect(content().string(HEALTHY_MSG));
    }

    @Test
    public void testServiceReady() throws Exception {
        this.clientMockMvc
                .perform(get("/api/service/ready"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
                .andExpect(content().string(READY_MSG));
    }

    @Test
    public void testGetAppInfos() throws Exception {
        ApplicationInfosDTO applicationInfosDTO = TestUtil.createAppInfos(
                this.applicationProperties.getName(),
                this.applicationProperties.getEnv(),
                this.applicationProperties.getVersion());
        this.clientMockMvc
                .perform(get("/api/service/infos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name").value(applicationInfosDTO.getName()))
                .andExpect(jsonPath("$.env").value(applicationInfosDTO.getEnv()))
                .andExpect(jsonPath("$.version").value(applicationInfosDTO.getVersion()));
    }
}
