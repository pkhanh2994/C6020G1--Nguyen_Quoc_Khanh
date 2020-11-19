package com.codegym.entity.contractdetail;

import com.codegym.entity.attachService.AttachService;
import com.codegym.entity.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity(name = "contract_detail")
public class ContractDetail {
    @Id
    @Column(name = "contract_detail_id")
    private String contract_detail_id;
    @Column(name = "quantity")
    @Pattern(regexp = "^[1-9][\\d]*",message = "Quantity must be number")
    private String quantity;
    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "contract_id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName = "attach_service_id")
    private AttachService attachService;

    public ContractDetail() {
    }

    public String getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(String contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
