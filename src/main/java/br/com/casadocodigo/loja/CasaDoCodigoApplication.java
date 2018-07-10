package br.com.casadocodigo.loja;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CasaDoCodigoApplication {
    public static void main(String[] args) {
        System.setProperty("server.contextPath", "/casadocodigo");
        System.setProperty("spring.jackson.serialization.WRITE_DATES_AS_TIMESTAMPS", "false");
        SpringApplication.run(CasaDoCodigoApplication.class, args);
    }
}
