package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "available_rooms")
public class AvailableRooms extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");

        request.setAttribute("checkInDate", checkInDate);
        request.setAttribute("checkOutDate", checkOutDate);
        request.setAttribute("roomId", request.getParameter("roomId"));
        request.setAttribute("price", request.getParameter("price"));
        
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/views/reservation.jsp");
        reqDispatcher.forward(request, response);
    }
}
