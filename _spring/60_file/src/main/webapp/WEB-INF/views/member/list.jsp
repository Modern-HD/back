<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-3">
    <h1>Member List</h1>
        <form class="d-flex col-6">
            <input type="hidden" name="pageNo" value="1">
            <input type="hidden" name="qty" value="${pgn.pgvo.qty }">
            <div class="input-group">
                <select class="form-select" name="type">
                    <option ${pgn.pgvo.type eq null ? 'selected' : '' }>선택</option>
                    <option value="e" ${pgn.pgvo.type eq 'e' ? 'selected' : ''}>이메일</option>
                    <option value="n" ${pgn.pgvo.type eq 'n' ? 'selected' : ''}>닉네임</option>
                    <option value="g" ${pgn.pgvo.type eq 'g' ? 'selected' : ''}>등급</option>
                    <option value="en" ${pgn.pgvo.type eq 'en' ? 'selected' : ''}>이메일 혹은 닉네임</option>
                </select>
                <input class="form-control me-2" type="search"
                            placeholder="Search" aria-label="Search" name="kw" value="${pgn.pgvo.kw }">
                <button class="btn btn-outline-success" type="submit">Search <span class="badge bg-danger">${pgn.totalCount }</span></button>
            </div>
        </form>
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
                    <td><a
                        href="/member/detail?email=${mvo.email }&pageNo=${pgn.pgvo.pageNo }&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw}">${mvo.nickName }</a></td>
                    <td>${mvo.regAt }</td>
                    <td>${mvo.lastLogin }</td>
                    <td>${mvo.grade }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <ul class="pagination justify-content-center">
        <c:if test="${pgn.prev }">
        <li class="page-item"><a class="page-link" href="/member/list?pageNo=${pgn.startPage - 1 }&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw}">Prev</a></li>
        </c:if>
        <c:forEach begin="${pgn.startPage }" end="${pgn.endPage }" var="i">
        <li class="page-item ${pgn.pgvo.pageNo == i ? 'active' : '' }"><a class="page-link" href="/member/list?pageNo=${i }&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw}">${i }</a></li>
        </c:forEach>
        <c:if test="${pgn.next }">
        <li class="page-item"><a class="page-link" href="/member/list?pageNo=${pgn.endPage + 1 }&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw}">Next</a></li>
        </c:if>
    </ul>
</div>

<jsp:include page="../common/footer.jsp" />