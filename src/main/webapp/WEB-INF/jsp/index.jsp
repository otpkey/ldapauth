<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signed in JSP</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
    <script>
        function logout() {
            location.href = "logout";
        }
    </script>
</head>
<body>
    <div class="container" style="max-width:1024px">
        <h2>Welcome to the Spring Security with the LDAP Authentication</h2>
        <br>
        <h3>This is a sample for testing the OTPKEY authentication framework solution.</h3>
        <br>
        <h4>This is a JSP page.</h3>
        <br>
        <h4><a href="/">HTML Page 👈</a></h3>
        <br>
        <button class="btn btn-lg btn-primary btn-block" onclick="logout()">Logout</button>
    </div>
</body>
</html>