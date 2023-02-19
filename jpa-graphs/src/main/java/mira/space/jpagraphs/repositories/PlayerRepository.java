package mira.space.jpagraphs.repositories;

import mira.space.jpagraphs.models.Player;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @EntityGraph(value = "player.house")
    @Query("select p from Player p where p.id = :id")
    Optional<Player> findById(@Param("id") Long id);
}
