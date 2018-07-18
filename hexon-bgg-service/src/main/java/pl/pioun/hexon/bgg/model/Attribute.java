package pl.pioun.hexon.bgg.model;

import javax.xml.bind.annotation.XmlAttribute;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class Attribute {

    private float value;

    @XmlAttribute
    public float getValue() {
        return value;
    }
}
