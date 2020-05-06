<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>LINKS</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/res/styles.css" rel="stylesheet" type="text/css">

</head>
<body>

<div id="divMessage" style="display: none;">
    Please wait ....
</div>

<form:form method="post" action="/" modelAttribute="link">
    <table>

        <tr>
            <td>
                <table>
                    <th>Анализируемая страница</th>
                    <tr>
                        <td><form:input path="address" id="input" type="url" style="border: 0;"/></td>
                    </tr>

                </table>


                <input type="submit" id="analyze" name="analyze" value="Анализировать">


                <table id="foundLinksTable">
                    <th colspan="3">Обнаруженные ссылки</th>
                    <tr>
                        <th>№ п/п</th>
                        <th>Имя ссылки</th>
                        <th>Адресс ссылки</th>
                    </tr>
                    <c:forEach var="link" items="${foundLinksList}">

                        <tr class="link">
                            <td>${link.id}</td>
                            <td>${link.name}</td>
                            <td><a class="action-a" href="">${link.address}</a></td>
                        </tr>

                    </c:forEach>
                </table>

                <input type="submit" name="clean" value="Очистить">

            </td>

        </tr>
    </table>


</form:form>

<%--<button onclick="myFunction()">Очистить</button>--%>

<div class="wrapper-box" id="wrapper-box">
    <div class="waiting-box">
        <img src="/resources/images/wait.gif">
        <span>Идет обработка...</span>
    </div>
</div>

<script>
    "use strict";

    const input = document.getElementById('input');
    const as = document.getElementsByClassName('action-a');

    for (const a of as) {
        if (a.addEventListener) {
            a.addEventListener('click', function (event) {
                event.preventDefault();
                if (event.target && event.target.innerHTML) {
                    input.value = event.target.innerHTML;
                }
            })
        }
    }

    const analyze = document.getElementById('analyze')
    analyze.addEventListener('click', (e) => {
        const wb = document.getElementById('wrapper-box');
        wb.style.display = "flex";
    });

    function myFunction(event) {
        event.preventDefault();
        const links = document.getElementsByClassName("link"); // ноды по имени класса для

        while (links[0]) {
            links[0].remove();
        }
    }

    document.addEventListener("DOMContentLoaded", () => {
        console.log("DOM готов!");
        const wb = document.getElementById('wrapper-box');
        wb.style.display = "none";
    });

</script>
</body>
</html>