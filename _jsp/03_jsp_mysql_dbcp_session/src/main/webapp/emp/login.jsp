<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>
<div class="container mt-3">
    <h2>Login form</h2>
    <form action="./login_auth.em" method="post">
        <div class="mb-3 mt-3">
            <label for="email">Empno:</label>
            <input type="empno" class="form-control" id="empno" placeholder="Enter empno" name="empno">
        </div>
        <div class="mb-3">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
