<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8
      ]><script src="assets/js/ie/html5shiv.js"></script
    ><![endif]-->
<link rel="stylesheet" href="../css/sign.css" />
<!--[if lte IE 9
      ]><link rel="stylesheet" href="assets/css/ie9.css"
    /><![endif]-->
<!--[if lte IE 8
      ]><link rel="stylesheet" href="assets/css/ie8.css"
    /><![endif]-->
<!-- <link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" /> -->
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<header id="header">
					<h1 class="로그인헤더">로그인</h1>
					<ul class="헤더메뉴">
						<li><a href="login" class="로그인"> <span class="헤더메뉴">로그인</span>
						</a></li>
						<li><a href="sign-up" class="회원가입"> <span
								class="헤더메뉴">회원가입</span>
						</a></li>
					</ul>
				</header>
				<div id="로그인테이블">
					<span class="로그인텍스트바">
						<form method="POST">
							<p>로그인</p>
							<section class="로그인텍스트바">
								<label>아이디</label> <input type="text" name="아이디" id="아이디" /><br />
								<label>비밀번호</label> <input type="password" name="비밀번호" id="비밀번호" />
							</section>
							<c:if test="${param.error ==1}">
								<br>
								<span class="오류"> 아이디나 비밀번호가 틀렸습니다. </span>
							</c:if>

							<section>
								<span id="확인버튼"><br> <input type="submit"
									class="button special" value="로그인"> </span>
							</section>
						</form>
					</span>
					<!-- 구분선 -->
					<span class="로그인페이지버튼">
						<section class="비밀번호찾기">
							<label> - 아직 회원이 아니라면? </label> <a href="agree"> <label
								class="button special"> 회원가입 > </label>
							</a> <label> - 아이디/비밀번호가 기억나지 않는다면? </label> <a href="find">
								<label class="button special"> 아이디 / 비밀번호 찾기 > </label>
							</a>
						</section>
					</span>
				</div>
			</div>
		</div>

		<div id="sidebar">
			<div class="inner">
				<!-- Menu -->
				<nav id="menu">
					<h1 class="logo">
						<a href="index"><img src="../images/logo.png" alt="아임룰러" /></a>
					</h1>
					<h2 class="hidden">메인 메뉴</h2>
					<ul>
						<li><a href="index">사이즈 비교</a></li>
						<li><a href="coordi/coordi_list_main">체형 별 코디</a></li>
						<li><a href="#">교환 게시판</a></li>
						<li><a href="#">쇼핑몰 랭킹</a></li>
					</ul>

					<!-- <h2 class="hidden">마이페이지 메뉴</h2>
              <ul>
                <li><a href="mypage/member-edit">회원정보 수정</a></li>
                <li><a href="mypage/reg">회원 탈퇴</a></li>
                <li><a href="mypage/#">내가 작성한 글</a></li>
                <li><a href="mypage/#">찜 목록</a></li>
              </ul> -->
				</nav>

				<!-- Section -->
				<section>
					<header class="major">
						<!-- <h2>Get in touch</h2> -->
					</header>
					<p>I’M RULER 는 상품에 직접 관여하지 않으며 상품 주문, 배송 및 환불의 의무와 책임은 각 판매업체에
						있습니다.</p>
					<ul class="contact">
						<!-- <li class="fa-home"><a href="#">I'M RULER</a></li> -->
						<li class="fa-phone">(02) 123-4567</li>
						<li class="fa-envelope-o">admin@imruler.com</li>
					</ul>
				</section>

				<!-- Footer -->
				<footer id="footer">
					<p class="copyright">&copy; imruler.com 2019-2021 All Right
						Reserved. Contact admin@imruler.com for more information.
				</footer>

			</div>
		</div>
	</div>
	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/skel.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<!--[if lte IE 8]>
      <script src="assets/js/ie/respond.min.js"></script>
    <![endif]-->
	<script src="../assets/js/main.js"></script>
</body>
</html>
