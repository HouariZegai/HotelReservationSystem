package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import sessionbeans.ReservationFacadeLocal;

@WebServlet(name = "reservation")
public class FinalReservation extends HttpServlet {

    @EJB
    private ReservationFacadeLocal reservationFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idRoom = Integer.parseInt(request.getParameter("roomId"));
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String specialRequest = request.getParameter("specialRequest");
        
        try {
            String sql = "INSERT INTO reservation VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_system?useSSL=false&serverTimezone=UTC", "root", "root");
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, idRoom);
            prest.setString(2, checkInDate);
            prest.setString(3, checkOutDate);
            prest.setString(4, fullName);
            prest.setString(5, email);
            prest.setString(6, phone);
            prest.setString(7, specialRequest);
            prest.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/views/home.jsp");
        reqDispatcher.forward(request, response);
    }
}
