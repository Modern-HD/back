<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>
    <div class="container">
        <div class="bg-light text-center p-5 rounded-3 shadow m-5">
            <form action="./insert.em" method="post">
                <table class="mx-auto">
                    <tr>
                        <td><label for="empno">EMPNO: </label></td>
                        <td><input type="text" name="empno" id="empno"></td>
                    </tr>
                    <tr>
                        <td><label for="password">PWD: </label></td>
                        <td><input type="password" name="pwd" id="pwd"></td>
                    </tr>
                    <tr>
                        <td><label for="ename">ENAME: </label></td>
                        <td><input type="text" name="ename" id="ename"></td>
                    </tr>
                </table>
                <button type="submit" class="btn btn-primary mt-3">Submit</button>
            </form>
        </div>
    </div>
<jsp:include page="../footer.jsp"></jsp:include>
