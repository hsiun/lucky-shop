<%@ page isELIgnored="false" %> <!-- 不加jstl标签不生效 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp"><img src="img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
                <c:if test="${login == 'true'}" >
                    您好：<a href="#" id="reg">${user.userName}</a>
                </c:if>

                <c:if test="${login != 'true'}" >
                    <a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
                </c:if>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="person.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a><a href="cart.jsp"><img src="img/gwc.png"/></a>
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="selectindex">首页</a></li>
            <c:forEach var="p" items="${plist}">
            <li><a href="/luckyshop/selectprolist?pid=${p.id}">${p.categoryName}</a>
                <div class="sList2">
                    <c:forEach var="c" items="${clist}">
                        <c:if test="${c.categoryParentId == p.id}">

                        <div class="clearfix">
                        <a href="/luckyshop/selectprolist?cid=${c.id}">${c.categoryName}</a>
                        </div>
                        </c:if>
                    </c:forEach>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>
</div>