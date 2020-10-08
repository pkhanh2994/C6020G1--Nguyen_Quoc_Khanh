package model.contracDetails;

public class ContractDetails {
    private String contract_detail_id;
    private String quantity;
    private String contract_id;
    private String attach_service_id;

    public ContractDetails(String contract_detail_id, String quantity, String contract_id, String attach_service_id) {
        this.contract_detail_id = contract_detail_id;
        this.quantity = quantity;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
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

    public String getContract_id() {
        return contract_id;
    }

    public void setContract_id(String contract_id) {
        this.contract_id = contract_id;
    }

    public String getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(String attach_service_id) {
        this.attach_service_id = attach_service_id;
    }
}
