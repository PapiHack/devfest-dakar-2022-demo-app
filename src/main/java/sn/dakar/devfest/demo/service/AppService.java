package sn.dakar.devfest.demo.service;

import sn.dakar.devfest.demo.domain.dto.ApplicationInfosDTO;

public interface AppService {

    String serviceHealthy(String message);

    String serviceReady(String message);

    ApplicationInfosDTO getAppInfos();
}
