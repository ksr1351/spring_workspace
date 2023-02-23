<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title"/></title> <!-- tiles.xml의 title이 그대로 복사되서 사용됨 -->
<style>
* {
	margin: 0px;
}

header {
	width: 100%;
	height: 100px;
	background-color: aqua;
}

nav {
	height: 670px;
	background-color: teal;
	width: 15%;
	float: left;
}

section {
	background-color: skyblue;
	width: 80%;
	height: 670px;
	float: right;
}

footer {
	background-color: #ffffff;
	clear: both;
}
</style>



</head>
<body>

<header>
	<tiles:insertAttribute name="header" /> <!-- tiles.xml의 header가 그대로 복사되서 사용됨 -->
	<!-- 실제 실행하면 <h2 style="align:'center'">Spring Tiles Example!!!</h2> 가 들어감 -->
</header>

<nav>
	<tiles:insertAttribute name="menu"/> <!-- tiles.xml의 menu가 그대로 복사되서 사용됨 -->
</nav>

<section>
	<tiles:insertAttribute name="body"/> <!-- tiles.xml의 body가 그대로 복사되서 사용됨 -->
</section>

<footer>
	<tiles:insertAttribute name="footer"/> <!-- tiles.xml의 footer가 그대로 복사되서 사용됨 -->
</footer>
</body>
</html>