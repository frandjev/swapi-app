package com.exam.swapi.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "SWAPI REST Wrapper",
                version = "1.0.0",
                description = "API REST desarrollada como prueba técnica basada en la API pública de Star Wars (https://www.swapi.tech/). " +
                        "Este servicio actúa como wrapper para facilitar el consumo de datos sobre personajes, películas, naves y vehículos, " +
                        "incluyendo validaciones, manejo de errores y estructura modular.",
                contact = @Contact(
                        name = "Franco Maidana",
                        email = "franco.maidana@example.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Servidor local")
        }
)
public class OpenApiConfig {
}
