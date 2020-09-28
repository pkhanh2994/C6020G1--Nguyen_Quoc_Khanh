import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDiscount",urlPatterns = "/discountProduct")
public class ServletDiscount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String direction=request.getParameter("direction");
        String price=request.getParameter("price");
        String discount=request.getParameter("discount");

        double result=Double.parseDouble(discount)*Double.parseDouble(price)*0.01;

        request.setAttribute("amount",String.valueOf(result));
        request.setAttribute("direction",direction);

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        request.getRequestDispatcher("result_amount.jsp").forward(request,response);

    }


}
