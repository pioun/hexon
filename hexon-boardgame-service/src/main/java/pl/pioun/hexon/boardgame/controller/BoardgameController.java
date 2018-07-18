package pl.pioun.hexon.boardgame.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pioun.hexon.bgg.model.BggBoardgame;
import pl.pioun.hexon.boardgame.controller.api.BoardgameControllerApi;

@RestController
@RequestMapping(path = "/boardgame", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BoardgameController implements BoardgameControllerApi {

    @Override
    public ResponseEntity<Void> post(BggBoardgame bggBoardgame) {
        return null;
    }
}
