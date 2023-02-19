package mira.space.jpagraphs.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(
        name = "player.house",
        attributeNodes = @NamedAttributeNode("house"))
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nickname;

    // we don`t need graphs for collections
    @OneToMany
    @JoinColumn(name = "game_id")
    private List<Game> games = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id")
    private House house;
}
