<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="org.apache.commons.codec.binary.Base64" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

HTTP HEADER ATTRIBUTES:
<br>
<br>
	<%
	response.setContentType("text/html");
	
	out.println("This is the Test Servlet");

	Enumeration headerNames = request.getHeaderNames();
	while (headerNames.hasMoreElements()) {
		String headerName = (String) headerNames.nextElement();
		out.print("<br/>Header Name: <em>" + headerName);
		String headerValue = request.getHeader(headerName);
		out.print("</em>, Header Value: <em>" + headerValue);
		out.println("</em>");
	}

	out.println("<hr/>");
	String authHeader = request.getHeader("authorization");
	if (authHeader != null){
		String encodedValue = authHeader.split(" ")[1];
		out.println("Base64-encoded Authorization Value: <em>" + encodedValue);
		byte[] decodeBytes = Base64.decodeBase64(encodedValue.getBytes());
		String decodedValue = new String(decodeBytes, "UTF8");
		out.println("</em><br/>Base64-decoded Authorization Value: <em>" + decodedValue);
	 out.println("</em>");
	}
	%>
</body>
</html>