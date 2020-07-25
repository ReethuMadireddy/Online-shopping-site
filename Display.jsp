<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
    table, tr, td
                    {
                         border: 1px solid black;
                         width : 40%;
                        text-align: center;
                    }
​    
    </style>   

<meta charset="ISO-8859-1">
<title> My Cart </title>
</head>
<body>

<c:forEach var="c" items="${list1}">
                        <table>
                            <tr>
                                <td>
                                    <h5><c:out value="${c.getName()}"></c:out></h5>
                                </td>
                                <td>
                                    <h5><c:out value="${c.getCost()}"></c:out></h5>
                                </td>
                                 <td>
                                    <h5><c:out value="${c.getQuantity()}"></c:out></h5>
                                </td>   
                                   
                            </tr>
                        </table>
                    </c:forEach>       

</body>
</html>