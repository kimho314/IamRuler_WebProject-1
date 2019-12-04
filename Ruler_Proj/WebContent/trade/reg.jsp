
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>





    
<!DOCTYPE html>
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

				<!-- Banner -->
				<!-- <section id="banner">
									<div class="content">
										<header>
											<h1>Hi, I’m Editorial<br />
											by HTML5 UP</h1>
											<p>A free and fully responsive site template</p>
										</header>
										<p>Aenean ornare velit lacus, ac varius enim ullamcorper eu. Proin aliquam facilisis ante interdum congue. Integer mollis, nisl amet convallis, porttitor magna ullamcorper, amet egestas mauris. Ut magna finibus nisi nec lacinia. Nam maximus erat id euismod egestas. Pellentesque sapien ac quam. Lorem ipsum dolor sit nullam.</p>
										<ul class="actions">
											<li><a href="#" class="button big">Learn More</a></li>
										</ul>
									</div>
									<span class="image object">
										<img src="images/pic10.jpg" alt="" />
									</span>
								</section> -->
				<input type="hidden" name="boardId" value=""/>
				<form action="" method="post" enctype="multipart/form-data">
				<br>
				<table class="default">
					<tbody>
						<tr>
							<th class="center vertical">제목</th>
							<td><input type="text" name="title" value=""></td>
						</tr>
						 <tr>
							<th class="center">작성자</th>
							<td>${UserName}</td>
						</tr> 
						<tr>
							<th class="center">등록일자</th>
							<td><%= sf.format(nowTime) %></td>
						</tr>
						<tr>
							<th class="center vertical">의류</th>
							<td>
								<div class="select-wrapper">
									<select name="category">
										<option value="" selected>옷 종류</option>
										<option value="상의">상의</option>
										<option value="하의">하의</option>
										<option value="아우터">아우터</option>
										<option value="치마">치마</option>
										<option value="원피스">원피스　　　　</option>
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
											<option value="선택안함">선택안함</option>
											<option value="역삼각형">작은 역삼각형</option>
											<option value="큰삼각형">큰삼각형</option>
											<option value="역삼각형">역삼각형</option>
											<option value="사각형">사각형　　　　</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<th class="center vertical">첨부파일</th>
							<td><input type="file" name="files"></td>
						</tr>
						<!-- <tr>
							<th class="center vertical">태그</th>
							<td><input type="text" name="tag"></td>
						</tr> -->
						<tr>
							<th class="center vertical">내용</th>
							<td><textarea placeholder="내용을 입력하세요" rows="6" name="content"></textarea></td>
						</tr>
					</tbody>
				</table>

				<div class="btn center">
					<a href="/trade/list" class="button">취소</a> 
					<input class="button special" id="compsize" type="submit" value="등록" />
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
				정상적으로 등록되었습니다
			</p>
			<div class="btn">
				<!-- <a href="#" class="button special">로그인</a> -->
				<a href="#" id=trade-popup-close class="button close">닫기</a>
			</div>
		</div>
	</div>
	<div class="trade-mask"  style="position:fixed; display: none;"></div>
	<!--//  popup 디자인 -->
	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/skel.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="../assets/js/main.js"></script>

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