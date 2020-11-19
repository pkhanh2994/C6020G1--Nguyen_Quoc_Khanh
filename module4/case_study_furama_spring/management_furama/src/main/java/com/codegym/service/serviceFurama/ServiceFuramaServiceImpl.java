package com.codegym.service.serviceFurama;

import com.codegym.entity.service.ServiceFrurama;
import com.codegym.repository.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceFuramaServiceImpl implements ServiceFuramaService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Page<ServiceFrurama> findAll(Pageable pageable) {
        return this.serviceRepository.findAll(pageable);
    }

    @Override
    public Page<ServiceFrurama> findAllByNameService(Pageable pageable, String serviceName) {
        return this.serviceRepository.findAllByNameService(pageable,serviceName);
    }

    @Override
    public void save(ServiceFrurama serviceFrurama) {
        this.serviceRepository.save(serviceFrurama);

    }

    @Override
    public void deleteServiceById(String serviceId) {
        this.serviceRepository.deleteById(serviceId);

    }

    @Override
    public ServiceFrurama findServiceById(String serviceId) {
        return this.serviceRepository.findById(serviceId).orElse(null);
    }
}
