package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/auth.properties"
})

public interface AuthConfig extends Config {

    @Key("apiToken")
    String apiToken();

    @Key("userNameAllure")
    String userNameAllure();

    @Key("passwordAllure")
    String passwordAllure();
}
