<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>쇼핑 도우미 : 아임룰러</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="../assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../css/mypage.css" >
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
									<h1>마이페이지</h1>
									<jsp:include page="../inc/nav.jsp" />
								</header>
							
							<!-- Section -->
								<main class="mypageMain">
									<!-- <section class="info">회원정보 수정
										<h1>회원정보 수정</h1>
										<a href="#" class="button special">수정</a>
									</section> -->
									<div class="row">
										<section class="6u 12u$(small)">
											<h1>내가 작성한 글</h1>
											<section class="listBox">
												<h1>게시글</h1>
												<ul>
													<c:if test="${empty boardList}">
														<li class="none">게시글이 없습니다.</li>
													</c:if>
													<c:if test="${not empty boardList}">
														<c:forEach var="b" items="${boardList}" begin="0" end="5">
															<li><a href="${(b.type eq 'C')? '/coordi/post?cb_id=':'/trade/detail?id='}${b.id}">${b.title}</a></li>
														</c:forEach>
													</c:if>
												</ul>
											</section>
											<section class="listBox">
												<h1>댓글</h1>
												<ul>
													<c:if test="${empty cmtList}">
														<li class="none">게시글이 없습니다.</li>
													</c:if>
													<c:if test="${not empty cmtList}">
														<c:forEach var="c" items="${cmtList}" begin="0" end="5">
															<li><a href="${(c.type eq 'C')? '/coordi/post?cb_id=':'/trade/detail?id='}${c.cBId}">${c.cContent}</a></li>
														</c:forEach>
													</c:if>
												</ul>
											</section>
										</section>
										<section class="6u 12u$(small)">
											<h1>찜 목록</h1>
											<div class="slide">
												<div class="sliderkit slideshow-standard">
													<div class="sliderkit-nav">
														<div class="sliderkit-btn sliderkit-go-btn sliderkit-go-prev"><a href="#" title="Previous"><i class="fas fa-chevron-circle-left"></i><!-- <span>Previous</span> --></a></div>
														<div class="sliderkit-btn sliderkit-go-btn sliderkit-go-next"><a href="#" title="Next"><i class="fas fa-chevron-circle-right"></i><!-- <span>Next</span>--></a> </div>
													</div>
													<div class="sliderkit-panels">
													<c:if test="${empty zzimList}">
														<div class="sliderkit-panel nolist">
															찜 목록이 없습니다.
														</div>
													</c:if>
													<c:if test="${not empty zzimList}">
														<c:forEach var="z" items="${zzimList}">
															<div class="sliderkit-panel" onclick="location.href='/coordi/post?cb_id=${z.coordiId}'">
																<figuare><img src="${(empty z.img)? '/images/noimg.gif': z.img}" alt="#" /></figuare>
																<div class="con">
																	<div class="title">${z.title}</div>
																	<p>${z.memo}</p>
																</div>
															</div>
														</c:forEach>
													</c:if>
														<!-- <div class="sliderkit-panel">
															<figuare><img src="http://placehold.it/300x400" alt="#" /></figuare>
															<div class="con">
																<div class="title">타이틀이에용 호호호홓호호홓호</div>
																<p>메모영역입니다</p>
															</div>
														</div>
														<div class="sliderkit-panel">
															<figuare><img src="http://placehold.it/300x400" alt="#" /></figuare>
															<div class="con">
																<div class="title">타이틀이에용 호호호홓호호홓호</div>
																<p>메모영역입니다</p>
															</div>
														</div> -->
													</div>
												</div>		
											</div>
										</section>
									</div>
								</main>
						</div>
					</div>

				<jsp:include page="inc/aside.jsp" />

			</div>

		<!-- Scripts -->
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/skel.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="../assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../assets/js/main.js"></script>
			<script src="../js/jquery.sliderkit.1.9.2.pack.js"></script>
			<script src="../js/jquery.easing.1.3.min.js"></script>
			<script>
				$(function(){
					$(".slideshow-standard").sliderkit({
						auto:false,
						circular:true,
						fastchange:false,
						panelclick:true,
						panelfx:"sliding",
						panelfxspeed:1000,
						panelfxeasing:"easeInOutExpo"
					});
				});
			</script>
	</body>
</html>