package br.com.pequenosencantos.supplier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    private UUID id;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 30)
    private String whatsapp;

    @Column(length = 80)
    private String city;

    @Column(length = 2)
    private String state;

    @Column(name = "average_ship_days")
    private Integer averageShipDays;

    @Column(name = "ships_to_customer", nullable = false)
    private Boolean shipsToCustomer = true;

    @Column(name = "accepts_exchange", nullable = false)
    private Boolean acceptsExchange = false;

    @Column(name = "defect_policy", columnDefinition = "TEXT")
    private String defectPolicy;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    protected Supplier() {
    }

    public Supplier(
            String name,
            String whatsapp,
            String city,
            String state,
            Integer averageShipDays,
            Boolean shipsToCustomer,
            Boolean acceptsExchange,
            String defectPolicy,
            String notes
    ) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.whatsapp = whatsapp;
        this.city = city;
        this.state = normalizeState(state);
        this.averageShipDays = averageShipDays;
        this.shipsToCustomer = valueOrDefault(shipsToCustomer, true);
        this.acceptsExchange = valueOrDefault(acceptsExchange, false);
        this.defectPolicy = defectPolicy;
        this.notes = notes;
        this.active = true;
    }

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public void update(
            String name,
            String whatsapp,
            String city,
            String state,
            Integer averageShipDays,
            Boolean shipsToCustomer,
            Boolean acceptsExchange,
            String defectPolicy,
            String notes
    ) {
        this.name = name;
        this.whatsapp = whatsapp;
        this.city = city;
        this.state = normalizeState(state);
        this.averageShipDays = averageShipDays;
        this.shipsToCustomer = valueOrDefault(shipsToCustomer, true);
        this.acceptsExchange = valueOrDefault(acceptsExchange, false);
        this.defectPolicy = defectPolicy;
        this.notes = notes;
    }

    public void deactivate() {
        this.active = false;
    }

    private Boolean valueOrDefault(Boolean value, Boolean defaultValue) {
        return value == null ? defaultValue : value;
    }

    private String normalizeState(String state) {
        return state == null ? null : state.toUpperCase();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getAverageShipDays() {
        return averageShipDays;
    }

    public Boolean getShipsToCustomer() {
        return shipsToCustomer;
    }

    public Boolean getAcceptsExchange() {
        return acceptsExchange;
    }

    public String getDefectPolicy() {
        return defectPolicy;
    }

    public String getNotes() {
        return notes;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
