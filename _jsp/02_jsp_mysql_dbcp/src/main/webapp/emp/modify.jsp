<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>
   <div class="container">
       <div class="bg-light text-center p-5 rounded-3 shadow m-5">
           <form action="./update.em" method="post">
               <table class="mx-auto">
                   <tr>
                       <td><label for="ename">Empno: </label></td>
                       <td><input type="text" name="empno" id="empno" value="${evo.empno }" readonly></td>
                   </tr>
                   <tr>
                       <td><label for="ename">Ename: </label></td>
                       <td><input type="text" name="ename" id="ename" value="${evo.ename }"></td>
                   </tr>
                   <tr>
                       <td><label for="ename">Job: </label></td>
                       <td><input type="text" name="job" id="job" value="${evo.job }"></td>
                   </tr>
                   <tr>
                       <td><label for="ename">MGR: </label></td>
                       <td><input type="text" name="mgr" id="mgr" value="${evo.mgr }"></td>
                   </tr>
                   <tr>
                       <td><label for="ename">Salary: </label></td>
                       <td><input type="number" name="sal" id="sal" value="${evo.sal }"></td>
                   </tr>
                   <tr>
                       <td><label for="ename">Comm: </label></td>
                       <td><input type="text" name="comm" id="comm" value="${evo.comm }"></td>
                   </tr>
                   <tr>
                       <td><label for="ename">Deptno: </label></td>
                       <td><input type="text" name="deptno" id="deptno" value="${evo.deptno }"></td>
                   </tr>
               </table>
               <button type="submit" class="btn btn-outline-warning mt-3">Submit</button>
           </form>
       </div>
   </div>
<jsp:include page="../footer.jsp"></jsp:include>
