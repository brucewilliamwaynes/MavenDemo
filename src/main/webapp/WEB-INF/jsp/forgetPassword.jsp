<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password</title>
</head>
<body>
	<form:form id="forgetPasswordForm" modelAttribute="emailID" action="forgetPassword" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="emailID">EmailID: </form:label>
                        </td>
                        <td>
                            <form:input path="emailID" name="emailID" id="emailID" />
                        </td>
                        <td>
                        	<form:errors path="emailID"></form:errors>
                        </td>
                       <td align="left">
                            <form:button id="resetPassword" name="resetPassword">Reset Password</form:button>
                        </td>
                    </tr>
                </table>
            </form:form>
            
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
</body>
</html>