package pl.pioun.hexon.bgg.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pioun.hexon.bgg.controller.api.LookupControllerApi;
import pl.pioun.hexon.bgg.model.BggBoardgame;
import pl.pioun.hexon.bgg.model.BggItem.Type;

@RestController
@RequestMapping(path = "/bgg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LookupController implements LookupControllerApi {

  @Override
  @RequestMapping(path = "/lookup/{boardgameName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<BggBoardgame>> lookup(@PathVariable final String boardgameName) {
    return ResponseEntity.ok().body(Arrays.asList(
        BggBoardgame.builder().id("1312").avgScore(5.12f).minPlayers(2).maxPlayers(5)
            .name("Vikings Gone Wild").type(Type.BOARDGAME).yearPublished(2017).imageUri("none")
            .build()));
  }
}
