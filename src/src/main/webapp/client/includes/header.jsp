<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div id="preloder">
    <div class="loader"></div>
</div>

<div class="humberger__menu__overlay"></div>
<div class="humberger__menu__wrapper">
    <div class="humberger__menu__logo">
        <a href="#"><img src="/libs/client/img/logo/logo.png"></a>
    </div>
    <div class="humberger__menu__widget">
        <div class="header__top__right__language">
            <a href="/shopping-cart"><i class="fa fa-shopping-bag"></i></a>
        </div>
        <div class="header__top__right__auth">
            <a href="#"><i class="fa fa-user"></i> Đăng Nhập</a>
        </div>
    </div>
    <nav class="humberger__menu__nav mobile-menu">
        <ul>
            <li><a href="/">Trang Chủ</a></li>
            <li><a href="/products">Sản Phẩm</a></li>
            <li><a href="/shopping-cart">Giỏ Hàng</a></li>
            {{--
            <li><a href="#">Pages</a>--}}
                {{--
                <ul class="header__menu__dropdown">--}}
                    {{--
                    <li><a href="/shopping-cart">Giỏ Hàng</a></li>
                    --}}
                    {{--
                    <li><a href="/checkout">Thanh Toán</a></li>
                    --}}
                    {{--
                </ul>
                --}}
                {{--
            </li>
            --}}
            <li><a href="#">Nhà Vườn</a>
                <ul class="header__menu__dropdown">
                    <li><a href="/garden/name1">Vườn rau, trái cây sạch bà Họa</a></li>
                    <li><a href="/garden/name2">Rau sạch Minh Hiệp</a></li>
                    <li><a href="/garden/name3">Nhà Vườn Duy Quang</a></li>
                    <li><a href="/garden/name4">Nhà Vườn Quang Huy</a></li>
                    <li><a href="/garden/name5">Nhà Vườn Tiến Dũng</a></li>
                </ul>
            </li>
            <li><a href="/contact">Liên Hệ</a></li>
        </ul>
    </nav>
    <div id="mobile-menu-wrap"></div>
</div>

<header class="header">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="/"><img src="/libs/client/img/logo/logo.png"></a>
                </div>
            </div>
            <div class="col-lg-7">
                <nav class="header__menu">
                    <ul>
                        <li><a href="/">Trang Chủ</a></li>
                        <li><a href="/products">Sản Phẩm</a></li>
                        <li><a href="/shopping/cart">Giỏ Hàng</a></li>
                        <li><a href="#">Nhà Vườn</a>
                            <ul class="header__menu__dropdown">
                                <li><a href="/garden/name1">Vườn rau, trái cây sạch bà Họa</a></li>
                                <li><a href="/garden/name2">Rau sạch Minh Hiệp</a></li>
                                <li><a href="/garden/name3">Nhà Vườn Duy Quang</a></li>
                                <li><a href="/garden/name4">Nhà Vườn Quang Huy</a></li>
                                <li><a href="/garden/name5">Nhà Vườn Tiến Dũng</a></li>
                            </ul>
                        </li>
                        <li><a href="/contact">Liên Hệ</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-2">
                <div class="header__cart">
<%--                    @if(\Illuminate\Support\Facades\Auth::check())--%>
                    <div class="dropdown float-right">
<%--                        <button class="btn dropdown-toggle border-bottom" type="button" id="dropdownMenuButton"--%>
<%--                                data-toggle="dropdown"--%>
<%--                                aria-haspopup="true" aria-expanded="false">--%>
<%--&lt;%&ndash;                            <i class="fas fa-user"></i>&ensp;{{\Illuminate\Support\Facades\Auth::user()->fullName}}&ndash;%&gt;--%>
<%--                        </button>--%>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item border-0" href="/shopping/cart"><i
                                    class="fa fa-shopping-bag">
                                Giỏ hàng</i></a>
                            <a class="dropdown-item border-0" href="/logout"><i
                                    class="fas fa-power-off ic-logout"></i> Đăng xuất</a>
                        </div>
<%--                        @else--%>
                        <ul>
                            <li><a href="/login"><i class="fa fa-user">&ensp;Đăng Nhập</i></a></li>
                        </ul>
<%--                        @endif--%>
                    </div>
                </div>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>

<section class="hero">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="hero__search">
                    <div class="hero__search__form">
                        <form action="/products">
                            <input name="search" type="text" placeholder="Bạn cần tìm gì?">
                            <button type="submit" class="site-btn">Tìm Kiếm</button>
                        </form>
                    </div>
                    <div class="hero__search__phone">
                        <div class="hero__search__phone__icon">
                            <i class="fa fa-phone"></i>
                        </div>
                        <div class="hero__search__phone__text">
                            <h5>+84 88.888.888</h5>
                            <span>hỗ trợ 24/7</span>
                        </div>
                    </div>
                </div>
                <div class="hero__item set-bg" data-setbg="/libs/client/img/hero/img_2.png">
                    <div class="hero__text">
                        <span>Rau Sạch</span>
                        <h2>Rau quả<br/>100% hữu cơ</h2>
                        <p>Nhận và giao hàng miễn phí</p>
                        <a href="/products" class="primary-btn">Mua Ngay</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>