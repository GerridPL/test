package pl.test.test.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${electionservice.swagger.dev.url}")
    private String devUrl;

    @Value("${electionservice.swagger.dev.title}")
    private String devTitle;

    @Value("${electionservice.swagger.contact.email}")
    private String contactEmail;

    @Value("${electionservice.swagger.contact.name}")
    private String contactName;

    @Value("${electionservice.swagger.contact.url}")
    private String contactUrl;

    @Value("${electionservice.swagger.info.title}")
    private String infoTitle;

    @Value("${electionservice.swagger.info.version}")
    private String infoVersion;

    @Value("${electionservice.swagger.info.description}")
    private String infoDescription;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription(devTitle);

        Contact contact = new Contact();
        contact.setEmail(contactEmail);
        contact.setName(contactName);
        contact.setUrl(contactUrl);

        Info info = new Info()
                .title(infoTitle)
                .version(infoVersion)
                .contact(contact)
                .description(infoDescription);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
