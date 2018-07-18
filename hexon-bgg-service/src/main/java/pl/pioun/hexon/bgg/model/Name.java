package pl.pioun.hexon.bgg.model;

import javax.xml.bind.annotation.XmlAttribute;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class Name {

  private String type;
  private String value;

  @XmlAttribute
  public String getType() {
    return type;
  }

  @XmlAttribute
  public String getValue() {
    return value;
  }
}
