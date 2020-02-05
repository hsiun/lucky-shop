<%@ page isELIgnored="false" %> <!-- 不加jstl标签不生效 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="./admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="./admin_insert.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>修改用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="admin_updateuser" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>ID：</th>
                            <td>
                                <input type="hidden" name="id" size="50" value="${user.ID}" type="text" >
                            </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="username" size="50" value="${user.userName}" type="text" >
                                </td>
                            </tr>
                            <tr>
                                <th>密码：</th>
                                <td><input class="common-text" name="password" size="50" type="text" value="${user.userPassword}"></td>
                            </tr>

                        <tr>
                            <th>电话号码：</th>
                            <td><input class="common-text" name="mobile" size="50" type="text" value="${user.userMobile}"></td>
                        </tr>

                        <tr>
                            <th>地址：</th>
                            <td><input class="common-text" name="address" size="50" type="text" value="${user.userAddress}"></td>
                        </tr>

                        <tr>
                            <th>生日：</th>
                            <td><input class="common-text" name="birthday" size="50" type="text" value="${user.userBirthday}"></td>
                        </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>