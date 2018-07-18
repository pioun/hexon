package pl.pioun.hexon.bgg.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import pl.pioun.hexon.bgg.model.BggBoardgame;
import pl.pioun.hexon.bgg.model.Item;

public class BggBoardgameMapper extends CustomMapper<BggBoardgame, Item> {

    @Override
    public void mapBtoA(final Item item, final BggBoardgame bggBoardgame,
        final MappingContext context) {
        bggBoardgame.setId(item.getId());
        bggBoardgame.setName(item.getName().getValue());
        bggBoardgame.setType(item.getType());
        bggBoardgame.setImageUri(item.getImage());
        bggBoardgame.setMinPlayers((int) item.getMinPlayers().getValue());
        bggBoardgame.setMaxPlayers((int) item.getMaxPlayers().getValue());
        bggBoardgame.setAvgScore(item.getStatistics().getRatings().getAverage().getValue());
        bggBoardgame.setYearPublished((int) item.getYearPublished().getValue());
        bggBoardgame.setPlayTime((int) item.getPlayingTime().getValue());
    }
}
