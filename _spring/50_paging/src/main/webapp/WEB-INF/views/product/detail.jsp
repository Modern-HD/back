<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-3">
    <h2>Product Detail</h2>
    <table class="table table-hover">
        <tr>
            <td class="col-3">Product Number</td>
            <td id="pno"><c:out value="${pvo.pno}" /></td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><c:out value="${pvo.pname}" /></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><c:out value="${pvo.price}" /></td>
        </tr>
        <tr>
            <td>Writer</td>
            <td><c:out value="${pvo.writer}" /></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><c:out value="${pvo.description}" /></td>
        </tr>
        <tr>
            <td>Made By</td>
            <td><c:out value="${pvo.madeBy }" /></td>
        </tr>
        <tr>
            <td>Reg Date</td>
            <td><c:out value="${pvo.regAt }" /></td>
        </tr>
        <tr>
            <td>Mod Date</td>
            <td><c:out value="${pvo.modAt }" /></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><c:out value="${pvo.category }" /></td>
        </tr>
        <tr>
            <td>Read Count</td>
            <td><c:out value="${pvo.readCount }" /></td>
        </tr>
        <tr>
            <td>Cmt Qty</td>
            <td><c:out value="${pvo.cmtQty }" /></td>
        </tr>
    </table>
        <a href="/product/list?pageNo=${pgvo.pageNo }&qty=${pgvo.qty }" class="btn btn-primary">list</a>
    <c:if test="${ses.email eq pvo.writer || ses.grade eq 99 }">
        <a href="/product/modify?pno=${pvo.pno }&pageNo=${pgvo.pageNo }&qty=${pgvo.qty }"
            class="btn btn-outline-warning">Modify</a>
        <button type="button" id="product_del_btn"
            class="btn btn-outline-danger">Delete</button>
        <form action="" method="post" id="del_form">
            <input type="hidden" value="${pgvo.pageNo }" name="pageNo">
            <input type="hidden" value="${pgvo.qty }" name="qty">
            <input type="hidden" id="input_pno" name="pno">
        </form>
    </c:if>
</div>
<div class="container mt-3">
    <c:if test="${ses.email ne null }">
        <h2>Comment</h2>
        <p>
        <div class="input-group mb-3">
            <span class="input-group-text" id="cmtWriter"><c:out
                    value="${ses.email }" /></span> <input type="text"
                class="form-control" placeholder="Add Comment"
                id="cmtText">
            <button type="submit" class="btn btn-primary" id="cmtSbmBtn">ADD</button>
        </div>
        </p>
    </c:if>
    <table class="table table-striped">
        <thead>
            <tr>
                <th class="col-2">Writer</th>
                <th>Content</th>
                <th class="col-2">Reg At</th>
                <th class="col-2">Option</th>
            </tr>
        </thead>
        <tbody id="cmtZone">
        </tbody>
    </table>
    <div id="moreCmt" class="text-center"></div>
</div>
<!-- Button to Open the Modal -->
<button type="button" id="delModalBtn" class="d-none" data-bs-toggle="modal"
    data-bs-target="#myModal">Open modal</button>

<!-- The Modal -->
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">삭제</h4>
                <button type="button" class="btn-close"
                    data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">정말로 삭제하시겠습니까?</div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <input type="hidden" id="delCno">
                <button type="button" class="btn btn-outline-danger" id="delSbmBtn">Remove</button>
                <button type="button" id="delCloseBtn" class="btn btn-outline-secondary"
                    data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>
<script src="/resources/js/product.detail.js"></script>
<script src="/resources/js/product.comment.js"></script>
<jsp:include page="../common/footer.jsp" />