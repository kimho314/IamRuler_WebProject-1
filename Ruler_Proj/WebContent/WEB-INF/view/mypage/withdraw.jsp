<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>쇼핑 도우미 : 아임룰러</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="../assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../css/sign.css" >
		<!--[if lte IE 9]><link rel="stylesheet" href="../assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="../assets/css/ie8.css" /><![endif]-->
		<link rel="stylesheet" type="text/css" href="../css/sliderkit-core.css" media="screen, projection" />
		<script src="https://kit.fontawesome.com/1af26a8adc.js" crossorigin="anonymous"></script>
		
	</head>
	<body>

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Main -->
					<div id="main">
						<div class="inner">
							<!-- Header -->
								<header id="header">
									<jsp:include page="../inc/nav.jsp" />
								</header>
							<!-- Section -->
								<main class="mypageReg">
								 <section>
						            <form method="POST">
						            	<!-- 회원 탈퇴시 -->
						            	<h1>
						            		회원 탈퇴 시 다시 복구할 수 없습니다.<br>
											탈퇴 하시겠습니까?<br>
											진행하시려면 비밀번호를 한번 더 입력해 주세요.
						            	</h1>
						            	<input type="password" />
						            	<div class="btn_area">
						            		<a href="javascript:history.back();" class="button">취소</a> <input type="submit" value="확인" class="button special">						            		
						            	</div> 						            
						            </form>
						          </section>
								</main>
						</div>
					</div>
				<jsp:include page="inc/aside.jsp" />

			</div>
			<!-- <div id="glayer" class="popup">
				<div class="contents">
					<p>정상적으로 반영되었습니다.</p>
					<div class="btn">
						<a href="#" class="button close">닫기</a>
					</div>
				</div>
			</div> -->
			<div id="elayer" class="popup">
				<div class="contents">
					<p>비밀번호를 잘못 입력하셨습니다.<br>
						다시 입력해 주세요.
					</p>
					<div class="btn">
						<a href="#" class="button close">닫기</a>
					</div>
				</div>
			</div>
			<div class="mask"></div>
		<!-- Scripts -->
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/skel.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="../assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../assets/js/main.js"></script>
	</body>
</html>