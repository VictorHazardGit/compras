package hazard.nexus.api.compra;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroCompra(

        @NotBlank
        String comprador,

        @NotBlank
        String local,

        TipoCompra tipoCompra,

        @NotNull
        Integer parcelado,

        Integer numeroParcelas,

        @NotNull
        Double valor,

       @NotNull
        LocalDate dataCompra,

        @NotNull
        Boolean ativo
) {
}

