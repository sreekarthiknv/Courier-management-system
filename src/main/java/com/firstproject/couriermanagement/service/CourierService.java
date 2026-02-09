package com.example.couriermanagement.service;

import com.example.couriermanagement.model.Courier;
import com.example.couriermanagement.repository.CourierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierService {

    private final CourierRepository courierRepository;

    public CourierService(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    public Courier saveCourier(Courier courier) {
        return courierRepository.save(courier);
    }

    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    public Courier getCourierById(Long id) {
        return courierRepository.findById(id).orElse(null);
    }

    public Courier updateStatus(Long id, String status) {
        Courier courier = courierRepository.findById(id).orElse(null);
        if (courier != null) {
            courier.setStatus(status);
            return courierRepository.save(courier);
        }
        return null;
    }
}
