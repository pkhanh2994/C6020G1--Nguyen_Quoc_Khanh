package controller;

import bo.customerUsingService.CustomerUsingServiceBo;
import bo.customerUsingService.CustomerUsingServiceBoImpl;
import model.customer.Customer;
import model.customerUsingService.CustomerUsingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerUsingServiceServlet",urlPatterns = "/userService")
public class CustomerUsingServiceServlet extends HttpServlet {
    CustomerUsingServiceBo customerUsingServiceBo=new CustomerUsingServiceBoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showInfor":
                try {
                    listAllCustomerUsingService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    private void listAllCustomerUsingService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<CustomerUsingService> customerUsingServiceList=this.customerUsingServiceBo.selectAllCustomerUsingService();
        request.setAttribute("customerUsingServiceList", customerUsingServiceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customerUsingService/showInfor.jsp");
        dispatcher.forward(request, response);
    }


}
