package model.customerUsingService;

public class CustomerUsingService {
    private String customer_name;
    private String customer_id;
    private String contract_id;

    private String attach_service_name;


    public CustomerUsingService(String customer_name, String customer_id, String contract_id, String attach_service_name) {
        this.customer_name = customer_name;
        this.customer_id = customer_id;
        this.contract_id = contract_id;
        this.attach_service_name = attach_service_name;
    }


    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }


    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }
}
