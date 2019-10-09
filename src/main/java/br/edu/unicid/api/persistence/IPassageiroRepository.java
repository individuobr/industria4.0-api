package br.edu.unicid.api.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.unicid.api.domain.Passageiro;

@Repository
public interface IPassageiroRepository extends JpaRepository<Passageiro, Integer>{

	@Query("select p from Passageiro p where p.nome = ?1")
	List<Passageiro> buscarPeloNome(String nome);
	
	@Query("select p from Passageiro p where p.id = ?1")
	Passageiro buscarPorId(Integer id);
}
