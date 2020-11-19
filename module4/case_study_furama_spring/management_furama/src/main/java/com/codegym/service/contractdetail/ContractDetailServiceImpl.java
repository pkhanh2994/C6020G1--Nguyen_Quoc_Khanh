package com.codegym.service.contractdetail;

import com.codegym.entity.contractdetail.ContractDetail;
import com.codegym.repository.contract.ContractRepository;
import com.codegym.repository.contractdetail.ContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements ContractDetailService{
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return this.contractDetailRepository.findAll(pageable);
    }

    @Override
    public Page<ContractDetail> findAllContractDetailById(Pageable pageable, String contractDetailId) {
        return this.contractDetailRepository.findAllByIdContractDetails(pageable,contractDetailId);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }
}
