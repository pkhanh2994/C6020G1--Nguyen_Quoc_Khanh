package controller;

import bo.customer.CustomerBo;
import bo.customer.CustomerBoImpl;
import bo.customer.TypeOfCustomerBO;
import bo.customer.TypeOfCustomerBOImpl;
import model.customer.Customer;
import model.customer.TypeOfCustomer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FuramaServlet", urlPatterns = {"", "/furama"})
public class CustomerServlet extends HttpServlet {
    CustomerBo customerBo = new CustomerBoImpl();
    TypeOfCustomerBO typeOfCustomerBO=new TypeOfCustomerBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    try {
                        insertCustomer(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
            case "edit":
                editCustomer(request,response);
                break;
            case "find":
                selectCustomerByName(request,response);
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
            case "showInfor":
                try {
                    listAllCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                deleteCustomer(request, response);
                break;

            default:
                response.sendRedirect("display.jsp");
        }
    }

    private void listAllCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
       List<Customer>customerList=this.customerBo.selectAllCustomer();
        request.setAttribute("listCustomer", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/showInfor.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             request.getParameter("action");

        List<TypeOfCustomer> typeOfCustomers = this.typeOfCustomerBO.findAllTypeOfCustomer();
        request.setAttribute("typeOfCustomers", typeOfCustomers)
        ;
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idcard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String typeId = request.getParameter("typeOfCustomer");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, typeId, address);
        String message = this.customerBo.insertCustomer(customer);

        List<TypeOfCustomer> typeOfCustomers = this.typeOfCustomerBO.findAllTypeOfCustomer();
        request.setAttribute("typeOfCustomers", typeOfCustomers);

        request.setAttribute("message", message);
        request.getRequestDispatcher("customer/create.jsp").forward(request,response);
    }

    private void deleteCustomer(HttpServletRequest request,HttpServletResponse response){
        List<Customer> customerList = this.customerBo.selectAllCustomer();

        String id = request.getParameter("idCustomerHidden");
        String message= this.customerBo.deleteById(id);

        request.setAttribute("customerList", customerList);
        request.setAttribute("message",message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        //User existingUser = userDAO.selectUser(id);
        Customer customer = customerBo.findCustomerByID(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/update.jsp");
        List<TypeOfCustomer> typeOfCustomers = this.typeOfCustomerBO.findAllTypeOfCustomer();
        request.setAttribute("typeOfCustomers", typeOfCustomers);
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);

    }

    private void editCustomer(HttpServletRequest request,HttpServletResponse response) {

        String name =request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String typeCustomer = request.getParameter("typeOfCustomer");
        String address = request.getParameter("address");
        String id =request.getParameter("id");
        Customer customer = new Customer(id, name, birthday,gender,idCard, phone,typeCustomer,address);
        customerBo.updateCustomer(customer);

        List<TypeOfCustomer> typeOfCustomers = this.typeOfCustomerBO.findAllTypeOfCustomer();
        request.setAttribute("typeOfCustomers", typeOfCustomers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void selectCustomerByName(HttpServletRequest request,HttpServletResponse response){
        String name=request.getParameter("name");
        List<Customer>customerList=this.customerBo.selectCustomerByName(name);
        for(Customer customer:customerList){
            System.out.println(customer.getCustomer_name());
        }
        request.setAttribute("customerList",customerList);
        try {
            request.getRequestDispatcher("customer/selectCustomerByName.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
