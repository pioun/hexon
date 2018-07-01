package pl.pioun.hexon.bgg.builder;

import java.net.URI;
import java.util.Optional;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pioun.hexon.bgg.configuration.ApiProperties;
import pl.pioun.hexon.bgg.model.BggItem;
import pl.pioun.hexon.bgg.model.BggItem.Type;

@Builder
public class SearchUrlBuilder {

  private final ApiProperties apiProperties;

  @NonNull
  private final String query;

  private final BggItem.Type type;

  private boolean exact;

  public URI buildUrl() {
    final UriComponents uriComponents = UriComponentsBuilder.newInstance()
        .scheme(apiProperties.getUrl().getScheme())
        .host(apiProperties.getUrl().getHost())
        .path(apiProperties.getUrl().getPath())
        .path(apiProperties.getSearch().getPath())
        .queryParam(apiProperties.getSearch().getParams().getQuery(), query)
        .queryParam(apiProperties.getSearch().getParams().getType(),
            Optional.ofNullable(type).orElse(Type.BOARDGAME))
        .queryParam(apiProperties.getSearch().getParams().getExact(), exact ? 1 : 0)
        .build();

    return uriComponents.toUri();
  }
}