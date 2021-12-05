<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <title>StudLab Practical Task #1</title>
    <link href="${root}/views/styles.css" rel="stylesheet" type="text/css">
  </head>
  <body>
    <main>
      <h1>Список чисел из файла</h1>
      <table class="numberTable" border="3">
        <thead>
        <tr>
          <th>Число</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.numbers}" var="number">
          <tr>
            <td><c:out value="${number}"/></td>
          </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
          <td>Всего чисел: <c:out value="${fn:length(requestScope.numbers)}"/></td>
        </tr>
        </tfoot>
      </table>
      <br>
      <br>
      <form method="post" action="${root}/numbers">
        <input type="submit" class="sort-btn" value="OrderList">
      </form>
      <br>
      <p>
        <a class="get-request-link" href="${root}/numbers">Get request</a>
      </p>
    </main>
  </body>
</html>
