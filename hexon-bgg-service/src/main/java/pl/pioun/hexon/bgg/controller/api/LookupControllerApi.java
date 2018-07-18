package pl.pioun.hexon.bgg.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.ResponseEntity;
import pl.pioun.hexon.bgg.model.BggBoardgame;

@Api
public interface LookupControllerApi {

    @ApiOperation(value = "Retrieve list of boardgames from BoardGameGeek by name", response = BggBoardgame.class, responseContainer = "List")
    @ApiImplicitParam(name = "boardgameName", value = "Name of the boardgame", required = true, example = "Vikings Gone Wild")
    ResponseEntity<List<BggBoardgame>> lookup(final String boardgameName);

}
