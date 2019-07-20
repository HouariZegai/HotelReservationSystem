<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel Reservation System</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/available-rooms.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <%
        String checkInDate = request.getAttribute("checkInDate").toString();
        String checkOutDate = request.getAttribute("checkOutDate").toString();
    %>

    <div class="header">
        <h1>Available Rooms</h1>
        <p>from <span>${checkInDate}</span> to <span>${checkOutDate}</span></p>
    </div>

    <div class="container" style="margin-bottom: 50px">

        <button class="btn btn-secondary" style="display: block; float: right; margin-bottom: 15px">Back to Home</button>

        <div class="card w-100" style="margin-bottom: 20px">
            <div class="card-header">Room #1</div>
            <div class="card-body">
                <h5 class="card-title">Room for 1 adult</h5>
                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                <p class="card-text">Price: 2000 DZD</p>
                <a href="#" class="btn btn-success">I'll Reserve</a>
            </div>
        </div>
    </div>
</body>
</html>
