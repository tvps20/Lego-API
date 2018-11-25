package br.com.lego.api.endpoints;


import br.com.lego.api.erros.ResourceNotFoundException;
import br.com.lego.api.models.Imagem;
import br.com.lego.api.models.Peca;
import br.com.lego.api.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/imagens")
public class ImagemController {

    private ImagemRepository imagemRepository;

    @Autowired
    public ImagemController(ImagemRepository imagemRepository) {
        this.imagemRepository = imagemRepository;
    }

    // Métodos Crud
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(imagemRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSetById(@PathVariable("id") Long id) {
        verifyIfUserExists(id);
        return new ResponseEntity<Optional>(imagemRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Imagem imagem) {
        return new ResponseEntity<>(imagemRepository.save(imagem), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Imagem img) {
        verifyIfUserExists(img.getId());
        imagemRepository.save(img);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfUserExists(id);
        imagemRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // Métodos Auxiliares
    private void verifyIfUserExists(Long id) {
        Optional<Imagem> img = imagemRepository.findById(id);

        if (!img.isPresent()) {
            throw new ResourceNotFoundException("Imagem not fount for ID: " + id);
        }
    }
}
