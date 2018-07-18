package pl.pioun.hexon.bgg.service;

import java.util.List;
import pl.pioun.hexon.bgg.model.Item;

public interface BggService {

    List<Item> findItems(final String boardgameName);

    List<Item> findBoardgames(final List<Item> searchItems);
}
