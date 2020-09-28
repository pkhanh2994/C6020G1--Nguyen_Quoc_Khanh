import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletConvertMoney",urlPatterns = "/Convert")
public class ServletConvertMoney extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        float vnd = rate * usd;
        request.setAttribute("result",vnd);
        request.setAttribute("rate",rate);
        request.setAttribute("usd",usd);
        request.getRequestDispatcher("result_convert.jsp").forward(request,response);
    }

}
