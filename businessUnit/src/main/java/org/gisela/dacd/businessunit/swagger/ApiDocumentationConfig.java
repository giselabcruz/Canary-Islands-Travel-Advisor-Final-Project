package org.gisela.dacd.businessunit.swagger;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
/**
 * Reference : <a href="https://support.intershop.com/kb/index.php/Display/2914L4">...</a>
 */
@OpenAPIDefinition(
        info = @Info(
                description = "Find the best fly and hotel to travel to the best Canary Island depending on weather!",
                version = "V12.0.12",
                title = "API FlyHotelIsland",
                contact = @Contact(
                        name = "Ranga Karanam",
                        email = "ranga.karanam@in28minutes.com",
                        url = "http://www.in28minutes.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        servers = {@Server(url = "http://in28minutes.com")}
)
public interface ApiDocumentationConfig {

}
