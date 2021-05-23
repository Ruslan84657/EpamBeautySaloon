<html>
<head>
    <title>User welcome title</title>

</head>
<body>
<div align="center">
    <h1> Dear client, welcome to beauty saloon!</h1><br />
    <ul class="navbar-nav">
        <li>
            <a href="<%= request.getContextPath()%>>/select_master"
               class="nav-link">Masters</a>
        </li>
        <li>
            <a href="<%= request.getContextPath()%>>/select_service"
               class="nav-link">Services</a>
        </li>
        <li>
            <a href="<%= request.getContextPath()%>>/service_registration"
               class="nav-link">Registration for service</a>
        </li>
    </ul>
</div>
</body>
</html>