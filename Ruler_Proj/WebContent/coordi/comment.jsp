<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


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

				<!-- Banner  -->
				<section id="banner" style="padding-top: 1em;">
					<div class="content">
						<div class="visual-wrapper">
							<div class="visual-top-coordi-comment">
								<div class="visual-top-left">
									<a href="post?cb_id=${param.cb_id }" class="button special small">
									본문	보기</a>
								</div>
								<div class="visual-top-right"></div>
							</div>

							<div class="visual-bottom"></div>
						</div>

						<div class="coordi-comment-list-wrapper box scroll-y">
							<ul>
								<c:forEach var="n" items="${cmtList }" varStatus="status">
									<li class="coordi-comment-outer-list box">
										<div class="coordi-comment-top">
											<div class="coordi-comment-top-left">
												<ul>
													<li>
														<c:if test="${n.ccmt_openStat == 1 }">
															<span><i class="fas fa-lock"></i></span>
														</c:if>
														<span>${n.m_userName }</span>														
													</li>
													<li>														
														<span>${n.ccmt_regdate }</span>
													</li>
												</ul>
											</div>
											<div class="coordi-comment-top-right">
												<ul>
													<li>
														<a href="comment?cb_id=${param.cb_id }&id=${(empty n.ccmt_id)?0:n.ccmt_id }&user_id=${(empty n.ccmt_userId)?0:n.ccmt_userId}&opt=1">수정</a>
													</li>
													<li>
														<a href="comment?cb_id=${param.cb_id }&id=${(empty n.ccmt_id)?0:n.ccmt_id }&user_id=${(empty n.ccmt_userId)?0:n.ccmt_userId}&opt=2">삭제</a>
													</li>
												</ul>
											</div>
										</div>
										<div class="coordi-comment-bottom">
											<c:if test="${n.ccmt_openStat == 1 }">
												<p>비밀 댓글입니다.</p>
											</c:if>
											<c:if test="${n.ccmt_openStat != 1 }">
												<p>${n.ccmt_content }</p>
											</c:if>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>

						<form action="comment" method="post">
							<div class="coordi-comment-reg-wrapper box">
								<div class="coordi-comment-reg-icons">
									<ul>
										<li>댓글 작성</li>
										<li>
											<c:if test="${opt == 1 }">
												<c:if test="${cmt.openStat != 1 }">
													<input type="checkbox" id="demo-copy" name="demo-copy">
													<label for="demo-copy">비공개</label>
												</c:if>
												<c:if test="${cmt.openStat == 1 }">
												<input type="checkbox" id="demo-human" name="demo-human" checked="">
												 <label for="demo-human">비공개</label>
												</c:if>
											</c:if> 
											<c:if test="${opt != 1 }">
												<input type="checkbox" id="demo-copy" name="demo-copy">
												<label for="demo-copy">비공개</label>											
											</c:if> 
											
											<input type="hidden" name="cmtId-text" value="${cmt.id }">
											<input type="hidden" name="boardId-text" value="${param.cb_id }"> 
											<input type="hidden" name="userId-text" value="${param.user_id }"> 
											<input type="hidden" name="opt-text" value="${param.opt }">

										</li>
									</ul>
								</div>
								<div class="coordi-comment-content">
									<div class="coordi-comment-content-left">
										<c:if test="${param.opt == 1 }">
											<textarea name="demo-message" id="demo-message"
												placeholder="댓글을 입력해주세요" rows="6">${cmt.content }										
										</textarea>
										</c:if>
										<c:if test="${param.opt != 1 }">
											<textarea name="demo-message" id="demo-message"
												placeholder="댓글을 입력해주세요" rows="6">
										</textarea>
										</c:if>

									</div>
									<div class="coordi-comment-content-right">
										<input type="submit" value="댓글 등록" class="special">
									</div>
								</div>

							</div>
						</form>
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
	<!--[if lte IE 8]><script src="../assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="../assets/js/main.js"></script>

</body>

</html>