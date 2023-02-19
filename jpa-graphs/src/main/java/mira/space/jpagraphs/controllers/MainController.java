package mira.space.jpagraphs.controllers;

import mira.space.jpagraphs.models.Computer;
import mira.space.jpagraphs.models.Game;
import mira.space.jpagraphs.models.Player;
import mira.space.jpagraphs.repositories.ComputerRepository;
import mira.space.jpagraphs.repositories.GameRepository;
import mira.space.jpagraphs.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class MainController {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    ComputerRepository computerRepository;

    @GetMapping("/player")
    public ResponseEntity<Player> getPlayer() {
        Player player = playerRepository.findById(1L).get();
        return ResponseEntity.ok(player);
    }

    @PutMapping("/player")
    public ResponseEntity<Player> addGame(@RequestParam(name = "gameName") String name) {
        Player player = playerRepository.findById(1L).get();
        Game game = new Game();
        game.setName(name);
        player.getGames().add(game);
        gameRepository.save(game); // player is auto updated
        return ResponseEntity.ok().build();
    }

    @GetMapping("/computer")
    public ResponseEntity<Computer> getComputer() {
        Computer computer = computerRepository.findById(1L).get();
        return ResponseEntity.ok(computer);
    }
}
