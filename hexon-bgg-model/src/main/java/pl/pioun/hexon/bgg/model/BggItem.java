package pl.pioun.hexon.bgg.model;

public class BggItem {

  public enum Type {
    BOARDGAME, BOARDGAME_EXTENSION
  }

  private Type type;

  private String id;

  private String name;

}
