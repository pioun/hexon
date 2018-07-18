package pl.pioun.hexon.bgg.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pioun.hexon.bgg.controller.api.LookupControllerApi;
import pl.pioun.hexon.bgg.model.BggBoardgame;
import pl.pioun.hexon.bgg.service.LookupService;

@RestController
@RequestMapping(path = "/bgg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LookupController implements LookupControllerApi {

    private final LookupService lookupService;

    public LookupController(final LookupService lookupService) {
        this.lookupService = lookupService;
    }

    @Override
    @RequestMapping(path = "/lookup/{boardgameName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<BggBoardgame>> lookup(@PathVariable final String boardgameName) {
        final List<BggBoardgame> bggBoardgames = lookupService.lookup(boardgameName);

        return ResponseEntity.ok().body(bggBoardgames);
    }
}
