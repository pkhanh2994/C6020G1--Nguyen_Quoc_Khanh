package com.codegym.service.serviceFurama;

import com.codegym.entity.service.ServiceFrurama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceFuramaService {
    Page<ServiceFrurama> findAll(Pageable pageable);
    Page<ServiceFrurama>findAllByNameService(Pageable pageable, String serviceName);
    void save(ServiceFrurama serviceFrurama);
    void deleteServiceById(String serviceId);
    ServiceFrurama findServiceById(String serviceId);
}
