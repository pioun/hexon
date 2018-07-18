package pl.pioun.hexon.boardgame.data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Boardgame {

    @Id
    private Long id;

    private String name;

    private byte[] image;

    private int yearPublished;

    private short minPlayers;

    private short maxPlayers;

    private short playTime;

    private float avgScore;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String bggId;

    enum Status {
        IN_COLLECTION, WHISHLIST
    }

}
