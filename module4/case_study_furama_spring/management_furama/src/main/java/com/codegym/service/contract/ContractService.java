package com.codegym.service.contract;

import com.codegym.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    Page<Contract>findAll(Pageable pageable);
    Page<Contract>findAllByContractId(Pageable pageable,String idContract);
    void save(Contract contract);
    List<Contract> findAll();
}
