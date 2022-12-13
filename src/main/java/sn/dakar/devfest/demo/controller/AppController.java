package sn.dakar.devfest.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.dakar.devfest.demo.domain.dto.ApplicationInfosDTO;
import sn.dakar.devfest.demo.service.AppService;

@RestController
@RequestMapping("/api")
public class AppController {

    private AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/service/healthy")
    public String healthy() {
        return this.appService.serviceHealthy("DevFest Demo App is healthy !");
    }

    @GetMapping("/service/ready")
    public String ready() {
        return this.appService.serviceReady("DevFest Demo App is ready !");
    }

    @GetMapping("/service/infos")
    public ApplicationInfosDTO infos() {
        return this.appService.getAppInfos();
    }
}
