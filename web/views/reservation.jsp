<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel Reservation System</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/reservation.css">
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="header lead">
        <h1>Final Reservation</h1>
        <p>Please, fill the form for complete the reservation process.</p>
    </div>

    <div class="container">
        <div class="alert alert-info">
            <strong>Total price: </strong> 4200 DZD
        </div>
        <form>
            <div class="form-group">
                <label for="fullName">Full name</label>
                <input type="text" class="form-control" name="fullName" id="fullName" placeholder="Type full name">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="Type your email">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="phone">Phone</label>
                <input type="phone" class="form-control" name="phone" id="phone" placeholder="Type phone number">
            </div>
            <div class="form-group">
                <label for="specialRequest">Special Request</label>
                <textarea class="form-control" name="specialRequest" id="specialRequest" rows="3"></textarea>
            </div>
            <div>
                <button type="submit" class="btn btn-success">Submit</button>
                <a href="<%= request.getContextPath() %>"><button class="btn btn-secondary" style="display: block; float: right; margin-bottom: 15px">Back to Home</button></a>
            </div>
        </form>
    </div>
</body>
</html>
