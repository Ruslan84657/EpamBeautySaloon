<html>
<head>
    <title>Welcome title</title>

</head>
<body>
    <div align="center">
        <h1>Welcome to beauty saloon!</h1><br />
        <ul class="navbar-nav">
            <li>
                <a href="<%= request.getContextPath()%>>/select_master"
                   class="nav-link">Masters</a>
            </li>
            <li>
                <a href="<%= request.getContextPath()%>>/select_service"
                   class="nav-link">Services</a>
            </li>
        </ul>
    <h1>User register form</h1>

    <form action="<%= request.getContextPath()%>/insert" method="post">
        <table style="width: 80%">
            <tr>
                <td>First Name</td>
                <td><input type="text" name="first_name"></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="last_name"></td>
            </tr>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password"></td>
            </tr>
        </table>
<%--        <a href="user-form.jsp" >--%>
       <input type="submit" value="Submit"/>
<%--        </a>--%>
    </form>
    </div>
</body>
</html>