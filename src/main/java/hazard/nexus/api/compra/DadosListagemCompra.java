package hazard.nexus.api.compra;

import java.time.LocalDate;

public record DadosListagemCompra(Long id, String comprador, String local, Integer numeroParcelas, Double valor, LocalDate dataCompra, Boolean ativo) {

    public DadosListagemCompra(Compra compra){
        this(compra.getId(), compra.getComprador(), compra.getLocal(), compra.getNumeroParcelas(), compra.getValor(), compra.getDataCompra(), compra.getAtivo());
    }
}
