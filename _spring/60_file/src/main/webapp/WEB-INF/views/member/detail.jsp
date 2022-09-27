<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<h1>Member Detail</h1>
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
            <tr>
                <td id="emVal">${mvo.email }</td>
                <td>${mvo.nickName }</td>
                <td>${mvo.regAt }</td>
                <td>${mvo.lastLogin }</td>
                <td>${mvo.grade }</td>
            </tr>
        </tbody>
    </table>
    <a href="/member/list?pageNo=${pgvo.pageNo }&qty=${pgvo.qty }&type=${pgvo.type}&kw=${pgvo.kw}" class="btn btn-primary">list</a>
    <c:if test="${ses.email eq mvo.email || ses.grade eq 99 }">
    <a href="/member/modify?email=${mvo.email }&pageNo=${pgvo.pageNo }&qty=${pgvo.qty }&type=${pgvo.type}&kw=${pgvo.kw}" class="btn btn-outline-warning">update</a>
    <button type="button" data-em="${mvo.email }" id="memberRemove" class="btn btn-outline-danger">delete</button>
    <form action="" id="memberRmForm" class="d-none" method="post">
        <input type="hidden" value="${pgvo.pageNo }" name="pageNo">
        <input type="hidden" value="${pgvo.qty }" name="qty">
        <input type="hidden" value="${pgvo.type }" name="type">
        <input type="hidden" value="${pgvo.kw }" name="kw">
        <input type="hidden" id="em" value="" name="email">
    </form>
    </c:if>
</div>
<script src="/resources/js/member.detail.js"></script>
<jsp:include page="../common/footer.jsp"/>