<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="common/header.jsp" />
<jsp:include page="common/nav.jsp" />


<h3><a href="/member/register">Member Register</a></h3>

<div class="container mt-3">
    <h2>스프링 프레임워크</h2>
    <div class="mt-4 p-5 bg-info text-white rounded">
        <h1>Spring Framework Example</h1>
        <p>The time on the server is ${serverTime}.</p>
    </div>
</div>
<script>
    let isLogin = '<c:out value="${isLogin}"/>';
    let isLogout = '<c:out value="${isLogout}"/>';
    
    if (parseInt(isLogin)) {
    	alert("로그인 성공");
    }
    
    if (parseInt(isLogout)) {
    	alert("로그아웃 되었습니다");
    }
</script>
<jsp:include page="common/footer.jsp" />