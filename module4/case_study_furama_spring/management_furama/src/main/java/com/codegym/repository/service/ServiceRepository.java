package com.codegym.repository.service;

import com.codegym.entity.service.ServiceFrurama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepository extends JpaRepository<ServiceFrurama,String> {
    @Query(value = "select * from service where service_name like %?1%", nativeQuery = true)
    Page<ServiceFrurama> findAllByNameService(Pageable pageable, String serviceName);
}
