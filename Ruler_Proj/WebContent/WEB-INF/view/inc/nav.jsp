<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav>
	<ul class="icons">
		<!-- 로그인 -->
		<c:if test="${empty userName }">
		<li><a href="/sign/login">로그인</a></li>
		<li>&#124;</li>
		<li><a href="/sign/agree">회원가입</a></li>
		</c:if>
		<!-- 로그아웃 -->
		<c:if test="${not empty userName }">
		<li><a href="/sign/logout">로그아웃</a></li>
		<li>&#124;</li>
		<li><a href="/mypage/index">마이페이지</a></li>
		</c:if> 
	</ul>
</nav>