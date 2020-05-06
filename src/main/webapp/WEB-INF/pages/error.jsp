<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>ERROR</title>
</head>
<body>
<h1>Error Page</h1>


<!-- You could use ${requestScope['javax.servlet.forward.request_uri']}
	     but it's a lot more verbose and doesn't give you the full page URL. -->
<jsp:useBean id="customException" scope="request" type="by.dobysh.countlinks.exception.CustomException"/>
<c:if test="${not empty customException.url}">

    <p>
        <b>Page:</b> ${customException.url}
    </p>
</c:if>

<c:if test="${not empty customException.timestamp}">
    <p id='created'>
        <b>Occurred:</b> ${customException.timestamp}
    </p>
</c:if>

<c:if test="${not empty customException.status}">
    <p>
        <b>Response Status:</b> ${customException.status}
<%--        <c:if test="${error}">(${error})</c:if>--%>
    </p>
</c:if>



<p>Информация по указанной ссылке недоступна. Проверьте вводимые данные</p>


<!--
    Failed URL: ${customException.url}
    Exception:  ${customException.exception.message}
        <c:forEach items="${customException.exception.stackTrace}" var="ste">    ${ste}
    </c:forEach>
    -->

<a href="${customException.url}">${customException.url}</a>

</body>
</html>