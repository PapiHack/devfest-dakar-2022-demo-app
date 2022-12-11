package sn.dakar.devfest.demo.domain.dto;

public class ApplicationInfosDTO {

    private String name;

    private String version;

    private String env;

    public String getName() {
        return name;
    }

    public ApplicationInfosDTO name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public ApplicationInfosDTO version(String version) {
        this.setVersion(version);
        return this;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEnv() {
        return env;
    }

    public ApplicationInfosDTO env(String env) {
        this.setEnv(env);
        return this;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
