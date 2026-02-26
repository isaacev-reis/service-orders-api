package com.os.api.ordensdeservicoapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class SoModel {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "description")
    private String description;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "opening_date")
    private LocalDate openingDate;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "valor")
    private BigDecimal value;

    public void createOrder() {
        if (status == Status.OPEN) {
            throw new IllegalStateException("This order already is open!");
        }
        this.status = Status.OPEN;
    }

    public void startOrder() {
        if (status != Status.OPEN) {
            throw new IllegalStateException("The order hasn't open yet!");
        }
        this.status = Status.IN_PROGRESS;
    }

    public void finishOrder() {
        if (status != Status.IN_PROGRESS) {
            throw new IllegalStateException("The service hasn't started yet!");
        }
        this.status = Status.COMPLETED;
    }

    public void cancelOrder() {
        if (status != Status.OPEN && status != Status.IN_PROGRESS) {
            throw new IllegalStateException("This service already completed!");
        }
        this.status = Status.CANCELED;
    }
}
