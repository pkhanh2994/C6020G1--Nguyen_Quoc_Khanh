package com.codegym.service.serviceFurama;

import com.codegym.entity.service.TypeOfRent;
import com.codegym.entity.service.TypeOfService;

import java.util.List;

public interface TypeOfServiceService {
    List<TypeOfService> findAllTypeOfService();
}
