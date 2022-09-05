<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/nav.jsp"/>

<div class="container mt-3">
  <h2>Product Modify</h2>
  <form action="/product/modify" method="post">
    <input type="hidden" value="${pvo.pno }" name="pno">
    <input type="hidden" value="${pgvo.pageNo }" name="pageNo">
    <input type="hidden" value="${pgvo.qty }" name="qty">
    <div class="mb-3 mt-3">
      <label for="pname">Product Name</label>
      <input type="text" class="form-control" id="pname" placeholder="Enter pname" name="pname" value="${pvo.pname }">
    </div>
    <div class="mb-3">
      <label for="price">Product Price</label>
      <input type="text" class="form-control" id="price" placeholder="Enter price" name="price" value="${pvo.price }">
    </div>
    <div class="mb-3">
      <label for="description">Product Description</label>
      <input type="text" class="form-control" id="description" name="description" value="${pvo.description }">
    </div>
    <div class="mb-3">
      <label for="madeBy">Product Made By</label>
      <input type="text" class="form-control" id="madeBy" name="madeBy" value="${pvo.madeBy }">
    </div>
    <div class="mb-3">
      <label for="category">Category</label>
      <input type="text" class="form-control" id="category" name="category" value="${pvo.category }">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

<jsp:include page="../common/footer.jsp"/>