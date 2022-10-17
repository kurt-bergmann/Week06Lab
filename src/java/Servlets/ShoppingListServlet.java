/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Kurt
 */
public class ShoppingListServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("counter", 0);
        ArrayList<String> empty = new ArrayList();
        session.setAttribute("array", empty);
        session.setAttribute("logout", request.getParameter("logout"));
        String logout = (String)session.getAttribute("logout");
        

        
        if(logout != null){
            request.setAttribute("message", "Logged Out");
        }
        
          if(session.getAttribute("username") == null || ((String)session.getAttribute("username")).equals("")){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
           
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String logout = (String)session.getAttribute("logout");
        String item = request.getParameter("item");
        String selected = request.getParameter("list");

        ArrayList<String> array = new ArrayList();
        if(session.getAttribute("array")!=null){
            array = (ArrayList<String>)session.getAttribute("array");
        }
        
        if(action.equals("add")){
        if(session.getAttribute("counter") == null){
            session.setAttribute("counter",1);
        }
        
        
        
           if(logout != null){
           request.setAttribute("counter", "logged out");
           session.setAttribute("counter",0);
        }
        
           
        int counter = (int)session.getAttribute("counter");
        
        
        

        
        

       array.add((String)item);
       
        }
        
        if(action.equals("delete")){
            
            
            array.remove(selected);
            
        }
       
        
        
        session.setAttribute("array", array);
        request.setAttribute("cart", array);    
        
         getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        
    }

}
