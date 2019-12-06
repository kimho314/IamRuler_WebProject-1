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
					<jsp:include page="../inc/nav.jsp" />
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
															<c:if test="${isWriter == 0 && n.m_userName != userName}">
																<span>*****</span>
															</c:if>		
															
															<c:if test="${not empty n.m_userName }">													
															<c:if test="${n.m_userName == userName}">
																<span>${n.m_userName }</span>
															</c:if>
															<c:if test="${isWriter == 1 && userName != n.m_userName }">
																<span>${n.m_userName }</span>
															</c:if>
															</c:if>															
														</c:if>
														
														<c:if test="${n.ccmt_openStat != 1 }">
															<c:if test="${not empty n.m_userName }">
															<span>${n.m_userName }</span>
															</c:if>
															<c:if test="${empty n.m_userName }">
															<span>[탈퇴 회원]</span>
															</c:if>
														</c:if>														
													</li>
													<li>														
														<span>${n.ccmt_regdate }</span>
													</li>
												</ul>
											</div>
											<div class="coordi-comment-top-right">
												<c:if test="${not empty  n.m_userName }">
												<c:if test="${n.m_userName eq userName }">
												<ul>
													<li>
														<a href="comment?cb_id=${param.cb_id }&id=${(empty n.ccmt_id)?0:n.ccmt_id }&user_id=${(empty n.ccmt_userId)?0:n.ccmt_userId}&opt=1">수정</a>
													</li>
													<li>
														<a href="comment?cb_id=${param.cb_id }&id=${(empty n.ccmt_id)?0:n.ccmt_id }&user_id=${(empty n.ccmt_userId)?0:n.ccmt_userId}&opt=2">삭제</a>
													</li>
												</ul>
												</c:if>
												</c:if>
											</div>
										</div>
										<div class="coordi-comment-bottom">											
											<c:if test="${n.ccmt_openStat == 1 }">																							
												<c:if test="${isWriter == 0 && (userName != n.m_userName || empty  n.m_userName) }">
													<p>비밀 댓글입니다.</p>
												</c:if>		
												<c:if test="${not empty  n.m_userName }">										
												<c:if test="${userName == n.m_userName }">
													<p>${n.ccmt_content }</p>
												</c:if>
												<c:if test="${isWriter == 1 && userName != n.m_userName }">
													<p>${n.ccmt_content }</p>
												</c:if>												
												</c:if>
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
													<input type="checkbox" id="demo-human" name="demo-human"
														checked="">
													<label for="demo-human">비공개</label>
												</c:if>
											</c:if> 
											<c:if test="${opt != 1 }">
												<input type="checkbox" id="demo-copy" name="demo-copy">
												<label for="demo-copy">비공개</label>											
											</c:if> 
											
											<input type="hidden" name="cmtId-text" value="${cmt.id }">
											<input type="hidden" name="boardId-text" value="${param.cb_id }"> 											
											<input type="hidden" name="opt-text" value="${param.opt }">
										</li>
									</ul>
								</div>
								<div class="coordi-comment-content">
									<div class="coordi-comment-content-left">
										<c:if test="${param.opt == 1 }">
											<textarea name="demo-message" id="demo-message"
												placeholder="댓글을 입력해주세요" rows="6">${cmt.content }</textarea>
										</c:if>
										<c:if test="${param.opt != 1 }">
											<textarea name="demo-message" id="demo-message"
												placeholder="댓글을 입력해주세요" rows="6"></textarea>
										</c:if>

									</div>
									<div class="coordi-comment-content-right">
										<c:if test="${empty userName }">
											<input type="submit" value="댓글 등록" class="special disabled">
										</c:if>
										<c:if test="${not empty userName }">
											<input type="submit" value="댓글 등록" class="special">
										</c:if>
									</div>
								</div>

							</div>
						</form>
					</div>

				</section>
			</div>
		</div>


		<!-- Sidebar -->
		<jsp:include page="../inc/aside.jsp" />		

	</div>

	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/skel.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="../assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="../assets/js/main.js"></script>

</body>

</html>