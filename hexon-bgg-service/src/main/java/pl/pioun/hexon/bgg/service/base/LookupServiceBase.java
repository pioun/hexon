package pl.pioun.hexon.bgg.service.base;

import java.util.List;
import java.util.stream.Collectors;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;
import pl.pioun.hexon.bgg.model.BggBoardgame;
import pl.pioun.hexon.bgg.model.Item;
import pl.pioun.hexon.bgg.service.BggService;
import pl.pioun.hexon.bgg.service.LookupService;

@Service
public class LookupServiceBase implements LookupService {

    private final BggService bggService;
    private final BoundMapperFacade<Item, BggBoardgame> mapperFacade;

    public LookupServiceBase(final BggService bggService,
        final MapperFactory mapperFactory) {
        this.bggService = bggService;
        this.mapperFacade = mapperFactory.getMapperFacade(Item.class, BggBoardgame.class);
    }

    @Override
    public List<BggBoardgame> lookup(final String boardgameName) {
        final List<Item> items = bggService.findItems(boardgameName);
        final List<Item> boardgames = bggService.findBoardgames(items);

        final List<BggBoardgame> bggBoardgames = boardgames.stream().map(mapperFacade::map)
            .collect(Collectors.toList());

        return bggBoardgames;
    }

}
