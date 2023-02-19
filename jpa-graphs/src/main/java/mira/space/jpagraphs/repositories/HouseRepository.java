package mira.space.jpagraphs.repositories;

import mira.space.jpagraphs.models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
}
