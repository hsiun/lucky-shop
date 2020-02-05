<%@ page isELIgnored="false" %>
<!-- 不加jstl标签不生效 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span
                class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
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
    <form action="/luckyshop/manager/admin_selectcatagroy" name="myform" id="myform" method="post">
        <div class="result-title">
            <div class="result-list">
                <a href="/luckyshop/manager/admin_toaddcategory"><i class="icon-font"></i>新增分类</a>
            </div>
        </div>
            <div class="result-content">
                <table class="result-tab" width="100%">
                    <tr>
                        <th>ID</th>
                        <th>分类名</th>
                        <th>操作</th>

                    </tr>
                    <c:forEach var="cate" items="${category}">
                        <c:if test="${cate.categoryParentId == '0'}">
                            <tr>
                                <td> ${cate.id } </td>
                                <td> |- ${cate.categoryName } </td>
                                <td><a href="/luckyshop/manager/admin_tomodifycategory?id=${cate.id}">修改</a>
                                    <a href="javascript:Delete('确定删除吗？', '/luckyshop/manager/admin_delcategory?id=${cate.id}')">删除</a></td>
                                </td>
                            </tr>
                            <c:forEach var="subcate" items="${category}">
                                <c:if test="${subcate.categoryParentId == cate.id}">
                                <tr>
                                    <td> ${subcate.id } </td>
                                    <td>&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;  |-${subcate.categoryName } </td>
                                    <td><a href="/luckyshop/manager/admin_tomodifycategory?id=${cate.id}">修改</a>
                                        <a href="javascript:Delete('确定删除吗？', '/luckyshop/manager/admin_delcategory?id=${cate.id}')">删除</a></td>
                                </tr>
                                </c:if>
                            </c:forEach>
                        </c:if>
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