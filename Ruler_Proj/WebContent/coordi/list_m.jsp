<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="listCount" value="${listCount }" />
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil((listCount)/10), '.')}" />

<!DOCTYPE HTML>
<html>

<head>
<title>쇼핑 도우미 : 아임룰러</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../css/seop.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<script src="https://kit.fontawesome.com/1af26a8adc.js"
	crossorigin="anonymous"></script>
</head>

<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
					<h1>체형별 코디 게시판</h1>
					<ul class="icons">
						<li><a href="sign/login.html">로그인</a></li>
						<li><a href="sign/sign-up.html">회원가입</a></li>
					</ul>
				</header>


				<!-- Banner  남자 -->
				<section id="banner">
					<div class="content">
						<div class="visual-wrapper">
							<div class="visual-top">
								<div class="visual-top-left">
									<a href="list_w?p=1" class="button small">여성</a> 
									<a href="list_m?p=${param.p }&g=${param.g}&b=${param.b}" class="button special small">남성</a>
								</div>
								<div class="visual-top-right">
									<a href="reg_post?g=${param.g}" class="button special small">글쓰기</a>
								</div>
							</div>

							<div class="visual-bottom-man">
								<div>
									<c:choose>
										<c:when test="${param.b eq '작은 역삼각' }">
											<a href="list_m?p=1&g=남성&b=작은 역삼각" class="button special">작은
												역삼각</a>
										</c:when>
										<c:otherwise>
											<a href="list_m?p=1&g=남성&b=작은 역삼각" class="button">작은 역삼각</a>
										</c:otherwise>
									</c:choose>									
								</div>
								<div>
									<c:choose>
										<c:when test="${param.b eq '큰 사각' }">
											<a href="list_m?p=1&g=남성&b=큰 사각" class="button special">큰 사각</a>
										</c:when>
										<c:otherwise>
											<a href="list_m?p=1&g=남성&b=큰 사각" class="button">큰 사각</a>
										</c:otherwise>
									</c:choose>									
								</div>
								<div>
									<c:choose>
										<c:when test="${param.b eq '사각' }">
											<a href="list_m?p=1&g=남성&b=사각" class="button special">사각</a>
										</c:when>
										<c:otherwise>
											<a href="list_m?p=1&g=남성&b=사각" class="button">사각</a>
										</c:otherwise>
									</c:choose>									
								</div>
							</div>
						</div>

						<div class="coordi-list-table-wrapper">
							<table class="coordi-list-table">
								<tr class="coordi-list-tr-wrapper">
									<c:forEach var="n" items="${list }" varStatus="status">
										<c:if test="${status.index >=0 && status.index < 5 }">
											<c:if test="${empty param.b }">
											<td>
												<li><a href="post?id=${n.cb_id }"><img
														src="../images/main_ico1.png" alt="coordi-img">
														<p>${n.co_bodyshape }</p> </a></li>
												<li>
													<c:if test="${n.dl_id == 0 }">
														<a href="reg_dibs?g=남성&m_id=${n.m_id }&cb_id=${n.cb_id}" class="button small">
														<i class="far fa-star"></i></a>
													</c:if>
													<c:if test="${n.dl_id > 0 }">
														<a href="reg_dibs?g=남성&m_id=${n.m_id }&cb_id=${n.cb_id}" class="button small">
														<i class="fas fa-star"></i></a>
													</c:if>
												</li>
											</td>
											</c:if>
											<c:if test="${not empty param.b }">
											<c:if test="${param.b eq n.co_bodyshape }">
											<td>
												<li><a href="post?id=${n.cb_id }"><img
														src="../images/main_ico1.png" alt="coordi-img">
														<p>${n.co_bodyshape }</p> </a></li>
												<li>
													<c:if test="${n.dl_id == 0 }">
														<a href="reg_dibs?g=남성&m_id=${n.m_id }&cb_id=${n.cb_id}" class="button small">
														<i class="far fa-star"></i></a>
													</c:if>
													<c:if test="${n.dl_id > 0 }">
														<a href="reg_dibs?g=남성&m_id=${n.m_id }&cb_id=${n.cb_id}" class="button small">
														<i class="fas fa-star"></i></a>
													</c:if>
												</li>
											</td>
											</c:if>
											</c:if>
										</c:if>
									</c:forEach>
								</tr>

								<tr class="coordi-list-tr-wrapper">
									<c:forEach var="n" items="${list }" varStatus="status">
										<c:if test="${status.index >=5 && status.index < 10 }">
											<c:if test="${empty param.b }">
											<td>
												<li><a href="post?id=${n.cb_id }"><img
														src="../images/main_ico1.png" alt="coordi-img">
														<p>${n.co_bodyshape }</p> </a></li>
												<li>
													<c:if test="${n.dl_id == 0 }">
														<a href="reg_dibs?g=남성&m_id=${n.m_id }&cb_id=${n.cb_id}" class="button small">
														<i class="far fa-star"></i></a>
													</c:if>
													<c:if test="${n.dl_id > 0 }">
														<a href="reg_dibs?g=남성&m_id=${n.m_id }&cb_id=${n.cb_id}" class="button small">
														<i class="fas fa-star"></i></a>
													</c:if>
												</li>
											</td>
											</c:if>
											<c:if test="${not empty param.b }">
											<c:if test="${param.b eq n.co_bodyshape }">
											<td>
												<li><a href="post?id=${n.cb_id }"><img
														src="../images/main_ico1.png" alt="coordi-img">
														<p>${n.co_bodyshape }</p> </a></li>
												<li>
													<c:if test="${n.dl_id == 0 }">
														<a href="reg_dibs?g=남성&m_id=${n.m_id }&cb_id=${n.cb_id}" class="button small">
														<i class="far fa-star"></i></a>
													</c:if>
													<c:if test="${n.dl_id > 0 }">
														<a href="reg_dibs?g=남성&m_id=${n.m_id }&cb_id=${n.cb_id}" class="button small">
														<i class="fas fa-star"></i></a>
													</c:if>
												</li>
											</td>
											</c:if>
											</c:if>
										</c:if>
									</c:forEach>
								</tr>
							</table>
						</div>
						
						<c:set var="page" value="${(empty param.p)?1:param.p }" />
						<c:if test="${page <= 5 }">
							<c:set var="startNum" value="1" />
						</c:if>
						<c:if test="${page > 5 }">
							<c:set var="startNum" value="${page - 4 }" />
						</c:if>
						
						<ul class="coordi-list-page ">
							<li>
								<c:choose>
									<c:when test="${startNum <= 1 }">
										<a href="" class="button disabled">Prev</a>
									</c:when>
									<c:otherwise>
										<a href="list_m?p=${startNum-5 }&g=${param.g}&b=${param.b}" class="button">Prev</a>
									</c:otherwise>
								</c:choose>		
							</li>
							
							<c:forEach var="i" begin="${startNum }" end="${(startNum+4 >= lastNum)?lastNum:(startNum+4) }">
								<c:choose>
									<c:when test="${param.p == i }">
										<li><a href="list_m?p=${i }&g=${param.g}&b=${param.b}" class="page active">${i }</a></li>
									</c:when>									
									<c:otherwise>
										<li><a href="list_m?p=${i }&g=${param.g}&b=${param.b}" class="page">${i }</a></li>
									</c:otherwise>
								</c:choose>								
							</c:forEach>
							
							<li>
								<c:choose>
									<c:when test="${startNum+4 >= lastNum }">
										<a href=""  class="button disabled">Next</a>
									</c:when>
									<c:otherwise>
										<a href="list_m?p=${startNum+5 }&g=${param.g}&b=${param.b}"  class="button">Next</a>
									</c:otherwise>
								</c:choose>	
							</li>
						</ul>
					</div>
				</section>
			</div>
		</div>

		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">
				<!-- Menu -->
				<nav id="menu">
					<h1 class="logo">
						<a href="index.html"><img src="../images/logo.png" alt="아임룰러" /></a>
					</h1>
					<h2 class="hidden">메인 메뉴</h2>
					<ul>
						<li><a href="index.html">사이즈 비교</a></li>
						<li><a href="coordi/coordi_list_main.html">체형 별 코디</a></li>
						<li><a href="#.html">교환 게시판</a></li>
						<li><a href="#.html">쇼핑몰 랭킹</a></li>
					</ul>

					<!-- <h2 class="hidden">마이페이지 메뉴</h2>
							<ul>
								<li><a href="mypage/member-edit.html">회원정보 수정</a></li>
								<li><a href="mypage/reg.html">회원 탈퇴</a></li>
								<li><a href="mypage/#.html">내가 작성한 글</a></li>
								<li><a href="mypage/#.html">찜 목록</a></li>
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
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="../assets/js/main.js"></script>

</body>

</html>