package controller;

import bo.attacService.AttactServiceBo;
import bo.attacService.AttactServiceBoImpl;
import bo.contact.ContactBo;
import bo.contact.ContactBoImpl;
import bo.contractDetails.ContractDetailsBo;
import bo.contractDetails.ContractDetailsBoImpl;
import bo.service.ServiceBo;
import bo.service.ServiceBoImpl;
import model.acttactService.AttactService;
import model.contact.Contract;
import model.contracDetails.ContractDetails;
import model.customer.Customer;
import model.employee.Employee;
import model.service.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractDetailsServlet",urlPatterns = "/contractDetails")
public class ContractDetailsServlet extends HttpServlet {
    ContractDetailsBo contractDetailsBo=new ContractDetailsBoImpl();
    ContactBo contactBo=new ContactBoImpl();
    AttactServiceBo attactServiceBo=new AttactServiceBoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertContractDetails(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                default:
                    response.sendRedirect("display.jsp");
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getParameter("action");

        List<Contract> contractList =this.contactBo.selectAllContract();
        List<AttactService>attactServiceList=this.attactServiceBo.selectAllAttactService();

        request.setAttribute("contractList",contractList);
        request.setAttribute("attactServiceList",attactServiceList);


        RequestDispatcher dispatcher = request.getRequestDispatcher("contractDetails/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertContractDetails(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {

        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");
        String contract = request.getParameter("contract");
        String attactService = request.getParameter("attactService");
        ContractDetails contractDetails=new ContractDetails(id,quantity,contract,attactService);

        String message = this.contractDetailsBo.insertContractDetails(contractDetails);

        List<Contract> contractList =this.contactBo.selectAllContract();
        List<AttactService>attactServiceList=this.attactServiceBo.selectAllAttactService();

        request.setAttribute("contractList",contractList);
        request.setAttribute("attactServiceList",attactServiceList);


        request.setAttribute("contractDetails", contractDetails);
        request.setAttribute("message", message);
        request.getRequestDispatcher("contractDetails/create.jsp").forward(request,response);


    }

}
