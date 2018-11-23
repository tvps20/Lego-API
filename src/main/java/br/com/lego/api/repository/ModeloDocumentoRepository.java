package br.com.lego.api.repository;

import br.com.lego.api.models.ModeloDeDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloDocumentoRepository extends JpaRepository<ModeloDeDocumento, Long> {
}
