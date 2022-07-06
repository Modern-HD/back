<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />
<c:set var="ssmvo" value="${ses }" scope="session" />
<!-- Details 1 -->
<div id="details" class="basic-1 bg-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-xl-5">
				<div class="text-container">
					<h2>${pvo.pname }</h2>
					<a class="btn-solid-reg" data-bs-toggle="modal"
						data-bs-target="#staticBackdrop">More</a>
				</div>
				<!-- end of text-container -->
			</div>
			<!-- end of col -->
			<div class="col-lg-6 col-xl-7">
				<div class="image-container">
					<img class="img-fluid" src="/resources/distimages/details-1.svg"
						alt="alternative">
				</div>
				<!-- end of image-container -->
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</div>
<!-- end of basic-1 -->
<!-- end of details 1 -->
<!-- Details Modal -->
<div id="staticBackdrop" class="modal fade" tabindex="-1"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="row">
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
				<div class="col-lg-8">
					<div class="image-container">
						<img class="img-fluid"
							src="/resources/dist/images/details-modal.jpg" alt="alternative">
					</div>
					<!-- end of image-container -->
				</div>
				<!-- end of col -->
				<div class="col-lg-4">
					<h3>${pvo.pname }</h3>
					<hr>
					<p>${pvo.regdate }</p>
					<ul class="list-unstyled li-space-lg">
						<li class="d-flex"><i class="fas fa-chevron-right"></i>
							<div class="flex-grow-1">price: ${pvo.price }</div></li>
						<li class="d-flex"><i class="fas fa-chevron-right"></i>
							<div class="flex-grow-1">madeby: ${pvo.madeby }</div></li>
						<li class="d-flex"><i class="fas fa-chevron-right"></i>
							<div class="flex-grow-1">pno: ${pvo.pno }</div></li>
					</ul>
					<c:if test="${ssmvo.email eq pvo.madeby }">
						<a id="modalCtaBtn" class="btn-solid-reg"
							href="/pdt/modify?pno=${pvo.pno }">Modify</a>
						<a id="modalCtaBtn" class="btn-outline-reg"
							href="/pdt/remove?pno=${pvo.pno }">Remove</a>
					</c:if>
				</div>
				<!-- end of col -->
			</div>
			<!-- end of row -->
		</div>
		<!-- end of modal-content -->
	</div>
	<!-- end of modal-dialog -->
</div>
<!-- end of modal -->
<!-- end of details modal -->

<!-- Questions -->
<div class="accordion-1">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="h2-heading">Product Replies</h2>
				<div class="input-group mb-3">
				  <span class="input-group-text" id="rspReplier">${ssmvo.email }</span>
					<input type="text" class="form-control" id="rpsText" placeholder="Add Replise">
					<button class="btn btn-success" type="button" id="rpsAddBtn">ADD</button>
				</div>
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="accordion" id="accordionExample">

					<!-- Accordion Item -->
					<div class="accordion-item">
						<h2 class="accordion-header" id="headingOne">
							<button class="accordion-button" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseOne"
								aria-expanded="true" aria-controls="collapseOne">cno, bno, writer</button>
						</h2>
						<div id="collapseOne" class="accordion-collapse collapse show"
							aria-labelledby="headingOne" data-bs-parent="#accordionExample">
							<div class="accordion-body">content, mod_at</div>
						</div>
					</div>
					<!-- end of accordion-item -->
				</div>
				<!-- end of accordion -->
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</div>
<!-- end of accordion-1 -->
<!-- end of questions -->
<script>
const pnoVal = '<c:out value="${pvo.pno}"/>';
</script>
<script src="/resources/js/product.detail.js"></script>
<script>
printRepliesList(pnoVal);
</script>
<jsp:include page="../footer.jsp" />