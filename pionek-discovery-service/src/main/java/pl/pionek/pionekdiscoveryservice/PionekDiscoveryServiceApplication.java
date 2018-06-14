package pl.pionek.pionekdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PionekDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PionekDiscoveryServiceApplication.class, args);
	}
}
