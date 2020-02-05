<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="./admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a
                class="crumb-name" href="./admin_addcategory.jsp">产品管理</a><span
                class="crumb-step">&gt;</span><span>新增产品</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_addproduct" method="post" enctype="multipart/form-data" id="myform" name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>分类ID：</th>
                        <td>
                            <select class="common-text required" name="tagId">
                                <c:forEach var="p" items="${plist}">
                                    <option value="${p.id}" disabled="disabled">-|${p.categoryName}</option>
                                    <c:forEach var="c" items="${clist}">
                                        <c:if test="${c.categoryParentId == p.id}">
                                            <option value="${p.id}|${c.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-|${c.categoryName}</option>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>

                            </select>
                        </td>

                    </tr>
                    <tr>
                        <th>产品名称：</th>
                        <td><input class="common-text" name="productName" size="50" type="text" value=""></td>
                    </tr>

                    <tr>
                        <th>产品描述：</th>
                        <td><input class="common-text" name="productDes" size="50" type="text" value=""></td>
                    </tr>
                    <tr>
                        <th>产品价格：</th>
                        <td><input class="common-text" name="productPrice" size="50" type="text" value=""></td>
                    </tr>
                    <tr>
                        <th>产品库存：</th>
                        <td><input class="common-text" name="productStock" size="50" type="text" value=""></td>
                    </tr>
                    <tr>
                        <th>产品图片：</th>
                        <td><input class="common-text" name="productFilename" size="50" type="file" value=""></td>
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