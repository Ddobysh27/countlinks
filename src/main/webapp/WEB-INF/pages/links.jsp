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

<c:if test="${not empty incorrectInputInfo}">
    <p style="color: red">
        <b>Error:</b> ${incorrectInputInfo}
    </p>
</c:if>


<form:form method="post" action="/" modelAttribute="link">
    <table>
        <tr>
            <td>
                <table>
                    <th>Анализируемая страница</th>
                    <tr>
                        <td><form:input path="address" id="input" type="text" style="border: 0;"/></td>
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

<div class="wrapper-box" id="wrapper-box">
    <div class="waiting-box">
        <img src="/resources/images/wait.gif">
        <span>Идет обработка...</span>
    </div>
</div>

<script>
    "use strict";

    var input = document.getElementById('input');
    var as = document.getElementsByClassName('action-a');
    // добавляем всем ссылкам из 3 столбца возможность подставновки в поле ввода
    for (var i = 0; i < as.length; i++) {
        if (as[i].addEventListener) {
            //изменение действия ссылки
            as[i].addEventListener('click', function (event) {
                //отмена перехода по ссылке
                event.preventDefault();
                if (event.target && event.target.innerHTML) {
                    // добваления ссылки в поле ввода
                    input.value = event.target.innerHTML;
                }
            })
        }
    }

    //показывает WaitingBox, после нажатия кнопки "Анализировать"
    var analyze = document.getElementById('analyze')
    analyze.addEventListener('click', function (e) {
        var wb = document.getElementById('wrapper-box');
        wb.style.display = "flex";
    });

    // скрывает WaitingBox, после того как браузер полностью загрузил HTML
    document.addEventListener("DOMContentLoaded", function () {
        var wb = document.getElementById('wrapper-box');
        wb.style.display = "none";
    });
</script>
</body>
</html>