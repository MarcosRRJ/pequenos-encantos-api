package br.com.pequenosencantos.supplier;

import java.time.LocalDateTime;
import java.util.UUID;

public record SupplierResponse(
        UUID id,
        String name,
        String whatsapp,
        String city,
        String state,
        Integer averageShipDays,
        Boolean shipsToCustomer,
        Boolean acceptsExchange,
        String defectPolicy,
        String notes,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static SupplierResponse from(Supplier supplier) {
        return new SupplierResponse(
                supplier.getId(),
                supplier.getName(),
                supplier.getWhatsapp(),
                supplier.getCity(),
                supplier.getState(),
                supplier.getAverageShipDays(),
                supplier.getShipsToCustomer(),
                supplier.getAcceptsExchange(),
                supplier.getDefectPolicy(),
                supplier.getNotes(),
                supplier.getActive(),
                supplier.getCreatedAt(),
                supplier.getUpdatedAt()
        );
    }
}
