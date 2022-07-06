<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />
<c:set var="ssmvo" value="${ses }" scope="session"/>
<!-- Header -->
<header class="ex-header">
	<div class="container">
		<div class="row">
			<div class="col-xl-10 offset-xl-1">
				<h1 class="text-center">Board Register</h1>
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</header>
<!-- end of ex-header -->
<!-- end of header -->


<!-- Basic -->
<div class="ex-form-1 pt-5 pb-5">
	<div class="container">
		<div class="row">
			<div class="col-xl-6 offset-xl-3">
				<div class="text-box mt-5 mb-5">
					<p class="mb-4">
						 <a class="blue" href="#">Product Modify</a>
					</p>

					<!-- Sign Up Form -->
					<form action="/pdt/update" method="post">
					   <div class="mb-4 form-floating">
			              <input type="text" class="form-control" id="" name="pname"
			                placeholder="Board title" value="${pvo.pname }"> <label for="">Product Name</label>
			            </div>
			            <div class="mb-4 form-floating">
			              <input type="text" class="form-control" id="" name="price"
			                placeholder="Board Price" value="${pvo.price }"> <label for="">Product
			                Price</label>
			            </div>
			            <div class="mb-4 form-floating">
			              <input type="text" class="form-control" id="" name="madeby"
			                value="${ssmvo.email }" readonly> <label for="">Product
			                Made By</label>
			            </div>
                            <input type="hidden" value="${pvo.pno }" name="pno">
						<button type="submit" class="form-control-submit-button">Modify</button>
					</form>
					<!-- end of sign up form -->

				</div>
				<!-- end of text-box -->
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</div>
<!-- end of ex-basic-1 -->
<!-- end of basic -->

<jsp:include page="../footer.jsp" />