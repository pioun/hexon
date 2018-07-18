package pl.pioun.hexon.bgg.builder;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pioun.hexon.bgg.configuration.ApiProperties;
import pl.pioun.hexon.bgg.configuration.HexonBggSpringBootTest;
import pl.pioun.hexon.bgg.model.Item.Type;

@HexonBggSpringBootTest
@RunWith(SpringRunner.class)
public class ThingUrlBuilderTest {

  @Autowired
  private ApiProperties apiProperties;

  @Test
  public void shouldBuildCorrectUrlWithAllParameters() {
    final List<String> ids = Arrays.asList("123", "234");
    final Type type = Type.BOARDGAME;
    final boolean stats = true;

    final URI uri = ThingUrlBuilder.builder().apiProperties(apiProperties).ids(ids).stats(stats)
        .type(type).build().buildUrl();

    assertThat(uri.toString()).isEqualToIgnoringCase(
        buildBaseUrl() + getIds(ids) + getDefaultType(type) + getDefaultExact(stats));
  }

  private String buildBaseUrl() {
    return String.format("%s://%s/%s%s", apiProperties.getUrl().getScheme(),
        apiProperties.getUrl().getHost(), apiProperties.getUrl().getPath(),
        apiProperties.getThing().getPath());
  }

  private String getIds(final List<String> ids) {
    return "?id=" + ids.stream().collect(Collectors.joining());
  }

  private String getDefaultType(final Type type) {
    return "&type=" + Optional.ofNullable(type).orElse(Type.BOARDGAME).toString().toLowerCase();
  }

  private String getDefaultExact(final Boolean exact) {
    return "&stats=" + (Optional.ofNullable(exact).orElse(Boolean.FALSE) ? 1 : 0);
  }

}