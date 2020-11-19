package com.codegym.service.attachService;

import com.codegym.entity.attachService.AttachService;
import com.codegym.repository.attachService.AttachServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService{
    @Autowired
    private AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return this.attachServiceRepository.findAll();
    }
}
