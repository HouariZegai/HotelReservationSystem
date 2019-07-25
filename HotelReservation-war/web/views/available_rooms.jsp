<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="models.Room"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Hotel Reservation System</title>
        <link rel="stylesheet" href="css/bootstrapmin.css">
        <link rel="stylesheet" href="css/available-rooms.css">
        <script src="js/bootstrapmin.js"></script>
    </head>
    <body>
        <%
            String checkInDate = request.getAttribute("checkInDate").toString();
            String checkOutDate = request.getAttribute("checkOutDate").toString();
            List<Room> availableRooms = (List<Room>) request.getAttribute("availableRooms");
        %>

        <div class="header">
            <h1>Available Rooms</h1>
            <p>from <span>${checkInDate}</span> to <span>${checkOutDate}</span></p>
        </div>

        <div class="container" style="margin-bottom: 50px">
            <%
                if(availableRooms.size() < 1) {
                    out.println("<div class='card w-100' style='margin-bottom: 20px'>The is no available Room!</div>");
                }
            %>
            
            <a href="<%= request.getContextPath()%>"><button class="btn btn-secondary" style="display: block; float: right; margin-bottom: 15px">Back to Home</button></a>

            <c:forEach items="${availableRooms}" var="room">
                <div class="card w-100" style="margin-bottom: 20px">
                    <div class="card-header">Room #${room.id}</div>
                    <div class="card-body">
                        <h5 class="card-title">Room for ${room.numberOfPerson} adult</h5>
                        <p class="card-text">${room.description}</p>
                        <p class="card-text">Price: ${room.price} DZD</p>
                        <form action="AvailableRooms" method="GET">
                            <input type="hidden" name="roomId" value="${room.id}" />
                            <input type="hidden" name="price" value="${room.price}" />
                            <input type="hidden" name="checkInDate" value="${checkInDate}" />
                            <input type="hidden" name="checkOutDate" value="${checkOutDate}" />
                            <input type="submit" class="btn btn-success" value="I'll Reserve">
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
