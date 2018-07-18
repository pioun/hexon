package pl.pioun.hexon.bgg.model;

import javax.xml.bind.annotation.XmlElement;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class Ratings {

  private Attribute average;

  @XmlElement(name = "average")
  public Attribute getAverage() {
    return average;
  }
}
