package pl.pioun.hexon.bgg.builder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pioun.hexon.bgg.configuration.ApiProperties;
import pl.pioun.hexon.bgg.model.Item.Type;

@Builder
public class ThingUrlBuilder {

    private final ApiProperties apiProperties;

    @NonNull
    private final List<String> ids;

    private final Type type;

    private final boolean stats;

    public URI buildUrl() {
        final UriComponents uriComponents = UriComponentsBuilder.newInstance()
            .scheme(apiProperties.getUrl().getScheme())
            .host(apiProperties.getUrl().getHost())
            .path(apiProperties.getUrl().getPath())
            .path(apiProperties.getThing().getPath())
            .queryParam(apiProperties.getThing().getParams().getId(), ids.stream().collect(
                Collectors.joining(",")))
            .queryParam(apiProperties.getThing().getParams().getType(),
                Optional.ofNullable(type).orElse(Type.BOARDGAME).toString().toLowerCase())
            .queryParam(apiProperties.getThing().getParams().getStats(), stats ? 1 : 0)
            .build();

        return uriComponents.toUri();
    }

}
