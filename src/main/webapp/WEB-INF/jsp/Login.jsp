<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>Struts 2 - Login Application</title>
</head>

<body>
<h2>Struts 2 - Login Application</h2>
<s:actionerror />
<s:form action="login">
	<s:textfield name="username" key="label.username" size="20" />
	<s:password name="password" key="label.password" size="20" />
	<s:if test="%{model.id !=0}">
		<s:submit method="SignUp" key="label.signup" align="center" />
	</s:if>
    <s:else>
        <s:submit key="label.login" align="center" />
    </s:else>
</s:form>
<s:if test="%{model.id != 0}">
<s:url var="signUpUrl" action="signup"/>
<s:a href="%{signUpUrl}">Sign Up</s:a>
</s:if>

</body>
</html>