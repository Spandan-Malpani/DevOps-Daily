<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h1>Enter User Details</h1>
    <form action="${pageContext.request.contextPath}/submit"  method="post">
        Name: <input type="text" name="name" required /><br/>
        Gender:
        <select name="gender">
            <option>Male</option>
            <option>Female</option>
            <option>Other</option>
        </select><br/><br/>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>