package pl.pioun.mad.cow.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MadCowDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MadCowDiscoveryServiceApplication.class, args);
	}
}
