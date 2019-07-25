package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import models.Room;
import models.Reservation;
import sessionbeans.ReservationFacadeLocal;
import sessionbeans.RoomFacadeLocal;

@WebServlet(name = "home")
public class Home extends HttpServlet {

    @EJB
    private ReservationFacadeLocal reservationFacade;

    @EJB
    private RoomFacadeLocal roomFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");

        request.setAttribute("checkInDate", checkInDate);
        request.setAttribute("checkOutDate", checkOutDate);

        List<Room> availableRooms = roomFacade.findAll();
        List<Reservation> reservation = reservationFacade.findAll();

        for (int i = 0; i < reservation.size(); i++) {
            if (
                    (isDateAfterThan(checkInDate, reservation.get(i).getCheckInDate().toString()) && 
                    isDateAfterThan(reservation.get(i).getCheckOutDate().toString(), checkOutDate))
                    ||
                    (isDateAfterThan(reservation.get(i).getCheckInDate().toString(), checkInDate) && 
                    isDateAfterThan(checkOutDate, reservation.get(i).getCheckOutDate().toString()))
                    ||
                    (isDateAfterThan(checkInDate, reservation.get(i).getCheckInDate().toString()) && 
                    isDateAfterThan(checkOutDate, reservation.get(i).getCheckOutDate().toString()))
                    ||
                    (isDateAfterThan(reservation.get(i).getCheckInDate().toString(), checkInDate) && 
                    isDateAfterThan(reservation.get(i).getCheckOutDate().toString(), checkOutDate))
                ) {
                for(int j = 0; j < availableRooms.size(); j++) {
                    if(reservation.get(i).getIdRoom() == availableRooms.get(j).getId()) {
                        availableRooms.remove(j);
                        break;
                    }
                }
            }
        }

        request.setAttribute("availableRooms", availableRooms);

        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/views/available_rooms.jsp");
        reqDispatcher.forward(request, response);
    }

    private boolean isDateAfterThan(String firstDate, String secondDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = sdf.parse(firstDate);
            Date date2 = sdf.parse(secondDate);
            return date1.compareTo(date2) > 0;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
