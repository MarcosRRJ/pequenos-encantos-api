package br.com.pequenosencantos.supplier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateSupplierRequest(
        @NotBlank(message = "Nome é obrigatório.")
        @Size(max = 120, message = "Nome deve ter no máximo 120 caracteres.")
        String name,

        @Size(max = 30, message = "WhatsApp deve ter no máximo 30 caracteres.")
        String whatsapp,

        @Size(max = 80, message = "Cidade deve ter no máximo 80 caracteres.")
        String city,

        @Size(min = 2, max = 2, message = "UF deve ter exatamente 2 caracteres.")
        String state,

        Integer averageShipDays,
        Boolean shipsToCustomer,
        Boolean acceptsExchange,
        String defectPolicy,
        String notes
) {
}
