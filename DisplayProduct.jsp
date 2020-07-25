<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
    table, tr,th, td
                    {
                         border: 1px solid black;
                         width : 40%;
                        text-align: center;
                    }
​    
    </style>   

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="p" items="${list}">
                        <table>
                        
                            <tr>
                                <td>
                                    <h5><c:out value="${p.getPid()}"></c:out></h5>
                                </td>
                                <td>
                                    <h5><c:out value="${p.getPname()}"></c:out></h5>
                                </td>
                                 <td>
                                    <h5><c:out value="${p.getPcost()}"></c:out></h5>
                                </td> 
                                 <td>
                                    <h5><c:out value="${p.getPquantity()}"></c:out></h5>
                                </td>   
                                   
                            </tr>
                        </table>
                    </c:forEach>       

</body>
</html>