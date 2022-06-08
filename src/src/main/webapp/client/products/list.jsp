<%@ page import="java.util.List" %>
<%@ page import="com.example.t2009m1java.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: client
  Date: 6/6/2022
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    List<Product> products = (List<Product>) request.getAttribute("product");
%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<jsp:include page="/client/includes/head.jsp"/>
<body>
<jsp:include page="/client/includes/header.jsp"/>
<div id="app">
<%--    <div id="sidebar" class='active'>--%>
<%--        <jsp:include page="/client/includes/main-sidebar.jsp"/>--%>
<%--    </div>--%>
    <div id="main">
<%--        <jsp:include page="/client/includes/navbar.jsp"/>--%>

        <section class="product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-5">
                        <div class="sidebar">
<%--                            <div class="sidebar__item">--%>
<%--                                <h4>Lọc Theo</h4>--%>
<%--                                <ul>--%>
<%--                                    <form action="" id="filter_form">--%>
<%--                                        <select class="selectpicker form-control" id="price" name="price">--%>
<%--                                            <option selected disabled hidden>Lọc theo giá</option>--%>
<%--                                            <option value="1" {{$price && $price == 1 ? 'selected':''}}>0-20.000 VNĐ</option>--%>
<%--                                            <option value="2" {{$price && $price == 2 ? 'selected':''}}>20.000-50.000 VNĐ</option>--%>
<%--                                            <option value="3" {{$price && $price == 3 ? 'selected':''}}>50.000-100.000 VNĐ</option>--%>
<%--                                            <option value="4" {{$price && $price == 4 ? 'selected':''}}>Lớn Hơn 100.000 VNĐ</option>--%>
<%--                                        </select>--%>
<%--                                        <select class="selectpicker form-control" id="category" name="category">--%>
<%--                                            <option selected disabled hidden>Lọc danh mục</option>--%>
<%--                                            <option value="1" {{$category && $category == 1 ? 'selected':''}}>Rau</option>--%>
<%--                                            <option value="2" {{$category && $category == 2 ? 'selected':''}}>Củ</option>--%>
<%--                                            <option value="3" {{$category && $category == 3 ? 'selected':''}}>Quả</option>--%>
<%--                                        </select>--%>
<%--                                        <select class="selectpicker form-control" id="gardenName" name="gardenName">--%>
<%--                                            <option selected disabled hidden>Lọc theo nhà vườn</option>--%>
<%--                                            <option value="1" {{$gardenName && $gardenName == 1 ? 'selected':''}}>Vườn rau, trái cây sạch bà Họa--%>
<%--                                            </option>--%>
<%--                                            <option value="2" {{$gardenName && $gardenName == 2 ? 'selected':''}}>Rau sạch Minh Hiệp--%>
<%--                                            </option>--%>
<%--                                            <option value="3" {{$gardenName && $gardenName == 3 ? 'selected':''}}>Nhà Vườn Duy Quang--%>
<%--                                            </option>--%>
<%--                                            <option value="4" {{$gardenName && $gardenName == 4 ? 'selected':''}}>Nhà Vườn Quang Huy--%>
<%--                                            </option>--%>
<%--                                            <option value="5" {{$gardenName && $gardenName == 5 ? 'selected':''}}>Nhà Vườn Tiến Dũng--%>
<%--                                            </option>--%>
<%--                                        </select>--%>
<%--                                    </form>--%>
<%--                                </ul>--%>
<%--                            </div>--%>
<%--                            <div class="sidebar__item">--%>
<%--                                <div class="latest-product__text">--%>
<%--                                    <h4>Sản Phẩm Mới</h4>--%>
<%--                                    <div class="latest-product__slider owl-carousel">--%>
<%--                                        <div class="latest-prdouct__slider__item">--%>
<%--                                            <a href="#" class="latest-product__item">--%>
<%--                                                <div class="latest-product__item__pic">--%>
<%--                                                    <img src="{{$newProduct[0] -> thumbnail}}">--%>
<%--                                                </div>--%>
<%--                                                <div class="latest-product__item__text">--%>
<%--                                                    <h6>{{$newProduct[0] -> name}}</h6>--%>
<%--                                                    <span>{{number_format($newProduct[0] -> price)}} VND</span>--%>
<%--                                                </div>--%>
<%--                                            </a>--%>
<%--                                            <a href="#" class="latest-product__item">--%>
<%--                                                <div class="latest-product__item__pic">--%>
<%--                                                    <img src="{{$newProduct[1] -> thumbnail}}"--%>
<%--                                                         alt="">--%>
<%--                                                </div>--%>
<%--                                                <div class="latest-product__item__text">--%>
<%--                                                    <h6>{{$newProduct[1] -> name}}</h6>--%>
<%--                                                    <span>{{number_format($newProduct[1] -> price)}} VND</span>--%>
<%--                                                </div>--%>
<%--                                            </a>--%>
<%--                                            <a href="#" class="latest-product__item">--%>
<%--                                                <div class="latest-product__item__pic">--%>
<%--                                                    <img src="{{$newProduct[2] -> thumbnail}}"--%>
<%--                                                         alt="">--%>
<%--                                                </div>--%>
<%--                                                <div class="latest-product__item__text">--%>
<%--                                                    <h6>{{$newProduct[2] -> name}}</h6>--%>
<%--                                                    <span>{{number_format($newProduct[2] -> price)}} VND</span>--%>
<%--                                                </div>--%>
<%--                                            </a>--%>
<%--                                        </div>--%>
<%--                                        <div class="latest-prdouct__slider__item">--%>
<%--                                            <a href="#" class="latest-product__item">--%>
<%--                                                <div class="latest-product__item__pic">--%>
<%--                                                    <img src="{{$newProduct[3] -> thumbnail}}"--%>
<%--                                                         alt="">--%>
<%--                                                </div>--%>
<%--                                                <div class="latest-product__item__text">--%>
<%--                                                    <h6>{{$newProduct[3] -> name}}</h6>--%>
<%--                                                    <span>{{number_format($newProduct[3] -> price)}} VND</span>--%>
<%--                                                </div>--%>
<%--                                            </a>--%>
<%--                                            <a href="#" class="latest-product__item">--%>
<%--                                                <div class="latest-product__item__pic">--%>
<%--                                                    <img src="{{$newProduct[4] -> thumbnail}}"--%>
<%--                                                         alt="">--%>
<%--                                                </div>--%>
<%--                                                <div class="latest-product__item__text">--%>
<%--                                                    <h6>{{$newProduct[4] -> name}}</h6>--%>
<%--                                                    <span>{{number_format($newProduct[4] -> price)}} VND</span>--%>
<%--                                                </div>--%>
<%--                                            </a>--%>
<%--                                            <a href="#" class="latest-product__item">--%>
<%--                                                <div class="latest-product__item__pic">--%>
<%--                                                    <img src="{{$newProduct[5] -> thumbnail}}"--%>
<%--                                                         alt="">--%>
<%--                                                </div>--%>
<%--                                                <div class="latest-product__item__text">--%>
<%--                                                    <h6>{{$newProduct[5] -> name}}</h6>--%>
<%--                                                    <span>{{number_format($newProduct[5] -> price)}} VND</span>--%>
<%--                                                </div>--%>
<%--                                            </a>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-7">
                        <div class="filter__item">
                            <div class="row">
                                <div class="col-lg-4 col-md-5">
                                    <div class="filter__sort">
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4">
                                    <div class="filter__found">
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-3">
                                    <form action="">
                                        <div class="filter__option">
                                            <input class="search-product" type="text" name="search" id="search"
                                                   placeholder="Tìm Kiếm">
                                            <button type="submit" class="btn-success">Tìm Kiếm</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <%for (int i = 0; i < products.size(); i++) {%>
                            <div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="<%=products.get(i).getThumbnail()%>">
                                        <ul class="product__item__pic__hover">
                                            <li><a href=""><i class="fas fa-info"></i></a>
                                            </li>
                                            <li><a href="/shopping-cart/add?productId=<%=products.get(i).getId()%>&quantity=1"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <h6><%=products.get(i).getName()%></h6>
                                        <h5><%=products.get(i).getPrice()%> USD</h5>
                                    </div>
                                </div>
                            </div>
                            <%}%>
                        </div>
<%--                        <div class="row">--%>
<%--                            <div class="col-6">--%>
<%--                                @if ($list->lastPage() > 1)--%>
<%--                                <ul class="pagination">--%>
<%--                                    <li class="{{ ($list->currentPage() == 1) ? ' disabled' : '' }}">--%>
<%--                                        <a href="{{ $list->url(1) }}">Previous</a>--%>
<%--                                    </li>--%>
<%--                                    @for ($i = 1; $i <= $list->lastPage(); $i++)--%>
<%--                                    <li class="{{ ($list->currentPage() == $i) ? ' active' : '' }}">--%>
<%--                                        <a href="{{ $list->url($i) }}">{{ $i }}</a>--%>
<%--                                    </li>--%>
<%--                                    @endfor--%>
<%--                                    <li class="{{ ($list->currentPage() == $list->lastPage()) ? ' disabled' : '' }}">--%>
<%--                                        <a href="{{ $list->url($list->currentPage()+1) }}">Next</a>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>
<%--                                @endif--%>
<%--                            </div>--%>
<%--                        </div>--%>
                    </div>
                </div>
            </div>
        </section>


        <jsp:include page="/client/includes/footer.jsp"/>
    </div>
</div>
<jsp:include page="/client/includes/script.jsp"/>
</body>
</html>
