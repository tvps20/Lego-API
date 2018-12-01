package br.com.lego.api.endpoints;

import br.com.lego.api.erros.ResourceNotFoundException;
import br.com.lego.api.models.HistoricoDeCompra;
import br.com.lego.api.repository.HistoricoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/historico/compras")
public class HistoricoCompraController {

    private HistoricoCompraRepository historicoDeCompra;

    @Autowired
    public HistoricoCompraController(HistoricoCompraRepository historicoDeCompra) {
        this.historicoDeCompra = historicoDeCompra;
    }

    // Métodos Crud
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(historicoDeCompra.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSetById(@PathVariable("id") Long id) {
        verifyIfUserExists(id);
        return new ResponseEntity<Optional>(historicoDeCompra.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody HistoricoDeCompra compra) {
        return new ResponseEntity<>(historicoDeCompra.save(compra), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody HistoricoDeCompra historico) {
        verifyIfUserExists(historico.getId());
        historicoDeCompra.save(historico);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfUserExists(id);
        historicoDeCompra.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // Métodos Auxiliares
    private void verifyIfUserExists(Long id) {
        Optional<HistoricoDeCompra> historico = historicoDeCompra.findById(id);

        if (!historico.isPresent()) {
            throw new ResourceNotFoundException("Histórico not fount for ID: " + id);
        }
    }
}
