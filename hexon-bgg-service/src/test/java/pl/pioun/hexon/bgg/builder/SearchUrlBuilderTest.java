package pl.pioun.hexon.bgg.builder;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pioun.hexon.bgg.configuration.ApiProperties;
import pl.pioun.hexon.bgg.configuration.HexonBggSpringBootTest;
import pl.pioun.hexon.bgg.model.Item.Type;

@HexonBggSpringBootTest
@RunWith(SpringRunner.class)
public class SearchUrlBuilderTest {

  @Autowired
  private ApiProperties apiProperties;

  @Test
  public void shouldBuildCorrectUrlWhenAllParametersArePresent() {
    final String queryField = "Title";
    final Type type = Type.BOARDGAME;
    final Boolean exact = Boolean.TRUE;

    final URI uri = SearchUrlBuilder.builder().apiProperties(apiProperties).query(queryField)
        .exact(exact).type(type)
        .build()
        .buildUrl();

    assertThat(uri.toString()).isEqualToIgnoringCase(
        buildBaseUrl() + getQuery(queryField) + getDefaultType(type) + getDefaultExact(exact));
  }

  @Test
  public void shouldBuildCorrectUrlWithDefaultValues() {
    final String queryField = "Title";

    final URI uri = SearchUrlBuilder.builder().apiProperties(apiProperties).query(queryField)
        .build()
        .buildUrl();

    assertThat(uri.toString()).isEqualToIgnoringCase(
        buildBaseUrl() + getQuery(queryField) + getDefaultType(null) + getDefaultExact(null));
  }

  @Test(expected = NullPointerException.class)
  public void shouldFailIfNoRequiredParametersPresent() {
    SearchUrlBuilder.builder().apiProperties(apiProperties).build().buildUrl();
  }

  private String buildBaseUrl() {
    return String.format("%s://%s/%s%s", apiProperties.getUrl().getScheme(),
        apiProperties.getUrl().getHost(), apiProperties.getUrl().getPath(),
        apiProperties.getSearch().getPath());
  }

  private String getQuery(final String query) {
    return "?query=" + query;
  }

  private String getDefaultType(final Type type) {
    return "&type=" + Optional.ofNullable(type).orElse(Type.BOARDGAME).toString().toLowerCase();
  }

  private String getDefaultExact(final Boolean exact) {
    return "&exact=" + (Optional.ofNullable(exact).orElse(Boolean.FALSE) ? 1 : 0);
  }

}