package com.os.api.ordensdeservicoapi.controller;

import com.os.api.ordensdeservicoapi.model.ServiceOrder;
import com.os.api.ordensdeservicoapi.service.SoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api")
public class SoController {
    private SoService service;

    public SoController(SoService service) {
        this.service = service;
    }

    @PostMapping("/orders")
    public void createOrder(@RequestBody ServiceOrder order) {
        service.createOrder(order);
    }

    @GetMapping("/orders/{id}")
    public ServiceOrder getOrder(@PathVariable UUID id) {
        return service.getOrder(id);
    }

    @GetMapping("/orders")
    public List<ServiceOrder> getAllOrders() {
        return service.getAllOrders();
    }

    @PatchMapping("/orders/start/{id}")
    public void startOrder(@PathVariable UUID id) {
        service.startOrder(id);
    }

    @PatchMapping("/orders/cancel/{id}")
    public void cancelOrder(@PathVariable UUID id) {
        service.cancelOrder(id);
    }

    @PatchMapping("/orders/finish/{id}")
    public void finishOrder(@PathVariable UUID id) {
        service.finishOrder(id);
    }
}
