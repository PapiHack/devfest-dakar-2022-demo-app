package sn.dakar.devfest.demo.service.impl;

import org.springframework.stereotype.Service;
import sn.dakar.devfest.demo.config.ApplicationProperties;
import sn.dakar.devfest.demo.domain.dto.ApplicationInfosDTO;
import sn.dakar.devfest.demo.service.AppService;

@Service
public class AppServiceImpl implements AppService {

    private ApplicationProperties applicationProperties;

    public AppServiceImpl(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    public String serviceHealthy(String message) {
        return message;
    }

    @Override
    public String serviceReady(String message) {
        return message;
    }

    @Override
    public ApplicationInfosDTO getAppInfos() {
        return new ApplicationInfosDTO()
                .name(this.applicationProperties.getName())
                .env(this.applicationProperties.getEnv())
                .version(this.applicationProperties.getVersion());
    }
}
