package br.com.lego.api.endpoints;

import br.com.lego.api.erros.ResourceNotFoundException;
import br.com.lego.api.models.ListaDeDesejo;
import br.com.lego.api.repository.ListaDesejoRepository;
import br.com.lego.api.repository.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/lista")
public class ListaDesejoController {

    private ListaDesejoRepository listaDesejoRepository;
    private SetRepository setRepository;
    private String messageError = "Lista de Desejo not fount for ID: ";

    @Autowired
    public ListaDesejoController(ListaDesejoRepository listaDesejoRepository, SetRepository setRepository) {
        this.listaDesejoRepository = listaDesejoRepository;
        this.setRepository = setRepository;
    }

    // Métodos Crud
    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(listaDesejoRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/meusdesejos")
    public ResponseEntity<?> listAllSets(Pageable pageable) {
        List<ListaDeDesejo> listaDeDesejo = listaDesejoRepository.findAll();
        if(listaDeDesejo.size() == 1) {
            return new ResponseEntity<>(setRepository.findByListaDeDesejoId(listaDeDesejo.get(0).getId()), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Lista de Desejo not fount");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSetById(@PathVariable("id") Long id) {
        verifyIfUserExists(id, messageError);
        return new ResponseEntity<Optional>(listaDesejoRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ListaDeDesejo lista) {
        List<ListaDeDesejo> listaDeDesejo = listaDesejoRepository.findAll();
        if(listaDeDesejo.size() >= 1) {
            throw new ResourceNotFoundException("Lista de Desejo is created");
        }
        return new ResponseEntity<>(listaDesejoRepository.save(lista), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ListaDeDesejo lista) {
        verifyIfUserExists(lista.getId(), messageError);
        listaDesejoRepository.save(lista);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfUserExists(id, messageError);
        listaDesejoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // Métodos Auxiliares
    private void verifyIfUserExists(Long id, String msg) {
        Optional<ListaDeDesejo> lista = listaDesejoRepository.findById(id);

        if (!lista.isPresent()) {
            throw new ResourceNotFoundException(msg + id);
        }
    }
}
