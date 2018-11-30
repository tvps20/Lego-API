package br.com.lego.api.endpoints;

import br.com.lego.api.erros.ResourceNotFoundException;
import br.com.lego.api.models.Imagem;
import br.com.lego.api.models.Peca;
import br.com.lego.api.models.Set;
import br.com.lego.api.repository.ImagemRepository;
import br.com.lego.api.repository.PecaRepository;
import br.com.lego.api.repository.SetRepository;
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
@RequestMapping("api/sets")
public class SetController {

    private final SetRepository setRepository;
    private PecaRepository pecaRepository;
    private ImagemRepository imagemRepository;

    @Autowired
    public SetController(SetRepository setRepository, PecaRepository pecaRepository, ImagemRepository imagemRepository) {
        this.setRepository = setRepository;
        this.pecaRepository = pecaRepository;
        this.imagemRepository = imagemRepository;
    }

    // Métodos Crud
    //@CrossOrigin
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(setRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSetById(@PathVariable("id") Long id) {
        verifyIfUserExists(id);
        return new ResponseEntity<Optional>(setRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Set set) {
        List<Peca> pecas = set.getListaDePecas();
        List<Imagem> imagens = set.getListaDeImagens();
        set.setListaDePecas(new ArrayList<>());
        set.setListaDeImagens(new ArrayList<>());
        Set setSalvo = setRepository.save(set);
        this.setIdInPecas(setSalvo.getId(), pecas);
        this.setIdInImagens(setSalvo.getId(), imagens);
        pecaRepository.saveAll(pecas);
        imagemRepository.saveAll(imagens);

        return new ResponseEntity<>(setSalvo, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Set set) {
        verifyIfUserExists(set.getId());
        setRepository.save(set);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfUserExists(id);
        setRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // Métodos Auxiliares
    private void verifyIfUserExists(Long id) {
        Optional<Set> set = setRepository.findById(id);

        if (!set.isPresent()) {
            throw new ResourceNotFoundException("Set not fount for ID: " + id);
        }
    }

    private void setIdInPecas(Long setId, List<Peca> pecas){
        if(pecas != null) {
            for (Peca peca: pecas) {
                peca.setSetId(setId);
            }
        }
    }

    private void setIdInImagens(Long setId, List<Imagem> imagems){
        if(imagems != null){
            for (Imagem imagem: imagems) {
                imagem.setSetImagemId(setId);
            }
        }
    }
}
