package controller;

import bo.employee.*;
import model.customer.TypeOfCustomer;
import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeBo employeeBo=new EmployeeBoImpl();
    EducationDegreeBo educationDegreeBo=new EducationDegreeBoImpl();
    PositionBo positionBo=new PositionBoImpl();
    DivisionBo divisionBo =new DivisionBoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                try {
//                    insertEmployee(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
                break;
//            case "edit":
//                editEmployee(request,response);
//                break;
//            case "find":
//                selectEmployee(request,response);
//                break;
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
//            case "showInfor":
//                try {
//                    listAllCustomer(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
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
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getParameter("action");

        List<Division> divisions = this.divisionBo.findAllDivision();
        request.setAttribute("divisions", divisions);

        List<EducationDegree> educationDegrees = this.educationDegreeBo.findAllEducation();
        request.setAttribute("educationDegrees", educationDegrees);

        List<Position> positions = this.positionBo.findAllPosition();
        request.setAttribute("positions", positions);


        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

}
