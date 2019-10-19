package br.edu.unicid.api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unicid.api.domain.Bagagem;

public interface IBagagemRepository extends JpaRepository<Bagagem, String>{
	
	@Query("select b from Bagagem b where b.hashArduino = ?1")
	Bagagem buscarPorHashArduino(String hashArduino);

}
