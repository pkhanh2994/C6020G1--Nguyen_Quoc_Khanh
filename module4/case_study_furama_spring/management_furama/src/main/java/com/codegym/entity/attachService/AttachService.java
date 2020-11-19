package com.codegym.entity.attachService;

import com.codegym.entity.contractdetail.ContractDetail;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "attach_service")
public class AttachService {
    @Id
    @Column(name = "attach_service_id")
    private String attach_service_id;
    @Column(name = "attach_service_name")
    private String attach_service_name;
    @Column(name = "attach_service_cost")
    @Pattern(regexp ="^[1-9][\\d]*",message = "cost must be number" )
    private String attach_service_cost;
    @Column(name = "attach_service_unit")
    private String attach_service_unit;
    @Column(name = "attach_service_status")
    private String attach_service_status;
    @OneToMany(mappedBy = "attachService", cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetailList;

    public AttachService() {
    }

    public String getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(String attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }

    public String getAttach_service_cost() {
        return attach_service_cost;
    }

    public void setAttach_service_cost(String attach_service_cost) {
        this.attach_service_cost = attach_service_cost;
    }

    public String getAttach_service_unit() {
        return attach_service_unit;
    }

    public void setAttach_service_unit(String attach_service_unit) {
        this.attach_service_unit = attach_service_unit;
    }

    public String getAttach_service_status() {
        return attach_service_status;
    }

    public void setAttach_service_status(String attach_service_status) {
        this.attach_service_status = attach_service_status;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
