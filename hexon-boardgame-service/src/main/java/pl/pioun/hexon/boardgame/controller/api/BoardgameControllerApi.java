package pl.pioun.hexon.boardgame.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import pl.pioun.hexon.bgg.model.BggBoardgame;

@Api
public interface BoardgameControllerApi {

    @ApiOperation(value = "Save boardgame from BoardGameGeek resource.")
    ResponseEntity<Void> post(final BggBoardgame bggBoardgame);

}
