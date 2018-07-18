package pl.pioun.hexon.bgg.service.base;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pioun.hexon.bgg.builder.SearchUrlBuilder;
import pl.pioun.hexon.bgg.builder.ThingUrlBuilder;
import pl.pioun.hexon.bgg.configuration.ApiProperties;
import pl.pioun.hexon.bgg.model.Item;
import pl.pioun.hexon.bgg.model.Item.Type;
import pl.pioun.hexon.bgg.model.Items;
import pl.pioun.hexon.bgg.service.BggService;

@Service
public class BggServiceBase implements BggService {

    private final ApiProperties apiProperties;

    public BggServiceBase(final ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    @Override
    public List<Item> findItems(final String boardgameName) {
        final URI uri = SearchUrlBuilder.builder().apiProperties(apiProperties).type(Type.BOARDGAME)
            .query(boardgameName).exact(true).build().buildUrl();

        final RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<Items> response = restTemplate
            .exchange(uri, HttpMethod.GET, null, Items.class);

        return response.getBody().getItem();
    }

    @Override
    public List<Item> findBoardgames(final List<Item> searchItems) {
        final URI uri = ThingUrlBuilder.builder().apiProperties(apiProperties)
            .ids(searchItems.stream().map(Item::getId).collect(Collectors.toList())).stats(true)
            .type(Type.BOARDGAME).build().buildUrl();

        final RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<Items> response = restTemplate
            .exchange(uri, HttpMethod.GET, null, Items.class);

        return response.getBody().getItem();
    }

}
