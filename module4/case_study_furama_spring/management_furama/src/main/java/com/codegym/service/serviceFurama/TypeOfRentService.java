package com.codegym.service.serviceFurama;

import com.codegym.entity.customer.TypeOfCustomer;
import com.codegym.entity.service.TypeOfRent;

import java.util.List;

public interface TypeOfRentService {
    List<TypeOfRent> findAllTypeOfRent();
}
