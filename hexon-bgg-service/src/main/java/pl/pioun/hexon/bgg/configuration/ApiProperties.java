package pl.pioun.hexon.bgg.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "bgg.api")
public class ApiProperties {

  private Url url;
  private Search search;

  @Data
  public static class Url {

    private String scheme;
    private String host;
    private String path;
  }

  @Data
  public static class Search {

    private String path;
    private Params params;

    @Data
    public static class Params {

      private String query;
      private String type;
      private String exact;
    }

  }

}
