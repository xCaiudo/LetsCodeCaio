package br.com.letscode.java.clientrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClientRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientRestApplication.class, args);
    }

}
