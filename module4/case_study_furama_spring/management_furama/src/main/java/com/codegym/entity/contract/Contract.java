package com.codegym.entity.contract;

import com.codegym.entity.contractdetail.ContractDetail;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service.ServiceFrurama;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "contract")
public class Contract {
    @Id
    @Column(name = "contract_id")
    private String contract_id;
    @Column(name = "contract_start_date")
    private String contract_start_date;
    @Column(name = "contract_end_date")
    private String contract_end_date;
    @Column(name = "contract_deposit")
    @Pattern(regexp = "^[1-9][\\d]*",message = "Deposit must be number")
    private String contract_deposit;
    @Column(name = "contract_total_money")
    @Pattern(regexp = "^[1-9][\\d]*",message = "Total money must be number")
    private String contract_total_money;
    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "service_id")
    private ServiceFrurama serviceFrurama;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetailList;

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public Contract() {
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(String contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public String getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(String contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public String getContract_deposit() {
        return contract_deposit;
    }

    public void setContract_deposit(String contract_deposit) {
        this.contract_deposit = contract_deposit;
    }

    public String getContract_total_money() {
        return contract_total_money;
    }

    public void setContract_total_money(String contract_total_money) {
        this.contract_total_money = contract_total_money;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ServiceFrurama getServiceFrurama() {
        return serviceFrurama;
    }

    public void setServiceFrurama(ServiceFrurama serviceFrurama) {
        this.serviceFrurama = serviceFrurama;
    }
}
