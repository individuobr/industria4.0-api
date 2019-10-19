package br.edu.unicid.api.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unicid.api.domain.Bagagem;

public interface IBagagemRepository extends JpaRepository<Bagagem, String>{

}
