<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: An
  Date: 10/2/2023
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table of words in Bootstrap</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
<div class="container text-center my-5">
    <table class="table table-bordered">
        <tbody>
        <tr>
            <th>Name</th>
            <td><%= request.getAttribute ("name") %></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><%= request.getAttribute ("email") %></td>
        </tr>
        <tr>
            <th>Birthday</th>
            <td><%= request.getAttribute ("birthday") %></td>
        </tr>
        <tr>
            <th>Birth Time</th>
            <td><%= request.getAttribute ("birthtime") %></td>
        </tr>
        <tr>
            <th>Sex</th>
            <td><%= request.getAttribute ("gender") %></td>
        </tr>
        <tr>
            <th>Nation</th>
            <td><%= request.getAttribute ("country") %></td>
        </tr>
        <tr>
            <th>TOEIC score</th>
            <td><%= request.getAttribute("toeicScore") %></td>
        </tr>
        <tr>
            <th>Favorite IDE</th>
            <td>
                <ul style="list-style:none;">
                    <% List<String> favoriteIdeList = (List<String>) request.getAttribute("favoriteIDE");
                        for (String ide : favoriteIdeList) { %>
                    <li><%= ide %></li>
                    <% } %>
                </ul>
            </td>
        </tr>
        <tr>
            <th>Introduce yourself</th>
            <td><%= request.getAttribute("message") %></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
