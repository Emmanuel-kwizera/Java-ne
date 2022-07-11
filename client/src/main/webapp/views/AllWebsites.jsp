<%--
  Created by IntelliJ IDEA.
  User: rca
  Date: 7/11/22
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Websites</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;1,100&display=swap');
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }
        .container {
            max-width: 1000px;
            margin-left: auto;
            margin-right: auto;
            padding-left: 10px;
            padding-right: 10px;
        }
        h2 {
            font-size: 26px;
            margin: 20px 0;
            text-align: center;
        }
        a {
            text-decoration: none;
            font-family: Serif;
            background: #009688;
            padding: 5px;
            color: #ffffff;
        }

        .responsive-table {
            margin-top: 12px;
        }

        .responsive-table li {
            border-radius: 3px;
            padding: 25px 30px;
            display: flex;
            justify-content: space-between;
            margin-bottom: 25px;
        }
        .responsive-table .table-header {
            background-color: #ff6b22;
            font-size: 14px;
            text-transform: uppercase;
            letter-spacing: 0.03em;
        }
        .responsive-table .table-row {
            background-color: #fff;
            box-shadow: 0px 0px 9px 0px rgba(0, 0, 0, 0.1);
        }
        .responsive-table .col-1 {
            flex-basis: 10%;
        }
        .responsive-table .col-2 {
            flex-basis: 40%;
        }
        .responsive-table .col-3 {
            flex-basis: 25%;
        }
        .responsive-table .col-4 {
            flex-basis: 25%;
        }
        @media all and (max-width: 767px) {
            .responsive-table .table-header {
                display: none;
            }
            .responsive-table li {
                display: block;
            }
            .responsive-table .col {
                flex-basis: 100%;
            }
            .responsive-table .col {
                display: flex;
                padding: 10px 0;
            }
            .responsive-table .col:before {
                color: #6c7a89;
                padding-right: 10px;
                content: attr(data-label);
                flex-basis: 50%;
                text-align: right;
            }
        }
    </style>
</head>

<body>
<%--    <jsp:include page="components/Navbar.jsp"></jsp:include>--%>
    <div class="container">
        <h2>All Downloaded WebSites</h2>
        <a href="/">Download</a>
        <ul class="responsive-table">
            <li class="table-header">
                <div class="col col-1">Id</div>
                <div class="col col-2">Website Name</div>
                <div class="col col-2">Start Time</div>
                <div class="col col-2">End Time</div>
                <div class="col col-2">Elapsed Time</div>
                <div class="col col-1">Kilobytes</div>
            </li>
            <li class="table-row">
                <div class="col col-1">1</div>
                <div class="col col-2">Instagram.com</div>
                <div class="col col-2">Mon, 11 Jul 22</div>
                <div class="col col-2">Mon, 11 Jul 22</div>
                <div class="col col-2">2min 56sec</div>
                <div class="col col-1">100</div>
            </li>
            <li class="table-row">
                <div class="col col-1">2</div>
                <div class="col col-2">Facebook.com</div>
                <div class="col col-2">Mon, 11 Jul 22</div>
                <div class="col col-2">Mon, 11 Jul 22</div>
                <div class="col col-2">2min 56sec</div>
                <div class="col col-1">150</div>
            </li>
            <li class="table-row">
                <div class="col col-1">3</div>
                <div class="col col-2">Amazon.com</div>
                <div class="col col-2">Mon, 11 Jul 22</div>
                <div class="col col-2">Mon, 11 Jul 22</div>
                <div class="col col-2">2min 56sec</div>
                <div class="col col-1">230</div>
            </li>
            <li class="table-row">
                <div class="col col-1">4</div>
                <div class="col col-2">Netflix.com</div>
                <div class="col col-2">Mon, 11 Jul 22</div>
                <div class="col col-2">Mon, 11 Jul 22</div>
                <div class="col col-2">2min 56sec</div>
                <div class="col col-1">400</div>
            </li>
            <li class="table-row">
                <div class="col col-1">4</div>
                <div class="col col-2">https://www.minict.gov.rw/</div>
                <div class="col col-2">Mon, 11 Jul 22</div>
                <div class="col col-2">Mon, 11 Jul 22</div>
                <div class="col col-2">2min 56sec</div>
                <div class="col col-1">400</div>
            </li>
        </ul>
    </div>
</body>
</html>
