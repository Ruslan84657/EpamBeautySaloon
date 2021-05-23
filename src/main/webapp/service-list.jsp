<html>
<head>
    <title>User welcome title</title>

</head>
<body>
<div align="center">
    <h1> Services!</h1><br />
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <!--   for (Todo todo: todos) {  -->
        <c:forEach var="service" items="${serviceList}">

            <tr>
                <td><c:out value="${service.id}" /></td>
                <td><c:out value="${service.name}" /></td>

                <td><a href="edit?id=<c:out value='${service.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="delete?id=<c:out value='${service.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
        <!-- } -->
        </tbody>

    </table>
</div>
</body>
</html>