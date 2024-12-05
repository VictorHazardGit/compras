package hazard.nexus.api.compra;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table (name="compras")
@Entity (name="Compra")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comprador;
    private String local;
    @Enumerated(EnumType.STRING)
    private TipoCompra tipoCompra;
    private Integer parcelado;
    private Integer numeroParcelas;
    private double valor;
    private Boolean ativo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataCompra;

    public Compra(DadosCadastroCompra dados) {
        this.comprador = dados.comprador();
        this.local = dados.local();
        this.parcelado = dados.parcelado();
        this.numeroParcelas = dados.numeroParcelas();
        this.valor = dados.valor();
        this.tipoCompra = dados.tipoCompra();
        this.dataCompra = dados.dataCompra();
        this.ativo = true;
    }


    public void atualizarInformacoes(DadosAtualizacaoCompra dados) {

        if (dados.comprador() != null) {
            this.comprador = dados.comprador();
        }

        if (dados.local() != null) {
            this.local = dados.local();
        }

        if (dados.parcelado() != null) {
            this.parcelado = dados.parcelado();
        }

        if (dados.numeroParcelas() != null) {
            this.numeroParcelas = dados.numeroParcelas();
        }

        if (dados.valor() != null) {
            this.valor = dados.valor();
        }

        if (dados.tipoCompra() != null) {
            this.tipoCompra = dados.tipoCompra();
        }

        if (dados.dataCompra() != null) {
            this.dataCompra = dados.dataCompra();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
