<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-3">
    <h1>Member List</h1>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Email</th>
                <th>NickName</th>
                <th>Reg Date</th>
                <th>Last Login</th>
                <th>Grade</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list }" var="mvo">
            <tr>
                <td>${mvo.email }</td>
                <td><a href="/member/detail?email=${mvo.email }">${mvo.nickName }</a></td>
                <td>${mvo.regAt }</td>
                <td>${mvo.lastLogin }</td>
                <td>${mvo.grade }</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="../common/footer.jsp"/>