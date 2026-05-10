package br.com.pequenosencantos.supplier;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {

    List<Supplier> findAllByActiveTrueOrderByNameAsc();

    Optional<Supplier> findByIdAndActiveTrue(UUID id);
}
