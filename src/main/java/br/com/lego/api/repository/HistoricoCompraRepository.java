package br.com.lego.api.repository;

import br.com.lego.api.models.HistoricoDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoCompraRepository extends JpaRepository<HistoricoDeCompra, Long> {
}
