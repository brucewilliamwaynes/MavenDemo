<!--  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Password</title>
</head>
<body>

	<table align="center">
                <tr>
                    <td style="font-style: italic; color: black;">${message}</td>
                </tr>
            </table>
            
	<form id="createPasswordForm"  action="savePassword" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <label >New Password : </label>
                        </td>
                        <td>
                            <input  name="password" id="password" type="password" />
                        </td>
                        <td>
                        </td>
                       <td align="left">
                            <button id="resetPassword" name="resetPassword" type="submit" >Submit Password</button>
                        </td>
                    </tr>
                </table>
            </form>
            
</body>
</html>