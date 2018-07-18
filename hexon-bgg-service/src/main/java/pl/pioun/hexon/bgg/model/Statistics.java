package pl.pioun.hexon.bgg.model;

import javax.xml.bind.annotation.XmlElement;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class Statistics {

    private Ratings ratings;

    @XmlElement
    public Ratings getRatings() {
        return ratings;
    }
}
