package bo.contractDetails;

import dao.contractDetails.ContractDetailsDao;
import dao.contractDetails.ContractDetailsDaoImpl;
import model.contracDetails.ContractDetails;

public class ContractDetailsBoImpl implements ContractDetailsBo {
    ContractDetailsDao contractDetailsDao=new ContractDetailsDaoImpl();

    @Override
    public String insertContractDetails(ContractDetails contractDetails) {
        return this.contractDetailsDao.insertContractDetails(contractDetails);
    }
}
