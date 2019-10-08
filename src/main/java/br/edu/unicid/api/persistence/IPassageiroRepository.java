package br.edu.unicid.api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unicid.api.domain.Passageiro;

@Repository
public interface IPassageiroRepository extends JpaRepository<Passageiro, Integer>{

}
