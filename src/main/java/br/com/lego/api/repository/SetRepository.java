package br.com.lego.api.repository;

import br.com.lego.api.models.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SetRepository extends JpaRepository<Set, Long> {
}
