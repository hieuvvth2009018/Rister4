<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.example.t2009m1java.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.t2009m1java.entity.myenum.ProductStatus" %>
<%@ page import="com.example.t2009m1java.entity.Product" %>
<%@ page import="java.util.HashMap" %>
<%
    int action = 1;
    String url = "/admin/products/create";
    String title = "Create new product";
    action = (int) request.getAttribute("action");
    if (action == 2) {
        url = "/admin/products/update";
        title = "Update product";
    }
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    if (categories == null) {
        categories = new ArrayList<>();
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    Product products = (Product) request.getAttribute("product");
    if (products == null) {
        products = Product.ProductBuilder.aProduct().build();
    }
%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<jsp:include page="/admin/includes/head.jsp"/>
<body>
<div id="app">
    <div id="sidebar" class='active'>
        <jsp:include page="/admin/includes/main-sidebar.jsp"/>
    </div>
    <div id="main">
        <jsp:include page="/admin/includes/navbar.jsp"/>

        <div class="main-content container-fluid">
            <div class="page-title">
                <div class="row">
                    <div class="col-12 col-md-6 order-md-1 order-last">
                        <h3><%=title%>
                        </h3>
                    </div>
                    <div class="col-12 col-md-6 order-md-2 order-first">
                        <nav aria-label="breadcrumb" class='breadcrumb-header'>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="/admin/products/list">Product Management</a></li>
                                <li class="breadcrumb-item active" aria-current="page"><%=title%>
                                </li>
                            </ol>
                        </nav>
                    </div>
                </div>

            </div>
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Product form</h4>
                    </div>
                    <div class="card-content">
                        <div class="card-body">
                            <form class="form" action="<%=url%>" method="post">
                                <%if (action == 2) {%>
                                <input type="hidden" name="id" value="<%=products.getId()%>">
                                <%}%>
                                <div class="row">
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="name-column">Name</label>
                                            <input type="text" id="name-column" class="form-control"
                                                   placeholder="Name" name="name" value="<%=products.getName()%>">
                                            <%if (errors.containsKey("name")) {%>
                                            <span class="text-danger">*<%=errors.get("name")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="price-column">Price</label>
                                            <input type="text" id="price-column" class="form-control"
                                                   name="price" placeholder="Price" value="<%=products.getPrice()%>">
                                            <%if (errors.containsKey("price")) {%>
                                            <span class="text-danger">*<%=errors.get("price")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-12">
                                        <div class="form-group">
                                            <label for="exampleFormControlTextarea1"
                                                   class="form-label">Description</label>
                                            <textarea name="description" class="form-control"
                                                      id="exampleFormControlTextarea1" rows="3"
                                                      spellcheck="false"
                                                      data-value="<%=products.getDescription()%>"></textarea>
                                            <%if (errors.containsKey("description")) {%>
                                            <span class="text-danger">*<%=errors.get("description")%></span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-12">
                                        <div class="form-group">
                                            <label>Detail</label>
                                            <div id="full">

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-12">
                                        <div class="form-group">
                                            <label>Thumbnail</label>
                                            <div class="m-2">
                                                <%--                                                    <div class="form-file">--%>
                                                <%--                                                        <input name="thumbnail" type="file" class="form-file-input" id="inputGroupFile01"--%>
                                                <%--                                                               aria-describedby="inputGroupFileAddon01">--%>
                                                <%--                                                    </div>--%>
                                                <button type="button" id="upload_widget"
                                                        class="btn btn-outline-primary">Choose Image
                                                </button>
                                            </div>
                                            <div>
                                                <img class="img-size-64 img-rounded img-thumbnail"
                                                     id="preview-image"
                                                     src="https://res.cloudinary.com/cuong0508/image/upload/v1654238650/d0dzvkwjnwqcu1bfmhd9.jpg">
                                                <input type="hidden" name="thumbnail" id="hidden-thumbnails" value="https://res.cloudinary.com/cuong0508/image/upload/v1654238650/d0dzvkwjnwqcu1bfmhd9.jpg">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <label>Category</label>
                                        <div class="form-group">
                                            <select name="categoryId" class="choices form-select"
                                                    data-value="<%=products.getCategoryId()%>">
                                                <%for (int i = 0; i < categories.size(); i++) {%>
                                                <option value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%>
                                                </option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <label>Status</label>
                                        <div class="form-group">
                                            <select name="status" class="choices form-select"
                                                    data-value="<%=products.getStatus()%>">
                                                <%for (int i = 0; i < ProductStatus.values().length; i++) {%>
                                                <option value="<%=ProductStatus.values()[i].getValue()%>"><%=ProductStatus.values()[i].name()%>
                                                </option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-12 d-flex justify-content-end">
                                        <button type="submit" value="Submit" class="btn btn-primary me-1 mb-1">Submit
                                        </button>
                                        <button type="reset" value="Reset" class="btn btn-light-secondary me-1 mb-1">
                                            Reset
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/admin/includes/footer.jsp"/>
    </div>
</div>
<jsp:include page="/admin/includes/script.jsp"/>

<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>

<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'cuong0508',
            uploadPreset: 'wsmp4snv'
        }, (error, result) => {
            if (!error && result && result.event === "success") {
                // console.log('Done! Here is the image info: ', result.info.secure_url);
                $('#preview-image').attr('src', result.info.secure_url);
                $('#hidden-thumbnails').val(result.info.secure_url);
            }
        }
    )

    document.getElementById("upload_widget").addEventListener("click", function () {
        myWidget.open();
    }, false);
</script>
</body>
</html>