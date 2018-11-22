package br.com.lego.api.repository;

import br.com.lego.api.models.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {
}
