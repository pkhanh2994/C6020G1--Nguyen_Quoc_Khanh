package controller;

import bo.employee.*;
import model.customer.Customer;
import model.customer.TypeOfCustomer;
import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
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
                try {
                    insertEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "find":
                selectEmployee(request,response);
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
                    listAllEmployee(request, response);
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
                deleteEmployee(request, response);
                break;

            default:
                response.sendRedirect("display.jsp");
        }

    }
    private void listAllEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee>employeeList=this.employeeBo.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/showInfor.jsp");
        dispatcher.forward(request, response);
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
    private void insertEmployee(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("employee_id");
        String name = request.getParameter("employee_name");
        String birthday = request.getParameter("employee_birthday");
        String idCard = request.getParameter("employee_id_card");
        String salary = request.getParameter("employee_salary");
        String phone = request.getParameter("employee_phone");
        String employeeEmail = request.getParameter("employee_email");
        String address = request.getParameter("employee_address");
        String userName = request.getParameter("user_name");
        String positionId = request.getParameter("position_id");
        String degrees = request.getParameter("educationDegrees");
        String divisions = request.getParameter("divisions");
        Employee employee = new Employee(id, name,birthday,idCard,salary,phone,employeeEmail,address,positionId,degrees,divisions,userName);
        String message = this.employeeBo.insertEmployee(employee);

        List<Division> division = this.divisionBo.findAllDivision();
        request.setAttribute("divisions", division);



        List<EducationDegree> educationDegrees = this.educationDegreeBo.findAllEducation();
        request.setAttribute("educationDegrees", educationDegrees);

        List<Position> positions = this.positionBo.findAllPosition();
        request.setAttribute("positions", positions);


        request.setAttribute("message", message);

        request.getRequestDispatcher("customer/create.jsp").forward(request,response);
    }

    private  void deleteEmployee(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("idEmployeeHidden");
        String message= this.employeeBo.deleteById(id);

        List<Employee>employeeList=this.employeeBo.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);

        request.setAttribute("message",message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/showInfor.jsp");
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

        Employee employee = employeeBo.findEmployeeByID(id);

        List<Division> division = this.divisionBo.findAllDivision();
        request.setAttribute("divisions", division);

        List<EducationDegree> educationDegrees = this.educationDegreeBo.findAllEducation();
        request.setAttribute("educationDegrees", educationDegrees);

        List<Position> positions = this.positionBo.findAllPosition();
        request.setAttribute("positions", positions);

        request.setAttribute("employee", employee);
        request.getRequestDispatcher("employee/update.jsp").forward(request,response);

    }
    private void editEmployee(HttpServletRequest request,HttpServletResponse response) {
        String id=request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String employeeEmail = request.getParameter("email");
        String address = request.getParameter("email");
        String userName = request.getParameter("userName");
        String positionId = request.getParameter("positions");
        String degrees = request.getParameter("educationDegrees");
        String divisions = request.getParameter("divisions");
        Employee employee = new Employee(id,name,birthday,idCard,salary,phone,employeeEmail,address,
                positionId,degrees,divisions,userName);
       String message= employeeBo.updateEmployee(employee);

        List<EducationDegree> educationDegrees = this.educationDegreeBo.findAllEducation();
        request.setAttribute("educationDegrees", educationDegrees);

        List<Position> positions = this.positionBo.findAllPosition();
        request.setAttribute("positions", positions);

        List<Division> division = this.divisionBo.findAllDivision();
        request.setAttribute("divisions", division);
        request.setAttribute("message",message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void selectEmployee(HttpServletRequest request,HttpServletResponse response){
        String name=request.getParameter("name");
        List<Employee>employeeList=this.employeeBo.selectEmployeeByName(name);

        request.setAttribute("employeeList",employeeList);
        try {
            request.getRequestDispatcher("employee/showInfor.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
