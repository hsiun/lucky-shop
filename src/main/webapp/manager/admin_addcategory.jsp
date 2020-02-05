<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="./admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a
                class="crumb-name" href="./admin_addcategory.jsp">目录管理</a><span
                class="crumb-step">&gt;</span><span>新增目录</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_addcategory" method="post" id="myform" name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>父ID：</th>
                        <td>
                            <select class="common-text required" name="parentId">
                                <option value="0" selected="selected" >根分类</option>
                                <c:forEach var="category" items="${categorys}">
                                    <c:if test="${category.categoryParentId == '0'}">
                                        <option value="${category.id}">${category.categoryName}</option>
                                    </c:if>
                                </c:forEach>

                            </select>
                        </td>

                    </tr>
                    <tr>
                        <th>分类名：</th>
                        <td><input class="common-text" name="name" size="50" type="text" value=""></td>
                    </tr>

                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>

</div>
<!--/main-->
</div>
</body>
</html>