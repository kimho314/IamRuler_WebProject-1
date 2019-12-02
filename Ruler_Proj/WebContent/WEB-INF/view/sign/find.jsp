<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>아이디/비밀번호 찾기</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]>
      <script src="assets/js/ie/html5shiv.js"></script>
    <![endif]-->
<link rel="stylesheet" href="../css/sign.css" />
<!--[if lte IE 9]>
      <link rel="stylesheet" href="assets/css/ie9.css" />
    <![endif]-->
<!--[if lte IE 8]>
      <link rel="stylesheet" href="assets/css/ie8.css" />
    <![endif]-->
<!-- <link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" /> -->
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<header id="header">
					<h1 class="아이디비밀번호찾기">아이디/비밀번호 찾기</h1>
					<jsp:include page="../inc/nav.jsp" />
				</header>
				<div id="찾기테이블">
					<span class="아이디찾기">
						<p>아이디 찾기</p>
						<section class="아이디찾기">
							<form method="POST">
								<label>이메일</label> <input type="text" name="email" id="이메일" />
							</form>
						</section>

						<section>
							<span id="확인버튼"> <label class="button special"
								for="아이디-pop">확인</label>
							</span>
						</section>
					</span>
					<!-- 구분선 -->
					<span class="비밀번호찾기">
						<p>비밀번호 찾기</p>
						<section class="비밀번호찾기">
							<form method="POST">
								<label>아이디</label> <input type="text" name="phone" id="아이디" /><br />
								<label>핸드폰</label> <input type="text" name="phone" id="핸드폰" />
							</form>
						</section>

						<section>
							<span id="확인버튼"> <label class="button special"
								for="비밀번호-pop">확인</label>
							</span>
						</section>
					</span>
				</div>
			</div>
		</div>


		<jsp:include page="../inc/aside.jsp" />

		<div>
			<input class="modal-state" id="아이디-pop" type="checkbox" />
			<div class="팝업">
				<div class="contents">
					<h2 class="title">아이디</h2>
					<p>아이디가 뜰곳</p>
					<br />
					<p id="회원가입성공버튼">
						<a href="find" class="button special">확인</a>
					</p>
				</div>
			</div>
			<input class="modal-state" id="비밀번호-pop" type="checkbox" />
			<div class="팝업">
				<div class="contents">
					<h2 class="title">비밀번호</h2>
					<p>비밀번호가 뜰곳</p>
					<br />
					<p id="회원가입성공버튼">
						<a href="find" class="button special">확인</a>
					</p>
				</div>
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
