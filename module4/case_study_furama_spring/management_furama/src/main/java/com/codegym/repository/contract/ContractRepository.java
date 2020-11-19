package com.codegym.repository.contract;

import com.codegym.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract,String> {

    @Query(value = "select * from contract where contract_id like %?1%", nativeQuery = true)
    Page<Contract> findAllByIdContract(Pageable pageable, String idContract);
}
