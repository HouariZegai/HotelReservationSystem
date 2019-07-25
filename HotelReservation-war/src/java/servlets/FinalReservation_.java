package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import models.Reservation;
import sessionbeans.ReservationFacadeLocal;

@WebServlet(name = "reservation")
public class FinalReservation_ extends HttpServlet {

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
        
        Reservation reservation = new Reservation();
        reservation.setIdRoom(idRoom);
        reservation.setFullName(fullName);
        reservation.setEmail(email);
        reservation.setPhone(phone);
        reservation.setSpecialRequest(specialRequest);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            reservation.setCheckOutDate(sdf.parse(checkOutDate));
            reservation.setCheckInDate(sdf.parse(checkInDate));
        } catch(Exception e) {
            e.printStackTrace();
        }
                
        reservationFacade.create(reservation);
        
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/views/home.jsp");
        reqDispatcher.forward(request, response);
    }
}
