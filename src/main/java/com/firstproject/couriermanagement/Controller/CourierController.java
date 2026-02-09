package com.example.couriermanagement.controller;

import com.example.couriermanagement.model.Courier;
import com.example.couriermanagement.service.CourierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/couriers")
public class CourierController {

    private final CourierService courierService;

    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping
    public Courier addCourier(@RequestBody Courier courier) {
        return courierService.saveCourier(courier);
    }

    @GetMapping
    public List<Courier> getAllCouriers() {
        return courierService.getAllCouriers();
    }

    @GetMapping("/{id}")
    public Courier getCourier(@PathVariable Long id) {
        return courierService.getCourierById(id);
    }

    @PutMapping("/{id}/status")
    public Courier updateStatus(@PathVariable Long id, @RequestParam String status) {
        return courierService.updateStatus(id, status);
    }
}
