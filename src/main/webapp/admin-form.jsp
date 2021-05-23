<head>
    <title>Admin welcome title</title>

</head>
<body>
<div align="center">
    <h1> Hello ADMIN!</h1><br />
    <ul class="navbar-nav">
        <li>
            <a href="<%= request.getContextPath()%>>/select_registration"
               class="nav-link">Select client registration</a>
        </li>
        <li>
            <a href="<%= request.getContextPath()%>>/cancel_registration"
               class="nav-link">Cancel client registration</a>
        </li>
        <li>
            <a href="<%= request.getContextPath()%>>/delete"
               class="nav-link">Delete user</a>
        </li>
    </ul>
</div>
</body>
</html>