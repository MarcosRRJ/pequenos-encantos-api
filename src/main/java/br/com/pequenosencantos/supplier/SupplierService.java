package br.com.pequenosencantos.supplier;

import br.com.pequenosencantos.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Transactional
    public SupplierResponse create(CreateSupplierRequest request) {
        Supplier supplier = new Supplier(
                request.name(),
                request.whatsapp(),
                request.city(),
                request.state(),
                request.averageShipDays(),
                request.shipsToCustomer(),
                request.acceptsExchange(),
                request.defectPolicy(),
                request.notes()
        );

        return SupplierResponse.from(supplierRepository.save(supplier));
    }

    @Transactional(readOnly = true)
    public List<SupplierResponse> findAllActive() {
        return supplierRepository.findAllByActiveTrueOrderByNameAsc()
                .stream()
                .map(SupplierResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public SupplierResponse findById(UUID id) {
        return SupplierResponse.from(findActiveSupplier(id));
    }

    @Transactional
    public SupplierResponse update(UUID id, UpdateSupplierRequest request) {
        Supplier supplier = findActiveSupplier(id);
        supplier.update(
                request.name(),
                request.whatsapp(),
                request.city(),
                request.state(),
                request.averageShipDays(),
                request.shipsToCustomer(),
                request.acceptsExchange(),
                request.defectPolicy(),
                request.notes()
        );

        return SupplierResponse.from(supplier);
    }

    @Transactional
    public void delete(UUID id) {
        Supplier supplier = findActiveSupplier(id);
        supplier.deactivate();
    }

    private Supplier findActiveSupplier(UUID id) {
        return supplierRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado."));
    }
}
