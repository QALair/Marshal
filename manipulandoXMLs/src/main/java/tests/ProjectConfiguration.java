package tests;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import java.net.URL;

@Data
@Configuration
public class ProjectConfiguration {
    @Value("${trelloUrl:https://api.trello.com}")
    private String trelloUrl;
    private String key;
    private String token;

}
