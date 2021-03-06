<%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 16/4/28
  Time: 下午5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="/security" %>

<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>首页</h1>
<security:guest>
    <p>身份:游客</p>
    <a href="${BASE}/login">登录</a>
</security:guest>
<security:user>
    <p>身份：<security:principal/></p>
    <ul>
        <li><a href="${BASE}/customer">客户管理</a></li>
    </ul>
    <a href="<c:url value="/logout"/>">注销</a>
</security:user>
</body>
</html>
