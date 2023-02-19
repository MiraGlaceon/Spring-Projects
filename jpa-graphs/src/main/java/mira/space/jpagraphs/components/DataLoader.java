package mira.space.jpagraphs.components;

import mira.space.jpagraphs.models.Computer;
import mira.space.jpagraphs.models.House;
import mira.space.jpagraphs.models.Player;
import mira.space.jpagraphs.repositories.ComputerRepository;
import mira.space.jpagraphs.repositories.HouseRepository;
import mira.space.jpagraphs.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DataLoader {

    @Autowired
    public DataLoader(PlayerRepository playerRepository,
                      ComputerRepository computerRepository,
                      HouseRepository houseRepository) {
        Player player = new Player();
        player.setNickname("Mira");
        Computer computer = new Computer();
        computer.setOwner(player);
        House house = new House();
        player.setHouse(house);
        houseRepository.save(house);
        playerRepository.save(player);
        computerRepository.save(computer);
    }
}
