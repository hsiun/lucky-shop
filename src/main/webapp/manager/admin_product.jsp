<%@ page isELIgnored="false" %>
<!-- 不加jstl标签不生效 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
                class="crumb-step">&gt;</span><span class="crumb-name">产品管理</span></div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="/luckyshop/manager/admin_selectuser" method="get">
                <table class="search-tab">
                    <tr>
                        <th width="70">关键字:</th>
            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}"
                       type="text"></td>
            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
            </tr>
            </table>
        </form>
    </div>
</div>
<div class="result-wrap">
    <form action="/luckyshop/manager/admin_selectproduct" name="myform" id="myform" method="post">
        <div class="result-title">
            <div class="result-list">
                <a href="/luckyshop/manager/admin_toaddproduct"><i class="icon-font"></i>新增产品</a>
            </div>
        </div>
            <div class="result-content">
                <table class="result-tab" width="100%">
                    <tr>
                        <th>ID</th>
                        <th>产品名</th>
                        <th>操作</th>

                    </tr>
                    <c:forEach var="product" items="${products}" >
                        <tr>
                            <td width="360">${product.id}</td>
                            <td>${product.productName} <img src="../images/product/${product.productFilename}" width="80" height="80"></td>

                            <td><a href="/luckyshop/manager/admin_tomodifyproduct?id=${product.id}">修改</a>
                                <a href="javascript:Delete('确定删除吗？', '/luckyshop/manager/admin_delproduct?id=${product.id}')">删除</a></td>                        </tr>
                    </c:forEach>


                    <script>
                        function Delete(mess, url) {
                            if (confirm(mess)) {
                                location.href = url;
                            }
                        }
                    </script>
                </table>

            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>