package controller;

import bo.service.*;
import model.service.Service;
import model.service.TypeOfRent;
import model.service.TypeOfService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = {"/service"})
public class ServiceServlet extends HttpServlet {
    ServiceBo serviceBo = new ServiceBoImpl();
    TypeOfServiceBo typeOfService=new TypeOfServiceBoImpl();
    TypeOfRentBo typeOfRentBo=new TypeOfRentImplBo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertService(request, response);
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

        }
    }
        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getParameter("action");

            List<TypeOfService> typeOfServices = this.typeOfService.findAllTypeOfService();
            request.setAttribute("typeOfServices", typeOfServices);
            List<TypeOfRent> typeOfRents = this.typeOfRentBo.findAllTypeOfRent();
            request.setAttribute("typeOfRents", typeOfRents);

            RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
            dispatcher.forward(request, response);
        }
    private void insertService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("service_id");
        String name = request.getParameter("service_name");
        String area = request.getParameter("service_area");
        String cost = request.getParameter("service_cost");
        String maxPeople = request.getParameter("service_max_people");
        String room = request.getParameter("standard_room");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        String poolArea = request.getParameter("pool_area");
        String numberOfFloors = request.getParameter("number_of_floors");
        String rentTypeId = request.getParameter("rent_type_id");
        String serviceTypeId = request.getParameter("service_type_id");
        Service service = new Service(id, name,area,cost,maxPeople,room,descriptionOtherConvenience,poolArea,numberOfFloors,rentTypeId,serviceTypeId);
        String message = this.serviceBo.insertService(service);


        List<TypeOfService> typeOfServices = this.typeOfService.findAllTypeOfService();
        request.setAttribute("typeOfServices", typeOfServices);
        List<TypeOfRent> typeOfRents = this.typeOfRentBo.findAllTypeOfRent();
        request.setAttribute("typeOfRents", typeOfRents);

        request.setAttribute("message", message);
        request.getRequestDispatcher("customer/create.jsp").forward(request,response);
    }

}
