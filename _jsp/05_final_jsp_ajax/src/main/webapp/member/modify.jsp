<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"></jsp:include>

<!-- Header -->
<header class="ex-header">
    <div class="container">
        <div class="row">
            <div class="col-xl-10 offset-xl-1">
                <h1 class="text-center">Modify Member</h1>
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
                    </p>

                    <!-- Modify Form -->
                    <form action="/mem/update" method="post">
                        <div class="mb-4 form-floating">
                            <input type="email" class="form-control" id="floatingInput"
                                placeholder="name@example.com" name="email" value="${mvo.email }" readonly> <label
                                for="floatingInput">${mvo.email }</label>
                        </div>
                        <div class="mb-4 form-floating">
                            <input type="text" class="form-control" id="floatingInput2" name="nick_name"
                                value="${mvo.nick_name }" required> <label for="floatingInput">Your
                                Nick Name</label>
                        </div>
                        <div class="mb-4 form-floating">
                            <input type="password" class="form-control" id="floatingPassword"
                                value="${mvo.pwd }" name="pwd"> <label for="floatingPassword">Password</label>
                        </div>
                        <div class="mb-4 form-floating">
                            <input type="text" class="form-control" id="floatingPassword"
                                value="${mvo.grade }" name="grade"> <label for="floatingPassword">Grade</label>
                        </div>
                        <button type="submit" class="form-control-submit-button">Modify Member</button>
                    </form>
                    <form action="/mem/remove" method="post">
                        <input type="hidden" name="email" value="${mvo.email }">
                        <button type="submit" class="my-3 px-5 mx-auto btn btn-outline-danger">Remove Member</button>
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

<jsp:include page="../footer.jsp"></jsp:include>
