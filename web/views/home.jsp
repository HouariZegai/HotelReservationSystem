<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel Reservation System</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/home.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">ABBA<span style="color: #28a745">SSID H</span>otel </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact US</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" onsubmit="return false;">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-check btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

    <div class="bg-img">
    	<div class="header-container">
    		<h1>Welcome!</h1>
    		<p>You can reserve rooms online via this website.</p>
    	</div>

    	<form class="form-inline check-date-form-container" method="GET" action="Home">
		  <div class="form-group mx-sm-3 mb-2">
		  	<label class="check-lbl">Check-in date</label>
		    <input type="date" name="checkInDate" class="form-control" placeholder="Check-in date">
		  </div>

		  <div class="form-group mx-sm-3 mb-2">
		  	<label class="check-lbl">Check-out date</label>
		    <input type="date" class="form-control" name="checkOutDate" placeholder="Check-out date">
		  </div>
		  <button type="submit" class="btn btn-success mb-2">Check Rooms</button>
		</form>
	</div>
</body>
</html>
