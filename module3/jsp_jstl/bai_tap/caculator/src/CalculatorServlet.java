import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nums1= (String) request.getParameter("nums1");
    String nums2= (String) request.getParameter("nums2");
    String operator= (String) request.getParameter("operator");
        String display;
    try {

        double result =Calculator.calculator(Double.parseDouble(nums1),Double.parseDouble(nums2),operator);
        display= (nums1+ " " +operator+" "+nums2+ " "+"="+" "+result);

    }catch (RuntimeException e){
        display=e.getMessage();
    }
        request.setAttribute("display",display);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

}
