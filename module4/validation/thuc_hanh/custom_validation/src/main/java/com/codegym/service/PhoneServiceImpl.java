package com.codegym.service;

import com.codegym.entity.Phone;
import com.codegym.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;
    @Override
    public void save(Phone phone) {
        this.phoneRepository.save(phone);

    }
}
