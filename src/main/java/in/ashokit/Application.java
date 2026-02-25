package in.ashokit;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Player;
import in.ashokit.repository.PlayerRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

		PlayerRepo playerRepo = run.getBean(PlayerRepo.class);

		// save() – Single Record Insert / Update

		Player p1 = new Player();
		p1.setPlayerId(101);
		p1.setPlayerName("Rahul");
		p1.setPlayerAge(42);
		p1.setLocation("Mumbai");

		playerRepo.save(p1);
		System.out.println("Single Record Saved");

		// saveAll() – Multiple Records Insert / Update

		Player p2 = new Player();
		p2.setPlayerId(102);
		p2.setPlayerName("Rajesh");
		p2.setPlayerAge(32);
		p2.setLocation("Pune");

		Player p3 = new Player();
		p3.setPlayerId(103);
		p3.setPlayerName("Amit");
		p3.setPlayerAge(28);
		p3.setLocation("Delhi");

		List<Player> players = List.of(p2, p3);
		playerRepo.saveAll(players);

		System.out.println("Multiple Records Saved");

		// findById() – Single Record Fetch

		Optional<Player> opt = playerRepo.findById(101);

		if (opt.isPresent()) {
			Player p = opt.get();
			System.out.println(p);
		} else {
			System.out.println("Player Not Found");
		}

		// findAllById() – Multiple IDs Fetch

		List<Integer> ids = List.of(101, 102, 103);

		List<Player> playerss = playerRepo.findAllById(ids);

		playerss.forEach(System.out::println);

		// findAll() – Fetch All Records

		List<Player> list = playerRepo.findAll();

		list.forEach(System.out::println);

		// count() – Total Records Count

		long total = playerRepo.count();
		System.out.println("Total Players = " + total);

		// existsById() – Record Exists or Not

		boolean exists = playerRepo.existsById(101);

		if (exists) {
			System.out.println("Player Exists");
		} else {
			System.out.println("Player Not Exists");
		}

		// deleteById() – ID वापरून Record Delete

		playerRepo.deleteById(101);
		System.out.println("Player with ID 101 deleted");

		if (playerRepo.existsById(101)) {
			playerRepo.deleteById(101);
		}

		// delete() – Entity object वापरून Delete

		Player p = new Player();
		p.setPlayerId(102);

		playerRepo.delete(p);
		System.out.println("Player deleted using entity object");

		// deleteAllById() – Multiple IDs वापरून Delete

		List<Integer> idss = List.of(103, 104);

		playerRepo.deleteAllById(idss);
		System.out.println("Multiple Players deleted");

		// deleteAll() – सगळे Records Delete

		playerRepo.deleteAll();
		System.out.println("All players deleted");
		
		

	}
}
