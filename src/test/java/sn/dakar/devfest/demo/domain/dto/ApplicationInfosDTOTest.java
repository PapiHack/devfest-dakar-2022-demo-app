package sn.dakar.devfest.demo.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import sn.dakar.devfest.demo.controller.TestUtil;

public class ApplicationInfosDTOTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ApplicationInfosDTO.class);
        ApplicationInfosDTO applicationInfosDTO = new ApplicationInfosDTO();
        applicationInfosDTO.env("test");
        ApplicationInfosDTO applicationInfosDTO2 = new ApplicationInfosDTO();
        applicationInfosDTO2.env("prod");
        assertThat(applicationInfosDTO).isNotEqualTo(applicationInfosDTO2);
        applicationInfosDTO2.env(applicationInfosDTO.getEnv());
        applicationInfosDTO.env("");
        assertThat(applicationInfosDTO).isNotEqualTo(applicationInfosDTO2);
    }
}
