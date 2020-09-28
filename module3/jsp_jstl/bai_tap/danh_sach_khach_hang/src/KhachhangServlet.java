import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "KhachhangServlet",urlPatterns = {"","/hienthidanhsach"})
public class KhachhangServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> danhSach=new ArrayList<>();

        KhachHang khachHang=new KhachHang("Din","12/12/1009","Da Nang","https://img1.kienthucvui.vn/uploads/2019/10/10/anh-chibi-naruto_110701874.jpg");
        KhachHang khachHang1=new KhachHang("Din Ga","12/12/1009","Quang Nam","https://img1.kienthucvui.vn/uploads/2019/10/10/anh-dep-ve-naruto_110702093.jpg");
        KhachHang khachHang2=new KhachHang("Din Vit","12/12/1009","Tam Ky","https://img1.kienthucvui.vn/uploads/2019/10/10/anh-dep-ve-naruto_110702093.jpg");
        KhachHang khachHang3=new KhachHang("Din Heo","12/12/1009","My","https://img1.kienthucvui.vn/uploads/2019/10/10/anh-hoat-hinh-naruto_110702265.jpg");
        KhachHang khachHang4=new KhachHang("Din Cho","12/12/1009","Viet Nam","https://img1.kienthucvui.vn/uploads/2019/10/10/anh-hoat-hinh-naruto_110702265.jpg");

        danhSach.add(khachHang);
        danhSach.add(khachHang1);
        danhSach.add(khachHang2);
        danhSach.add(khachHang3);
        danhSach.add(khachHang4);

        request.setAttribute("danhSachKhachHang",danhSach);
        request.getRequestDispatcher("hienThi.jsp").forward(request,response);
    }
}
