<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<jsp:include page="/client/includes/head.jsp"/>
<body>
<section>
    <div class="container mt-4 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card card-registration my-4">
                    <div class="row g-0">
                        <div class="col-xl-6 d-none d-xl-block">
                            <img
                                    src="/libs/client/img/img-form.jpg"
                                    width="525px" height="600px"
                            />
                        </div>
                        <div class="col-xl-6">
                            <form action="/login" method="post">
                                <div class="card-body text-black" style="padding: 80px">
                                    <h3 class="mb-3 text-uppercase text-center">Đăng Nhập</h3>
                                    <label class="form-label">Tài khoản</label>
                                    <div class="input-group form-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text bg-success border-success"><i
                                                    class="fas fa-user" aria-hidden="true"></i></span>
                                        </div>
                                        <input type="text" class="form-control border-success py-2" name="username"
                                               placeholder=" ">

                                    </div>


                                    <label class="form-label mt-2">Mật khẩu</label>
                                    <div class="input-group form-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text  bg-success border-success"><i
                                                    class="fas fa-key" aria-hidden="true"></i></span>
                                        </div>
                                        <input type="password" class="form-control border-success" name="password"
                                               placeholder=" ">

                                    </div>
                                    <div class="row justify-content-center px-3">
                                        <button type="submit" class="btn-block btn-submit">Gửi</button>
                                    </div>
                                    <div class="row justify-content-center my-2"><a href="#" class="text-muted">Quên Mật
                                        Khẩu?</a></div>
                                    <div class="bottom text-center mb-5">
                                        <p href="/register" class="sm-text mx-auto mb-3">Bạn Chưa Có Tài Khoản?
                                            <a href="/register" class="btn btn-success ml-2 btn-register">Tạo Mới
                                            </a>
                                        </p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/client/includes/script.jsp"/>
</body>
</html>
