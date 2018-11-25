package br.com.lego.api.endpoints;

import br.com.lego.api.erros.ResourceNotFoundException;
import br.com.lego.api.models.ModeloDeDocumento;
import br.com.lego.api.repository.ModeloDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/modelos/documentos")
public class ModeloDocumentoController {

    private ModeloDocumentoRepository modeloDocumentoRepository;

    @Autowired
    public ModeloDocumentoController(ModeloDocumentoRepository modeloDocumentoRepository) {
        this.modeloDocumentoRepository = modeloDocumentoRepository;
    }

    // Métodos Crud
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(modeloDocumentoRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSetById(@PathVariable("id") Long id) {
        verifyIfUserExists(id);
        return new ResponseEntity<Optional>(modeloDocumentoRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ModeloDeDocumento modelo) {
        return new ResponseEntity<>(modeloDocumentoRepository.save(modelo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ModeloDeDocumento modelo) {
        verifyIfUserExists(modelo.getId());
        modeloDocumentoRepository.save(modelo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfUserExists(id);
        modeloDocumentoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // Métodos Auxiliares
    private void verifyIfUserExists(Long id) {
        Optional<ModeloDeDocumento> compra = modeloDocumentoRepository.findById(id);

        if (!compra.isPresent()) {
            throw new ResourceNotFoundException("Modelo not fount for ID: " + id);
        }
    }
}
