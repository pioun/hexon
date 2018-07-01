package pl.pioun.hexon.bgg.builder;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.pioun.hexon.bgg.TestConfiguration;
import pl.pioun.hexon.bgg.configuration.ApiProperties;
import pl.pioun.hexon.bgg.model.BggItem.Type;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class SearchUrlBuilderTest {

  @Autowired
  private ApiProperties apiProperties;

  @Test
  public void shouldBuildCorrectUrlWhenAllParametersArePresent() {
    final String queryField = "Title";

    URI uri = SearchUrlBuilder.builder().apiProperties(apiProperties).query(queryField).build()
        .buildUrl();

    assertThat(uri.toString()).isEqualToIgnoringCase(
        buildBaseUrl() + getQuery(queryField) + getDefaultType() + getDefaultExact());
  }

  private String buildBaseUrl() {
    return String.format("%s://%s/%s%s", apiProperties.getUrl().getScheme(),
        apiProperties.getUrl().getHost(), apiProperties.getUrl().getPath(),
        apiProperties.getSearch().getPath());
  }

  private String getQuery(final String query) {
    return "?query=" + query;
  }

  private String getDefaultType() {
    return "&type=" + Type.BOARDGAME;
  }

  private String getDefaultExact() {
    return "&exact=0";
  }

}