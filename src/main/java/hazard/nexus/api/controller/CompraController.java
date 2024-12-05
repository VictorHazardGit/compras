package hazard.nexus.api.controller;

import hazard.nexus.api.compra.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCompra dados){
        repository.save(new Compra(dados));
    }

    @GetMapping("/ativas")
    public Page<DadosListagemCompra> listar(Pageable paginacao){
       // return repository.findAll(paginacao).stream().map(DadosListagemCompra::new ).toList();
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCompra::new );
    }

    @GetMapping
    public Page<DadosListagemCompra> listarTodos(Pageable paginacao){
        // return repository.findAll(paginacao).stream().map(DadosListagemCompra::new ).toList();
        return repository.findAll(paginacao).map(DadosListagemCompra::new );
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCompra dados){
        var compra = repository.getReferenceById(dados.id());
        compra.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
       // repository.deleteById(id);
        var compra = repository.getReferenceById(id);
        compra.excluir();
    }
}
