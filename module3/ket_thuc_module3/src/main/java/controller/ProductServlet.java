package controller;

import bo.*;
import model.Category;
import model.Color;
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
    ColorBo colorBo=new ColorBoImpl();

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
//                selectProductByName(request,response);
//                break;
//            case "findPrice":
//                selectProductByPrice(request,response);
//                break;
            case "findPriceName":
                selectProductByPriceName(request,response);
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
        List<Color> colorList = this.colorBo.findAllColor();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("colorList", colorList);
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
        request.setAttribute("categoryList", categoryList);
        List<Color> colorList = this.colorBo.findAllColor();

        request.setAttribute("colorList", colorList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        String colorID = request.getParameter("colorID");
        Product product = new Product(name, price, quantity, category,description,colorID);
         String message=this.productBo.insertProduct(product);
        List<Category>categoryList=this.categoryBo.findAllCategory();
        List<Color> colorList = this.colorBo.findAllColor();

        request.setAttribute("colorList", colorList);

        request.setAttribute("message", message);
        request.setAttribute("categoryList", categoryList);

        if(message.equals("created new product")) {
             try {
                 response.sendRedirect("/product");
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }else {
             request.getRequestDispatcher("create.jsp").forward(request, response);
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
        String description = request.getParameter("description");
        String id = request.getParameter("id");
        Product product = new Product(id, name, price, quantity, color, category,description);
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
        List<Category> categoryList = this.categoryBo.findAllCategory();
        List<Color> colorList = this.colorBo.findAllColor();
        request.setAttribute("colorList", colorList);
        request.setAttribute("categoryList", categoryList);
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
    private void selectProductByName(HttpServletRequest request,HttpServletResponse response){
        String name=request.getParameter("name");
        List<Product>productList=this.productBo.selectProductByName(name);

        List<Category>categoryList=this.categoryBo.findAllCategory();

        request.setAttribute("categoryList",categoryList);
        List<Color> colorList = this.colorBo.findAllColor();

        request.setAttribute("colorList", colorList);
        request.setAttribute("productList",productList);
        try {
            request.getRequestDispatcher("productDisplay.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void selectProductByPrice(HttpServletRequest request,HttpServletResponse response){
        String price=request.getParameter("price");
        List<Product>productList=this.productBo.selectProductByPrice(price);
        List<Category>categoryList=this.categoryBo.findAllCategory();
        request.setAttribute("categoryList",categoryList);
        List<Color> colorList = this.colorBo.findAllColor();
        request.setAttribute("colorList", colorList);

        request.setAttribute("productList",productList);
        try {
            request.getRequestDispatcher("productDisplay.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectProductByPriceName(HttpServletRequest request,HttpServletResponse response){
        String price=request.getParameter("price");
        String name=request.getParameter("name");
        List<Product>productList=null;
        if(price.equals("")){
            productList=this.productBo.selectProductByName(name);
        }else if(price.equals("")){
            productList=this.productBo.selectProductByPrice(
                    price);
        }else {
            productList=this.productBo.selectProductByNameAndPrice(price,name);
        }
        List<Category>categoryList=this.categoryBo.findAllCategory();
        request.setAttribute("categoryList",categoryList);
        List<Color> colorList = this.colorBo.findAllColor();

        request.setAttribute("colorList", colorList);

        request.setAttribute("productList",productList);
        try {
            request.getRequestDispatcher("productDisplay.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
