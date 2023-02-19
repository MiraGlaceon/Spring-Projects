package mira.space.jpagraphs;

import mira.space.jpagraphs.components.DataLoader;
import mira.space.jpagraphs.repositories.ComputerRepository;
import mira.space.jpagraphs.repositories.HouseRepository;
import mira.space.jpagraphs.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class JpaGraphsApplication {

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private ComputerRepository computerRepository;
	@Autowired
	private HouseRepository houseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaGraphsApplication.class, args);
	}

	@Bean
	@EventListener(ApplicationReadyEvent.class)
	public DataLoader dataLoaderBean() {
		return new DataLoader(playerRepository, computerRepository, houseRepository);
	}
}
