package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "home")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("checkInDate", request.getParameter("checkInDate"));
        request.setAttribute("checkOutDate", request.getParameter("checkOutDate"));

        //Servlet JSP communication
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/views/available_rooms.jsp");
        reqDispatcher.forward(request,response);
    }
}
