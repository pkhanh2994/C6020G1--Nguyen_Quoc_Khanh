package controller;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = {"","/product"})
public class ProductServlet extends HttpServlet {
     ProductDAO productDAO=new ProductDAOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showUpdate(request,response);
                break;
            case "delete":
                showDelete(request,response);
                break;
            case "view":
                viewProduct(request,response);
                break;
            default:
                listProduct(request, response);
                break;
        }

    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productDAO.findById(id);
        if(product == null){
            request.getRequestDispatcher("error-404.jsp").forward(request,response);
        } else {
            this.productDAO.remove(id);
                response.sendRedirect("/product");

        }

    }
    private void showDelete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Product product=this.productDAO.findById(id);
        if(product == null){
            request.getRequestDispatcher("error-404.jsp").forward(request,response);
        } else {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product/delete.jsp").forward(request,response);
        }
    }
        private void updateProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
            int id=Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            String manufacturer=request.getParameter("manufacturer");
            Product product = this.productDAO.findById(id);
            if(product == null){
              request.getRequestDispatcher("error-404.jsp").forward(request,response);
            } else {
                product.setName(name);
                product.setPrice(price);
                product.setDescription(description);
                product.setManufacturer(manufacturer);
                this.productDAO.update(id,product);
                request.setAttribute("product", product);
                request.setAttribute("message", "Product information was updated");
             request.getRequestDispatcher("product/edit.jsp").forward(request,response);
            }

        }
    private void showUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    int id=Integer.parseInt((request.getParameter("id")));
    Product product=this.productDAO.findById(id);
        if(product == null){
          request.getRequestDispatcher("error-404.jsp").forward(request,response);
        } else {
            request.setAttribute("product", product);
            request.getRequestDispatcher("product/edit.jsp").forward(request,response);
        }
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacturer=request.getParameter("manufacturer");

        Product product = new Product(id, name,price,description,manufacturer);
        this.productDAO.save(product);
        request.getRequestDispatcher("product/create.jsp").forward(request,response);
        request.setAttribute("message", "New product was created");

    }

    public void showCreate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("product/create.jsp").forward(request,response);

    }
    public void viewProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productDAO.findById(id);

        if(product == null){
            request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
           request.getRequestDispatcher("product/view.jsp").forward(request,response);
        }

    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = this.productDAO.findAll();
        request.setAttribute("productList", products);

         request.getRequestDispatcher("product/list.jsp").forward(request,response);

    }
}
