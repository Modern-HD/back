<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/nav.jsp"/>

<div class="container mt-3">
  <h2>Product Modify</h2>
  <form action="/product/modify" method="post" enctype="multipart/form-data">
    <input type="hidden" value="${pdto.pvo.pno }" name="pno">
    <input type="hidden" value="${pgvo.pageNo }" name="pageNo">
    <input type="hidden" value="${pgvo.qty }" name="qty">
    <input type="hidden" value="${pgvo.type }" name="type">
    <input type="hidden" value="${pgvo.kw }" name="kw">
    <div class="mb-3 mt-3">
      <label for="pname">Product Name</label>
      <input type="text" class="form-control" id="pname" placeholder="Enter pname" name="pname" value="${pdto.pvo.pname }">
    </div>
    <div class="mb-3">
      <label for="price">Product Price</label>
      <input type="text" class="form-control" id="price" placeholder="Enter price" name="price" value="${pdto.pvo.price }">
    </div>
    <div class="mb-3">
      <label for="description">Product Description</label>
      <input type="text" class="form-control" id="description" name="description" value="${pdto.pvo.description }">
    </div>
    <div class="mb-3">
      <label for="madeBy">Product Made By</label>
      <input type="text" class="form-control" id="madeBy" name="madeBy" value="${pdto.pvo.madeBy }">
    </div>
    <div class="mb-3">
      <label for="category">Category</label>
      <input type="text" class="form-control" id="category" name="category" value="${pdto.pvo.category }">
    </div>
    <div class="mb-3">
            <label for="attach">File Attach:</label> <input type="file"
                class="form-control" style="display: none;" id="files"
                name="fileAttached" multiple>
            <div class="d-grid">
                <button type="button" id="attachTrigger"
                    class="btn btn-outline-primary btn-block d-block">Attach
                    Files</button>
            </div>
    </div>
    <button id="modBtn" type="submit" class="btn btn-primary">Submit</button>
    <div class="my-3" id="fileZone"></div>
  </form>
  <hr>
</div>
<div class="container mt-3">
  <ul class="list-group list-group-flush">
  <c:forEach items="${pdto.fileList }" var="fvo">
    <li class="list-group-item d-flex justify-content-between align-items-center">
    ${fvo.fileName }
    <span class="badge bg-primary rounded-pill">${fvo.fileSize }</span>
    <button data-uuid="${fvo.uuid }" class="btn btn-outline-danger btn-sm fileDelBtn">X</button>
    </li>
  </c:forEach>
  </ul>
</div>
<script src="/resources/js/product.register.js"></script>
<script src="/resources/js/product.modify.js"></script>
<jsp:include page="../common/footer.jsp"/>