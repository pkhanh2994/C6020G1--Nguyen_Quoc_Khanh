package com.codegym.service.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.repository.contract.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return this.contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllByContractId(Pageable pageable, String idContract) {
        return this.contractRepository.findAllByIdContract(pageable, idContract);
    }

    @Override
    public void save(Contract contract) {
        this.contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return this.contractRepository.findAll();
    }
}
