package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Player;

public interface PlayerRepo extends JpaRepository<Player, Integer>
{
	
}
