package com.codegym.service.contractdetail;

import com.codegym.entity.contractdetail.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    Page<ContractDetail> findAllContractDetailById(Pageable pageable, String contractDetailId);

    void save(ContractDetail contractDetail);
}
