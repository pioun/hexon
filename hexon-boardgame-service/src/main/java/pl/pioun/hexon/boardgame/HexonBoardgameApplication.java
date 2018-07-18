package pl.pioun.hexon.boardgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HexonBoardgameApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexonBoardgameApplication.class, args);
    }
}
