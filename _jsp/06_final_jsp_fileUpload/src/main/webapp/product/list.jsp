<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"></jsp:include>

<div id="pricing" class="cards-2 bg-gray">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="h2-heading">Product List
                <c:if test="${ssmvo.email ne null && ssmvo.email ne '' }">
                 <a href="/pdt/register" class="btn btn-primary">Regster</a>
                 </c:if>
                 </h2>
            </div>
            <!-- end of col -->
        </div>
        <!-- end of row -->
        <div class="row">
            <div class="col-lg-12">
                <c:forEach var="pvo" items="${list }">
                    <!-- Card -->
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title">
                                <img class="decoration-lines" src="/rescources/dist/images/decoration-lines.svg"
                                    alt="alternative"><span>${pvo.pname }</span><img
                                    class="decoration-lines flipped"
                                    src="/rescources/dist/images/decoration-lines.svg" alt="alternative">
                            </div>
                            <ul class="list-unstyled li-space-lg">                                                              
                                <li>${pvo.madeby }</li>                             
                                <li>${pvo.regdate }</li>                             
                            </ul>
                            <div class="price">${pvo.price }</div>
                            <a href="/pdt/detail?pno=${pvo.pno }" class="btn-solid-reg">Go Detail</a>
                        </div>
                    </div>
                    <!-- end of card -->
                </c:forEach>
            </div>
            <!-- end of col -->
        </div>
        <!-- end of row -->
    </div>
    <!-- end of container -->
</div>

<jsp:include page="../footer.jsp"></jsp:include>
