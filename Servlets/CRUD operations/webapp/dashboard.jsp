<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.*" %>
<%@ page import= "com.mumbai.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dashboard</title>
<link rel="stylesheet" href="styles.css" "text/css">
</head>
<body>
    <div class="nav">
        <h3>Mumbai</h3>
        <p>a webpage sandbox to test servlets</p>
    </div>
    <div class="option">
        <h5>WELCOME TO DASHBOARD!</h5>
        <form action="dashboard" method="GET">
            <table>
                <tr>
                    <td> id:</td>
                    <td> <input type="number" name="id"></td>
                </tr>
                <tr>
                    <td> password:</td>
                    <td> <input type="text" name="password"></td>
                </tr>
                <tr>
                    <td> option:</td>
                    <td> <input type="radio" name="option" value="update" >Update
                        <input type="radio" name="option" value="delete">Delete</td>
                </tr>
                <tr>
                    <td><input type="submit"></td>
                    <td><input type="reset"></td>
                </tr>
            </table>
        </form>
    </div>

    <div class="data">
        <table>
            <tr>
                <th>id</th>
                <th>username</th>
                <th>password</th>
            </tr>
            <% 
            	ArrayList<User> usersal = (ArrayList<User>)request.getAttribute("users");
            	for(User a:usersal){
            %>
            <tr><%=a.getId() %></tr>
            <tr><%=a.getUsername() %></tr>
            <tr><%=a.getPassword() %></tr>
            <%}; %>
        </table>
    </div>

</body>
</html>