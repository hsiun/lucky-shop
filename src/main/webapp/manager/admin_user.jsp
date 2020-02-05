<%@ page isELIgnored="false" %> <!-- 不加jstl标签不生效 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/luckyshop/manager/admin_selectuser" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="/luckyshop/manager/admin_deleteuser" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_insert.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:batchDel('你确定要删除这些用户${u.userName}吗？', 'myform')"><i class="icon-font"></i>批量删除</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" onclick="selall(this)" name="" type="checkbox"></th>
                            <th>ID</th>
                            <th>用户名</th>
                            <th>用户密码</th>
                            <th>电话</th>
                            <th>地址</th>
                            <th>生日</th>
                            <th>操作</th>

                        </tr>
                        <c:forEach var="u" items="${users}" >
                        <tr>
                            <td class="tc"><input name="id[]" value="${u.ID}" type="checkbox"></td>
                            <td> ${u.ID } </td>
                            <td> ${u.userName } </td>
                            <td> ${u.userPassword } </td>
                            <td> ${u.userMobile }</td>
                            <td> ${u.userAddress }</td>
                            <td> ${u.userBirthday }</td>

                            <td>
                                <a class="link-update" href="/luckyshop/manager/admin_touserupdate?cp=${cpage}&id=${u.ID}">修改</a>
                                <a class="link-del" href="javascript:Delete('你确定要删除用户${u.userName}吗？', 'admin_deleteuser?id=${u.ID}')">删除</a>
                            </td>
                        </tr>
                        </c:forEach>

                        <script>
                            function Delete(mess, url) {
                                if (confirm(mess)) {
                                    location.href=url;
                                }
                            }
                            function selall(o) {
                                var a = document.getElementsByName('id[]');
                                for (var i=0; i<a.length; i++) {
                                    a[i].checked = o.checked;
                                }
                            }

                            function batchDel(mess, formname) {
                                if (confirm(mess)) {
                                    var form = document.getElementById(formname)
                                    form.submit();
                                }
                            }
                        </script>
                    </table>
                    <div class="list-page">
                        共 ${tsum} 条记录，当前 ${cpage}/${tpage} 页
                        <a href="/luckyshop/manager/admin_selectuser?cp=1${search_keyword}">首页</a>
                        <a href="/luckyshop/manager/admin_selectuser?cp=${cpage-1<1?1:cpage-1}${search_keyword}">前一页</a>
                        <a href="/luckyshop/manager/admin_selectuser?cp=${cpage+1>tpage?cpage:cpage+1}${search_keyword}">后一页</a>
                        <a href="/luckyshop/manager/admin_selectuser?cp=${tpage}${search_keyword}">尾页</a>
                        <select name="search-sort" id="">
                            <option value="1">第1页</option>
                            <option value="2">第2页</option>
                            <option value="3">第3页</option>
                        </select>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>