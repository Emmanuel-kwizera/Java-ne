<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../styles/navbar.css">
    <title>Navbar</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;1,100&display=swap');
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        .navbar-container{
            display: flex;
            flex-direction: row;
            height: 3rem;
            width: 100%;
            background: #009688;
            justify-content: space-between;
            padding: 10px;
        }
        .navbar-container h2{
            font-size: 16px;
            color: white;
        }
        .logout-heading{
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="navbar-container">
    <h2>EMS</h2>
    <h2 onclick="window.location.href='/logout'" class="logout-heading">LOGOUT</h2>
</div>
</body>
</html>