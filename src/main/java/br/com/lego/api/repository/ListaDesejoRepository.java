package br.com.lego.api.repository;

import br.com.lego.api.models.ListaDeDesejo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDesejoRepository extends JpaRepository<ListaDeDesejo, Long> {
}
