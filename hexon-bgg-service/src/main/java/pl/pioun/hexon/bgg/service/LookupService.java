package pl.pioun.hexon.bgg.service;

import java.util.List;
import pl.pioun.hexon.bgg.model.BggBoardgame;

public interface LookupService {

  List<BggBoardgame> lookup(final String boardgameName);

}
