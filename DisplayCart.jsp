<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
    table, tr,th,td
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
<table>
<tr>
<th>S.No</th>
<th>Cid</th>
<th>Pid</th>
<th>Grandtotal</th>
<th>Payamount</th>
<th>Pquantity</th>
<th>getTotdiscount</th>

</tr>
	<c:forEach var="p" items="${list}">
		
			<tr>
			</tr>
			<tr>
				<td> 
					<h5>
						<c:out value="${p.getSno() }"></c:out>
					</h5>
					 
				</td>
				
					<td> 
					<h5>
						<c:out value="${p.getCid() }"></c:out>
					</h5>
					 
				</td>
				
					<td> 
					<h5>
						<c:out value="${p.getPid() }"></c:out>
					</h5>
					 
				</td>
				
					<td> 
					<h5>
						<c:out value="${p.getGrandtotal() }"></c:out>
					</h5>
					 
				</td>
				<td> 
					<h5>
						<c:out value="${p.getPayamount() }"></c:out>
					</h5>
					 
				</td>
				<td> 
					<h5>
						<c:out value="${p.getPquantity() }"></c:out>
					</h5>
					 
				</td>
					<td> 
					<h5>
						<c:out value="${p.getTotdiscount() }"></c:out>
					</h5>
					 
				
			
			</tr>
		
		
		
	</c:forEach>
</table>


<form action="paybill">
<input type="submit" name="btn" value="pay bill">
</form>
</body>


</html>