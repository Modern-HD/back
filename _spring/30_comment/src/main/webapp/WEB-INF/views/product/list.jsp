<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-3">
    <h2>Product List</h2>
    <c:if test="${ses ne null }">
    <a href="/product/register" class="btn btn-primary">Register</a>
    </c:if>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Writer</th>
                <th>Made By</th>
                <th>Reg Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list }" var="pvo">
            <tr>
                <td><a href="/product/detail?pno=${pvo.pno }"><c:out value="${pvo.pname }"/></a></td>
                <td><c:out value="${pvo.price }"/></td>
                <td><c:out value="${pvo.writer }"/></td>
                <td><c:out value="${pvo.madeBy }"/></td>
                <td><c:out value="${pvo.regAt }"/></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="../common/footer.jsp" />