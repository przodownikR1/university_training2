<%@ include file="/WEB-INF/templates/includes.jsp"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='${pageContext.request.contextPath}/favicon.ico' rel='icon' type='image/x-icon'/>
 

<title>Hi </title>
</head>
<body>

<spring:message code="hello.message" var="hello1" />

Message : <spring:message  code="hello.message" text="hey"/>
<br />
<c:out value="${hello1}"/>
<br />
<c:out value="${time}"/>
<br />
<c:out value="${message}"/>
<br />

<br />
</body>
</html>