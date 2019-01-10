package ru.httpstatuses.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.httpstatuses.model.HttpStatusInfo;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "app")
@Configuration
public class HttpStatusesProperties {

    private List<HttpStatusInfo> statuses;

}
