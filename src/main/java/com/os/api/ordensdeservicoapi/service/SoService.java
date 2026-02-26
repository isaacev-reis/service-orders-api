package com.os.api.ordensdeservicoapi.service;

import com.os.api.ordensdeservicoapi.model.SoModel;
import com.os.api.ordensdeservicoapi.repository.SoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SoService {
    private SoRepository repository;

    public SoService(SoRepository repository) {
        this.repository = repository;
    }

    public void createOrder(SoModel order) {
        UUID id = UUID.randomUUID();
        order.setId(id);
        order.createOrder();
        repository.save(order);
    }

    public void cancelOrder(UUID id) {
        SoModel order = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
        order.cancelOrder();
        repository.save(order);
    }

    public SoModel getOrder(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    public void startOrder(UUID id) {
        SoModel order = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));
        order.startOrder();
        repository.save(order);
    }

    public void finishOrder(UUID id) {
        SoModel order = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found"));;
        order.finishOrder();
        repository.save(order);
    }

    public List<SoModel> getAllOrders() {
        return repository.findAll();
    }
}