package mira.space.jpagraphs;

import mira.space.jpagraphs.models.Computer;
import mira.space.jpagraphs.models.Player;
import mira.space.jpagraphs.repositories.ComputerRepository;
import mira.space.jpagraphs.repositories.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class GraphsTests {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ComputerRepository computerRepository;

    @Test
    public void givenEntityGraph_whenCalled_shouldReturnDefinedFields() {
        Long houseId = 1L;

        Player player = playerRepository.findById(1L).get();
        Assertions.assertEquals(houseId, player.getHouse().getId());

        Computer computer = computerRepository.findById(1L).get();
        Assertions.assertEquals(houseId, computer.getOwner().getHouse().getId());
    }

}
