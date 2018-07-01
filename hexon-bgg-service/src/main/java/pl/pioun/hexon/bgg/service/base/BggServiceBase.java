package pl.pioun.hexon.bgg.service.base;

import java.net.URI;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pioun.hexon.bgg.builder.SearchUrlBuilder;
import pl.pioun.hexon.bgg.configuration.ApiProperties;
import pl.pioun.hexon.bgg.model.BggItem;
import pl.pioun.hexon.bgg.model.BggItem.Type;
import pl.pioun.hexon.bgg.service.BggService;

@Service
public class BggServiceBase implements BggService {

  private final ApiProperties apiProperties;

  public BggServiceBase(final ApiProperties apiProperties) {
    this.apiProperties = apiProperties;
  }

  @Override
  public List<BggItem> search(final String boardgameName) {
    final URI uri = SearchUrlBuilder.builder().apiProperties(apiProperties).type(Type.BOARDGAME)
        .query(boardgameName)
        .exact(false)
        .build().buildUrl();

    final RestTemplate restTemplate = new RestTemplate();

    final ResponseEntity<List<BggItem>> response = restTemplate
        .exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<BggItem>>() {
        });

    return response.getBody();
  }

}
