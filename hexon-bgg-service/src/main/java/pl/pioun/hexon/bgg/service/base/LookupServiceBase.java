package pl.pioun.hexon.bgg.service.base;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.pioun.hexon.bgg.model.BggBoardgame;
import pl.pioun.hexon.bgg.service.LookupService;

@Service
public class LookupServiceBase implements LookupService {

  @Override
  public List<BggBoardgame> lookup(final String boardgameName) {
    return null;
  }

}
