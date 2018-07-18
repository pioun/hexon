package pl.pioun.hexon.bgg.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    public enum Type {
        BOARDGAME, BOARDGAME_EXTENSION;
    }

    private String type;
    private String id;
    private Name name;
    private Attribute playingTime;
    private Attribute yearPublished;
    private String description;
    private Attribute minPlayers;
    private Attribute maxPlayers;
    private String image;
    private Statistics statistics;

    @XmlAttribute
    public String getType() {
        return type;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    @XmlElement
    public Name getName() {
        return name;
    }

    @XmlElement(name = "playingtime")
    public Attribute getPlayingTime() {
        return playingTime;
    }

    @XmlElement(name = "yearpublished")
    public Attribute getYearPublished() {
        return yearPublished;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    @XmlElement(name = "minplayers")
    public Attribute getMinPlayers() {
        return minPlayers;
    }

    @XmlElement(name = "maxplayers")
    public Attribute getMaxPlayers() {
        return maxPlayers;
    }

    @XmlElement
    public String getImage() {
        return image;
    }

    @XmlElement
    public Statistics getStatistics() {
        return statistics;
    }
}
