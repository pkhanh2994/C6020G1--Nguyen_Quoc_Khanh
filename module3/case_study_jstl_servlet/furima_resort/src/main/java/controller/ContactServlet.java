package controller;

import bo.contact.ContactBo;
import bo.contact.ContactBoImpl;
import bo.customer.CustomerBo;
import bo.customer.CustomerBoImpl;
import bo.employee.EmployeeBo;
import bo.employee.EmployeeBoImpl;
import bo.service.ServiceBo;
import bo.service.ServiceBoImpl;
import model.contact.Contract;
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

@WebServlet(name = "ContactServlet",urlPatterns = "/contract")
public class ContactServlet extends HttpServlet {
    ContactBo contactBo=new ContactBoImpl();
    EmployeeBo employeeBo=new EmployeeBoImpl();
    CustomerBo customerBo= new CustomerBoImpl();
    ServiceBo serviceBo= new  ServiceBoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertContact(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
//            case "edit":
//                editContact(request,response);
//                break;
//            case "find":
//                selectContact(request,response);
//                break;
//        }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "showInfor":
                try {
                    listAllContract(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
//            case "edit":
//                try {
//                    showEditForm(request,response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
//            case "delete":
//                deleteCustomer(request, response);
//                break;

            default:
                response.sendRedirect("display.jsp");
        }
    }


    private void listAllContract(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Contract>contractList=this.contactBo.selectAllContract();
        request.setAttribute("contractList", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/showInfor.jsp");
        dispatcher.forward(request, response);
    }


    private void showNewForm(HttpServletRequest request,HttpServletResponse response){
        request.getParameter("action");

        List<Employee>employeeList=this.employeeBo.selectAllEmployee();
        List<Customer>customerList=this.customerBo.selectAllCustomer();
        List<Service>serviceList=this.serviceBo.selectAllService();

        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void insertContact(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {

        String id = request.getParameter("id");
        String contractStartDate = request.getParameter("contract_start_date");
        String contractEndDate = request.getParameter("contract_end_date");
        String contractDeposit = request.getParameter("contract_deposit");
        String contractTotalMoney = request.getParameter("contract_total_money");
        String employee = request.getParameter("employee");
        String customer = request.getParameter("customer");
        String service = request.getParameter("service");
        Contract contract = new Contract(id,contractStartDate,contractEndDate,contractDeposit,contractTotalMoney,employee,customer,service);
        String message = this.contactBo.insertContact(contract);


        List<Employee>employeeList=this.employeeBo.selectAllEmployee();
        List<Customer>customerList=this.customerBo.selectAllCustomer();
        List<Service>serviceList=this.serviceBo.selectAllService();

        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        request.setAttribute("contract", contract);
        request.setAttribute("message", message);
        request.getRequestDispatcher("contract/create.jsp").forward(request,response);


    }
}
