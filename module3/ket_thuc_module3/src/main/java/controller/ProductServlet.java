package controller;

import bo.CategoryBo;
import bo.CategoryBoImpl;
import bo.ProductBo;
import bo.ProductBoImpl;
import model.Category;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {

    ProductBo productBo = new ProductBoImpl();
    CategoryBo categoryBo = new CategoryBoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
//            case "find":
//                selectCustomerByName(request,response);
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

            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                deleteProduct(request, response);
                break;

            default:
                listAllProduct(request, response);
                break;
        }
    }

    private void listAllProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = this.productBo.findAllProduct();
        List<Category> categoryList = this.categoryBo.findAllCategory();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        try {
            request.getRequestDispatcher("productDisplay.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getParameter("action");

        List<Category> categoryList = this.categoryBo.findAllCategory();
        request.setAttribute("categoryList", categoryList)
        ;
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String category = request.getParameter("category");
        Product product = new Product(name, price, quantity, color, category);
//         String message=this.productBo.insertProduct(product);
        this.productBo.insertProduct(product);
//         List<Category>categoryList=this.categoryBo.findAllCategory();
//         request.setAttribute("message",message);
//         request.setAttribute("categoryList",categoryList);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        //User existingUser = userDAO.selectUser(id);
        Product product = this.productBo.selectProductByID(id);
        List<Category> categoryList = this.categoryBo.findAllCategory();

        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");

        request.setAttribute("categoryList", categoryList);
        request.setAttribute("product", product);
        dispatcher.forward(request, response);

    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String category = request.getParameter("category");
        String id = request.getParameter("id");
        Product product = new Product(id, name, price, quantity, color, category);
        String message = productBo.updateProduct(product);

        List<Category> categoryList = this.categoryBo.findAllCategory();
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("message", message);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idProductHidden");
        String message = this.productBo.deleteProductByID(id);
        List<Product> productList = this.productBo.findAllProduct();

        request.setAttribute("productList", productList);
        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("productDisplay.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
