package pl.pioun.hexon.bgg.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@XmlRootElement(name = "items")
public class Items {

    private List<Item> item;

    @XmlElement
    public List<Item> getItem() {
        return item;
    }
}
