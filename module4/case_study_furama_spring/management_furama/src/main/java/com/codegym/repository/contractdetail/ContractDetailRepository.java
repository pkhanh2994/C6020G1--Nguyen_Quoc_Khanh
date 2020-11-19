package com.codegym.repository.contractdetail;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.contractdetail.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,String> {
    @Query(value = "select * from contract_detail where contract_detail_id like %?1%", nativeQuery = true)
    Page<ContractDetail> findAllByIdContractDetails(Pageable pageable, String idContractDetail);
}
