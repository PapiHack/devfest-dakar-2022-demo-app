package sn.dakar.devfest.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import sn.dakar.devfest.demo.controller.TestUtil;
import sn.dakar.devfest.demo.domain.dto.ApplicationInfosDTO;

import static org.mockito.Mockito.*;

public class AppServiceTest {

    final static String READY_MSG = "Service is ready !";
    final static String HEALTHY_MSG = "Service is healthy !";
    final static String APP_NAME = "APP_TEST";
    final static String APP_ENV = "TEST";
    final static String APP_VERSION = "V1";

    @Test
    public void testServiceHealthy() {
        AppService mockAppService = mock(AppService.class);
        when(mockAppService.serviceHealthy(HEALTHY_MSG)).thenReturn(HEALTHY_MSG);
        String result = mockAppService.serviceHealthy(HEALTHY_MSG);
        verify(mockAppService, times(1)).serviceHealthy(HEALTHY_MSG);
        assertNotNull(result);
        assertEquals(HEALTHY_MSG, result);
    }

    @Test
    public void testServiceReady() {
        AppService mockAppService = mock(AppService.class);
        when(mockAppService.serviceReady(READY_MSG)).thenReturn(READY_MSG);
        String result = mockAppService.serviceReady(READY_MSG);
        verify(mockAppService, times(1)).serviceReady(READY_MSG);
        assertNotNull(result);
        assertEquals(READY_MSG, result);
    }

    @Test
    public void testGetAppInfos() {
        AppService mockAppService = mock(AppService.class);
        ApplicationInfosDTO applicationInfosDTO = TestUtil.createAppInfos(APP_NAME, APP_ENV, APP_VERSION);
        when(mockAppService.getAppInfos()).thenReturn(applicationInfosDTO);
        ApplicationInfosDTO result = mockAppService.getAppInfos();
        verify(mockAppService, times(1)).getAppInfos();
        assertNotNull(result);
        assertEquals(result.getName(), applicationInfosDTO.getName());
        assertEquals(result.getVersion(), applicationInfosDTO.getVersion());
        assertEquals(result.getEnv(), applicationInfosDTO.getEnv());
    }
}
