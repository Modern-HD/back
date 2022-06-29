<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>
<div class="container mt-3">
    <h2>Product List</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Pname</th>
                <th>Regdate</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="pvo" items="${list }">
            <tr>
                <td><a href="./detail.pd?pno=${pvo.pno  }">${pvo.pname }</a></td>
                <td>${pvo.regdate }</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
