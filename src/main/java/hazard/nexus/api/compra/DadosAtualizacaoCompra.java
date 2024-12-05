package hazard.nexus.api.compra;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoCompra(

        @NotNull
        Long id,

        String comprador,

        String local,

        TipoCompra tipoCompra,

        Integer parcelado,

        Integer numeroParcelas,

        Double valor,

        LocalDate dataCompra
) {
}
