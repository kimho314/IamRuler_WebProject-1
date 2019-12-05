	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년-MM-dd");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
					<jsp:include page="../inc/nav.jsp"></jsp:include>
				</header>

				<form action="edit" method="post" enctype="multipart/form-data">
				<input type="hidden" name="board_id" value="${sessionScope.sessionID}">
				<br>
				<table class="default">
					<tbody>
						<tr>
							<th class="center vertical	">제목</th>
							<td><input type="text" name="title" value="${t.bTitle}"></td>
						</tr>
						<tr>
							<th class="center">작성자</th>
							<td>${t.mUserName}</td>
						</tr>
						<tr>
							<th class="center">등록일자</th>
							<td>${t.bRegdate}</td>
						</tr>
						<tr>
							<th class="center">거래여부</th>
							<td><div class="6u 12u$(small)">
								<input type="checkbox" id="demo-copy" name="complete">
								<label for="demo-copy">거래완료</label>
								</div></td>
						</tr>
						<tr>
							<th class="center vertical">의류</th>
							<td>
								<div class="select-wrapper">
									<select name="category">
										<option value="">옷 종류</option>
										<option value="상의"<c:if test="${t.itemCategory eq '상의'}">selected</c:if>>상의</option>
										<option value="하의"<c:if test="${t.itemCategory eq '하의'}">selected</c:if>>하의</option>
										<option value="아우터"<c:if test="${t.itemCategory eq '아우터'}">selected</c:if>>아우터</option>
										<option value="치마"<c:if test="${t.itemCategory eq '치마'}">selected</c:if>>치마</option>
										<option value="원피스"<c:if test="${t.itemCategory eq '원피스'}">selected</c:if>>원피스　　　　</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<th class="center vertical">지역</th>
							<td>
								<div class="select-wrapper">
									<select name="region">
										<option value="">지역</option>
										<option value="서울특별시" <c:if test="${t.itemRegion eq '서울특별시'}">selected</c:if>>서울특별시</option>
										<option value="부산광역시" <c:if test="${t.itemRegion eq '부산광역시'}">selected</c:if>>부산광역시</option>
										<option value="대구광역시" <c:if test="${t.itemRegion eq '대구광역시'}">selected</c:if>>대구광역시</option>
										<option value="광주광역시" <c:if test="${t.itemRegion eq '광주광역시'}">selected</c:if>>광주광역시</option>
										<option value="대전광역시" <c:if test="${t.itemRegion eq '대전광역시'}">selected</c:if>>대전광역시</option>
										<option value="울산광역시" <c:if test="${t.itemRegion eq '울산광역시'}">selected</c:if>>울산광역시</option>
										<option value="세종특별자치시" <c:if test="${t.itemRegion eq '세종특별자치시'}">selected</c:if>>세종특별자치시</option>
										<option value="경기도" <c:if test="${t.itemRegion eq '경기도'}">selected</c:if>>경기도</option>
										<option value="강원도" <c:if test="${t.itemRegion eq '강원도'}">selected</c:if>>강원도</option>
										<option value="충청북도" <c:if test="${t.itemRegion eq '충청북도'}">selected</c:if>>충청북도</option>
										<option value="충청남도" <c:if test="${t.itemRegion eq '충청남도'}">selected</c:if>>충청남도</option>
										<option value="전라북도" <c:if test="${t.itemRegion eq '전라북도'}">selected</c:if>>전라북도</option>
										<option value="전라남도" <c:if test="${t.itemRegion eq '전라남도'}">selected</c:if>>전라남도</option>
										<option value="경상북도" <c:if test="${t.itemRegion eq '경상북도'}">selected</c:if>>경상북도</option>
										<option value="경상남도" <c:if test="${t.itemRegion eq '경상남도'}">selected</c:if>>경상남도</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<th class="center vertical">체형</th>
							<td>
								<div class="select-wrapper">
									<select name="bodyShape">
											<option value="">체형</option>
											<option value="선택안함" <c:if test="${t.itemRegion eq '선택안함'}">selected</c:if>>선택안함</option>
											<option value="작은 역삼각형" <c:if test="${t.itemRegion eq '작은 역삼각형'}">selected</c:if>>작은 역삼각형</option>
											<option value="큰삼각형" <c:if test="${t.itemRegion eq '큰삼각형'}">selected</c:if>>큰삼각형</option>
											<option value="역삼각형" <c:if test="${t.itemRegion eq '역삼각형'}">selected</c:if>>역삼각형</option>
											<option value="사각형" <c:if test="${t.itemRegion eq '사각형'}">selected</c:if>>사각형　　　　</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<th class="center vertical">첨부파일</th>
							<td>${t.img}　　<input type="file" name="files"></td>
						</tr>
						<tr>
							<th class="center vertical">내용</th>
							<td><textarea placeholder="" rows="6" name="content">${t.bContent}</textarea></td>
						</tr>
					</tbody>
				</table>

			<div class="btn center">
				<a href="/trade/list" class="button">취소</a>
				<input class="button special" id="compsize" type="submit" value="수정"/>
				
			</div>
			</form>
				
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

	<!-- popup 디자인 -->
	<div class="trade-popup"  style="position:fixed; display: none;">
		<div class="contents">
			<p>
				등록중입니다
			</p>
			
		</div>
	</div>
	<div class="trade-mask"  style="position:fixed; display: none;"></div>
		<!--//  popup 디자인 -->
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

	<script>
		$(function() {
			$("#compsize").click(function() {
				$(".trade-mask, .trade-popup").show();
			});

			$("#trade-popup-close").click(function() {
				$(".trade-mask, .trade-popup").fadeOut();
			});
		});
	</script> 
	
</body>
</html>
