<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/nav.jsp"/>

<div class="container mt-3">
    <h2>Product Detail</h2>
    <table class="table table-hover">
        <tr>
            <td class="col-3">Product Number</td>
            <td id="pno"><c:out value="${pvo.pno}"/></td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><c:out value="${pvo.pname}"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><c:out value="${pvo.price}"/></td>
        </tr>
        <tr>
            <td>Writer</td>
            <td><c:out value="${pvo.writer}"/></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><c:out value="${pvo.description}"/></td>
        </tr>
        <tr>
            <td>Made By</td>
            <td><c:out value="${pvo.madeBy }"/></td>
        </tr>
        <tr>
            <td>Reg Date</td>
            <td><c:out value="${pvo.regAt }"/></td>
        </tr>
        <tr>
            <td>Mod Date</td>
            <td><c:out value="${pvo.modAt }"/></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><c:out value="${pvo.category }"/></td>
        </tr>
        <tr>
            <td>Read Count</td>
            <td><c:out value="${pvo.readCount }"/></td>
        </tr>
        <tr>
            <td>Cmt Qty</td>
            <td><c:out value="${pvo.cmtQty }"/></td>
        </tr>
    </table>
    <c:if test="${ses.email eq pvo.writer || ses.grade eq 99 }">
    <a href="/product/modify?pno=${pvo.pno }" class="btn btn-outline-warning">Modify</a>
    <button type="button" id="product_del_btn" class="btn btn-outline-danger">Delete</button>
    <form action="" method="post" id="del_form">
        <input type="hidden" id="input_pno" name="pno">
    </form>
    </c:if>
</div>
<script src="/resources/js/product.detail.js"></script>
<jsp:include page="../common/footer.jsp"/>