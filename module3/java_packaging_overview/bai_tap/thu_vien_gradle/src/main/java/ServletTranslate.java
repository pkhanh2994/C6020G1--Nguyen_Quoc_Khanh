import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletTranslate",urlPatterns ="/translate")
public class ServletTranslate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String search = request.getParameter("txtSearch");
        String result=dictionary.get(search);

        String resultSearch;
        if(result!=null){
            resultSearch="search :"+search+"\n";
            resultSearch+="result :"+result;
        }else {
            resultSearch="No world";

        }
        request.setAttribute("result",resultSearch);
        request.getRequestDispatcher("result_dictionary.jsp").forward(request,response);
    }
}