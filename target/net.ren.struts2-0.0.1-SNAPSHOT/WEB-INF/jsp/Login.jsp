<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>Struts 2 - Login Application</title>
</head>

<body>
<h2>Struts 2 - Login Application</h2>
<s:actionerror />
<s:property value="signUpMessage"/>
<s:form action="logIn">
	<s:textfield name="username" key="label.username" size="20" />
	<s:password name="password" key="label.password" size="20" />
	
	<s:if test="!isLogIn()">
		<s:submit key="label.signup" align="center"  action="signUp"/>
	</s:if>
    <s:else>
        <s:submit key="label.login" align="center" />
    </s:else>
</s:form>
<s:if test="!isSignUp()">
<s:url var="signUpUrl" action="showSignUp"/>
Does not have account yet? <s:a href="%{signUpUrl}">Click Sign Up</s:a>
</s:if>
</body>
</html>