<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/nav.jsp"/>

<div class="container mt-3">
  <h2>Product Modify</h2>
  <form action="/product/register" method="post">
    <div class="mb-3 mt-3">
      <label for="writer">Writer</label>
      <input type="text" class="form-control" id="writer" name="writer" value="${ses.email }" readonly>
    </div>
    <div class="mb-3 mt-3">
      <label for="pname">Product Name</label>
      <input type="text" class="form-control" id="pname" placeholder="Enter pname" name="pname">
    </div>
    <div class="mb-3">
      <label for="price">Product Price</label>
      <input type="text" class="form-control" id="price" placeholder="Enter price" name="price">
    </div>
    <div class="mb-3">
      <label for="description">Product Description</label>
      <input type="text" class="form-control" id="description" placeholder="Enter Description" name="description">
    </div>
    <div class="mb-3">
      <label for="madeBy">Product Made By</label>
      <input type="text" class="form-control" id="madeBy" placeholder="Enter Made By" name="madeBy">
    </div>
    <div class="mb-3">
      <label for="category">Category</label>
      <input type="text" class="form-control" id="category" name="category" placeholder="Enter Category" value="${pvo.category }">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

<jsp:include page="../common/footer.jsp"/>