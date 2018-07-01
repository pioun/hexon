package pl.pioun.hexon.bgg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel
public class BggBoardgame {

  @ApiModelProperty(value = "BGG id of an item", required = true, example = "12345")
  private String id;

  @ApiModelProperty(value = "Type of boardgame", required = true, example = "BOARDGAME")
  private BggItem.Type type;

  @ApiModelProperty(value = "URI to boardgame image", required = true, example = "http://some.com/image.png")
  private String imageUri;

  @ApiModelProperty(value = "Name of the game", required = true, example = "Vikings Gone Wild")
  private String name;

  @ApiModelProperty(value = "Year when game was published", required = true, example = "2017")
  private int yearPublished;

  @ApiModelProperty(value = "Minimum amount of players", required = true, example = "2")
  private int minPlayers;

  @ApiModelProperty(value = "Maximum amount of players", required = true, example = "5")
  private int maxPlayers;

  @ApiModelProperty(value = "Average boardgame score by players", required = true, example = "7.61")
  private float avgScore;

}
