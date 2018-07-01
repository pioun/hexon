package pl.pioun.hexon.bgg.service;

import java.util.List;
import pl.pioun.hexon.bgg.model.BggItem;

public interface BggService {

  List<BggItem> search(final String boardgameName);

}
