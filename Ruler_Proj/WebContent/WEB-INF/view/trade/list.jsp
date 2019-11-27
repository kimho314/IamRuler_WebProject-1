<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="page" value="${(empty param.p)?1:param.p}"/>
<c:set var="startNum" value="${page-(page-1)%5}"/>
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(listCount/10),'.')}"/>

<!DOCTYPE HTML>
<html>
<head>
<title>쇼핑 도우미 : 아임룰러</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<script src="prefixfree.min.js"></script>
</head>
<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
					<h1>교환 게시판</h1>
					<nav>
						<ul class="icons">
							<!-- 로그인 -->
							<li><a href="/login">로그인</a></li>
							<li>&#124;</li>
							<li><a href="/signup">회원가입</a></li>
							<!-- 로그아웃 --><!--
							<li><a href="/logout">로그아웃</span></a></li>
							<li>&#124;</li>
							<li><a href="/mypage/index">마이페이지</a></li> -->
						</ul>
					</nav>
				</header>

				<br>
				<form action="/trade/list">
				<div>
				<div class="select-wrapper">
					<select name="area">
						<option value="">지역</option>
						<option value="서울특별시">서울특별시</option>
						<option value="부산광역시">부산광역시</option>
						<option value="대구광역시">대구광역시</option>
						<option value="광주광역시">광주광역시</option>
						<option value="대전광역시">대전광역시</option>
						<option value="울산광역시">울산광역시</option>
						<option value="세종특별자치시">세종특별자치시</option>
						<option value="경기도">경기도</option>
						<option value="강원도">강원도</option>
						<option value="충청북도">충청북도</option>
						<option value="충청남도">충청남도</option>
						<option value="전라북도">전라북도</option>
						<option value="전라남도">전라남도</option>
						<option value="경상북도">경상북도</option>
						<option value="경상남도">경상남도</option>
						<option value="제주특별자치도">제주특별자치도　　</option>
					</select> 
				</div>
					
				<div class="select-wrapper">
					<select name="body">
						<option value="">체형</option>
						<option value="선택안함">선택안함</option>
						<option value="역삼각형">작은 역삼각형</option>
						<option value="큰삼각형">큰삼각형</option>
						<option value="역삼각형">역삼각형</option>
						<option value="사각형">사각형　　　　　　</option>
					</select>
				</div>
					
				<div class="select-wrapper">
					 <select name="clothes">
						<option value="">옷 종류</option>
						<option value="상의">상의</option>
						<option value="하의">하의</option>
						<option value="아우터">아우터</option>
						<option value="치마">치마</option>
						<option value="원피스">원피스　　　　　　</option>
					</select> 
				</div>

				<div class="searchbutton">
					<input class="button" type="submit" value="검색" />
				</div>

				<div class="searchtext">
					<input type="text" name="q" value="${param.q}" />
					<input type="hidden" name="p" value="${param.p}" />
				</div>
				</div>	
				</form>
				 
				<br>
				<br>
				<div>
					<table class="alt center">
						<thead>
							<tr>
								<th class="center">번호</th>
								<th class="center">제목</th>
								<th class="center">지역</th>
								<th class="center">옷종류</th>
								<th class="center">체형</th>
								<th class="center">등록일</th>
								<th class="center">거래완료</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="t" items="${list}">
							<tr>
								<td>${t.id}</td>
								<td><a href="detail?id=${t.id}" class="black">${t.title}</a></td>
								<td>${t.region}</td>
								<td>${t.category}</td>
								<td>${t.bodyshape}</td>
								<td>${t.regdate}</td>
								<td></td>
							</tr>
							</c:forEach>
							
							</tbody>
						</table>
					</div>

					<div>
						<a href="/trade/reg" class="button special reg">글쓰기</a>
					</div>

			<div>
				<ul class="pagination center">
					<c:if test="${startNum <= 5}">
					<li><a href="javascript:alert('못가');" class="button disabled">Prev</a></li>
					</c:if>
					<c:if test="${startNum > 5}">
					<a class="button disabled" href="list?p=${startNum-1}">이전</a>
					</c:if>
					
					<li><a href="#" class="page active">1</a></li>
					<li><a href="#" class="page">2</a></li>
					<li><a href="#" class="page">3</a></li>
					<li><a href="#" class="page">4</a></li>
					<li><a href="#" class="page">5</a></li>
					<li><a href="#" class="page">6</a></li>
					<li><a href="#" class="page">7</a></li>
					<!-- <li><span>…</span></li> -->
					<li><a href="#" class="page">8</a></li>
					<li><a href="#" class="page">9</a></li>
					<li><a href="#" class="page">10</a></li>
					<c:if test="${startNum+5 > lastNum}">
					<li><a href="javascript:alert('다음페이지가 없습니다');" class="button">Next</a></li>
					</c:if>				
					<c:if test="${startNum+5 <= lastNum}">
						<a class="btn btn-next" href="list?p=${startNum+5}&f=${param.f}&q=${param.q}">${i+1}">다음</a>
					</c:if>
				</ul>
			</div>

			<!-- Section -->
			<section>
			</section>

			<!-- Section -->
			<section>
			</section>
			</div>
			</div>

			<!-- Sidebar -->
	<jsp:include page="../inc/aside.jsp"></jsp:include>

	</div>

	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/skel.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="../assets/js/main.js"></script>

</body>
</html>