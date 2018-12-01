package br.com.lego.api.endpoints;


import br.com.lego.api.erros.ResourceNotFoundException;
import br.com.lego.api.models.Imagem;
import br.com.lego.api.models.Peca;
import br.com.lego.api.repository.ImagemRepository;
import br.com.lego.api.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pecas")
public class PecaController {

    private final PecaRepository pecaRepository;
    private ImagemRepository imagemRepository;

    @Autowired
    public PecaController(PecaRepository pecaRepository, ImagemRepository imagemRepository) {
        this.pecaRepository = pecaRepository;
        this.imagemRepository = imagemRepository;
    }

    // Métodos Crud
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(pecaRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSetById(@PathVariable("id") Long id) {
        verifyIfUserExists(id);
        return new ResponseEntity<Optional>(pecaRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Peca peca) {
        //List<Imagem> imagens = peca.getListaDeImgens();
        //peca.setListaDeImgens(new ArrayList<>());
        Peca pecaSalvo = pecaRepository.save(peca);
        //this.setIdInImagens(pecaSalvo.getId(), imagens);
        //imagemRepository.saveAll(imagens);

        return new ResponseEntity<>(pecaSalvo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Peca peca) {
        verifyIfUserExists(peca.getId());
        pecaRepository.save(peca);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfUserExists(id);
        pecaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // Métodos Auxiliares
    private void verifyIfUserExists(Long id) {
        Optional<Peca> peca = pecaRepository.findById(id);

        if (!peca.isPresent()) {
            throw new ResourceNotFoundException("Peça not fount for ID: " + id);
        }
    }

    private void setIdInImagens(Long pecaId, List<Imagem> imagems){
        if(imagems != null){
            for (Imagem imagem: imagems) {
                imagem.setPecaImagemId(pecaId);
            }
        }
    }
}
