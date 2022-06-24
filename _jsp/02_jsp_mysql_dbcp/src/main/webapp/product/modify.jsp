<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"></jsp:include>
<jsp:include page="../nav.jsp"></jsp:include>
   <div class="container">
       <div class="bg-light text-center p-5 rounded-3 shadow m-5">
           <form action="./update.pd" method="post">
               <table class="mx-auto">
                   <tr>
                       <td><label for="pno">Pno: </label></td>
                       <td><input type="text" name="pno" id="pno" value="${pvo.pno }" readonly></td>
                   </tr>
                   <tr>
                       <td><label for="pname">Pname: </label></td>
                       <td><input type="text" name="pname" id="pname" value="${pvo.pname }"></td>
                   </tr>
                   <tr>
                       <td><label for="price">Price: </label></td>
                       <td><input type="text" name="price" id="price" value="${pvo.price }"></td>
                   </tr>
                   <tr>
                       <td><label for="regdate">Regdate: </label></td>
                       <td><input type="text" name="regdate" id="regdate" value="${pvo.regdate }" disabled></td>
                   </tr>
                   <tr>
                       <td><label for="madeby">MadeBy: </label></td>
                       <td><input type="text" name="madeby" id="madeby" value="${pvo.madeby }"></td>
                   </tr>
               </table>
               <button type="submit" class="btn btn-outline-warning mt-3">Submit</button>
           </form>
       </div>
   </div>
<jsp:include page="../footer.jsp"></jsp:include>
