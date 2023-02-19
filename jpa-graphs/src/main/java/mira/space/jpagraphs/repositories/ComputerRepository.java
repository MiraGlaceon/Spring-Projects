package mira.space.jpagraphs.repositories;

import mira.space.jpagraphs.models.Computer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

    //@EntityGraph(attributePaths = {"owner.house"})
    //@EntityGraph(value = "computer.owner")
    @Query("select c from Computer c where c.id = :id")
    Optional<Computer> findById(@Param("id") Long id);
}
