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
					<jsp:include page="../inc/nav.jsp" />
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
									<c:if test="${not empty userName }">
									<a href="reg_post?g=${param.g}" class="button special small">글쓰기</a>
									</c:if>
								</div>
							</div>

							<div class="visual-bottom-man">
								<div>
									<c:choose>
										<c:when test="${param.b eq '보통' }">
											<a href="list_m?p=1&g=남성&b=보통" class="button special">보통</a>
										</c:when>
										<c:otherwise>
											<a href="list_m?p=1&g=남성&b=보통" class="button">보통</a>
										</c:otherwise>
									</c:choose>									
								</div>
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
										<c:when test="${param.b eq '삼각' }">
											<a href="list_m?p=1&g=남성&b=삼각" class="button special">삼각</a>
										</c:when>
										<c:otherwise>
											<a href="list_m?p=1&g=남성&b=삼각" class="button">삼각</a>
										</c:otherwise>
									</c:choose>									
								</div>
								<div>
									<c:choose>
										<c:when test="${param.b eq '역삼각' }">
											<a href="list_m?p=1&g=남성&b=역삼각" class="button special">역삼각</a>
										</c:when>
										<c:otherwise>
											<a href="list_m?p=1&g=남성&b=역삼각" class="button">역삼각</a>
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
								<colgroup width="20%"></colgroup>
								<colgroup width="20%"></colgroup>
								<colgroup width="20%"></colgroup>
								<colgroup width="20%"></colgroup>
								<colgroup width="20%"></colgroup>
								
								<tr class="coordi-list-tr-wrapper">
									<c:forEach var="n" items="${list }" varStatus="status">
										<c:if test="${status.index >=0 && status.index < 5 }">
											<c:if test="${empty param.b }">
											<td>
												<li><a href="post?cb_id=${n.cb_id }"><img
														src="../..${n.ci_img }" alt="coordi-img">
														<%-- <p>${n.co_bodyshape }</p>  --%></a>
												</li>
												<li><p>${n.co_bodyshape }</p></li>
												<li>
													<c:if test="${not empty userName}">
														<c:set var="DibFlag" value="0"/>
														<c:forEach var="dNum" items="${dibsList }">
														<c:if test="${ dNum.coordiId != n.cb_id}">	
														</c:if>
														<c:if test="${ dNum.coordiId == n.cb_id }">
															<c:set var="DibFlag" value="1"/>														
														</c:if>
														</c:forEach>
														
														<c:if test="${DibFlag == 0}">
															<c:if test="${not empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}&b=${n.co_bodyshape}" class="button small">
															<i class="far fa-star"></i></a>
															</c:if>
															<c:if test="${empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}" class="button small">
															<i class="far fa-star"></i></a>
															</c:if>
														</c:if>
														<c:if test="${DibFlag == 1}">
															<c:if test="${not empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}&b=${n.co_bodyshape}" class="button small">
															<i class="fas fa-star"></i></a>
															</c:if>
															<c:if test="${empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}" class="button small">
															<i class="fas fa-star"></i></a>
															</c:if>
														</c:if>
													</c:if>
												</li>
											</td>
											</c:if>
											<c:if test="${not empty param.b }">
											<c:if test="${param.b eq n.co_bodyshape }">
											<td>
												<li><a href="post?cb_id=${n.cb_id }"><img
														src="../..${n.ci_img }" alt="coordi-img">
														<%-- <p>${n.co_bodyshape }</p>  --%></a>
												</li>
												<li><p>${n.co_bodyshape }</p></li>
												<li>
													<c:if test="${not empty userName}">
														<c:set var="DibFlag" value="0"/>
														<c:forEach var="dNum" items="${dibsList }">
														<c:if test="${ dNum.coordiId != n.cb_id}">	
														</c:if>
														<c:if test="${ dNum.coordiId == n.cb_id }">
															<c:set var="DibFlag" value="1"/>														
														</c:if>
														</c:forEach>
														
														<c:if test="${DibFlag == 0}">
															<c:if test="${not empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}&b=${n.co_bodyshape}" class="button small">
															<i class="far fa-star"></i></a>
															</c:if>
															<c:if test="${empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}" class="button small">
															<i class="far fa-star"></i></a>
															</c:if>
														</c:if>
														<c:if test="${DibFlag == 1}">
															<c:if test="${not empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}&b=${n.co_bodyshape}" class="button small">
															<i class="fas fa-star"></i></a>
															</c:if>
															<c:if test="${empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}" class="button small">
															<i class="fas fa-star"></i></a>
															</c:if>
														</c:if>
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
												<li><a href="post?cb_id=${n.cb_id }"><img
														src="../..${n.ci_img }" alt="coordi-img">
														<%-- <p>${n.co_bodyshape }</p>  --%></a>
												</li>
												<li><p>${n.co_bodyshape }</p></li>
												<li>
													<c:if test="${not empty userName}">
														<c:set var="DibFlag" value="0"/>
														<c:forEach var="dNum" items="${dibsList }">
														<c:if test="${ dNum.coordiId != n.cb_id}">	
														</c:if>
														<c:if test="${ dNum.coordiId == n.cb_id }">
															<c:set var="DibFlag" value="1"/>														
														</c:if>
														</c:forEach>
														
														<c:if test="${DibFlag == 0}">
															<c:if test="${not empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}&b=${n.co_bodyshape}" class="button small">
															<i class="far fa-star"></i></a>
															</c:if>
															<c:if test="${empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}" class="button small">
															<i class="far fa-star"></i></a>
															</c:if>
														</c:if>
														<c:if test="${DibFlag == 1}">
															<c:if test="${not empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}&b=${n.co_bodyshape}" class="button small">
															<i class="fas fa-star"></i></a>
															</c:if>
															<c:if test="${empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}" class="button small">
															<i class="fas fa-star"></i></a>
															</c:if>
														</c:if>
													</c:if>
												</li>
											</td>
											</c:if>
											<c:if test="${not empty param.b }">
											<c:if test="${param.b eq n.co_bodyshape }">
											<td>
												<li><a href="post?cb_id=${n.cb_id }"><img
														src="../..${n.ci_img }" alt="coordi-img">
														<%-- <p>${n.co_bodyshape }</p>  --%></a>
												</li>
												<li><p>${n.co_bodyshape }</p></li>
												<li>
													<c:if test="${not empty userName}">
														<c:set var="DibFlag" value="0"/>
														<c:forEach var="dNum" items="${dibsList }">
														<c:if test="${ dNum.coordiId != n.cb_id}">	
														</c:if>
														<c:if test="${ dNum.coordiId == n.cb_id }">
															<c:set var="DibFlag" value="1"/>														
														</c:if>
														</c:forEach>
														
														<c:if test="${DibFlag == 0}">
															<c:if test="${not empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}&b=${n.co_bodyshape}" class="button small">
															<i class="far fa-star"></i></a>
															</c:if>
															<c:if test="${empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}" class="button small">
															<i class="far fa-star"></i></a>
															</c:if>
														</c:if>
														<c:if test="${DibFlag == 1}">
															<c:if test="${not empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}&b=${n.co_bodyshape}" class="button small">
															<i class="fas fa-star"></i></a>
															</c:if>
															<c:if test="${empty param.b }">
															<a href="reg_dibs?g=남성&m_name=${userName }&cb_id=${n.cb_id}" class="button small">
															<i class="fas fa-star"></i></a>
															</c:if>
														</c:if>
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
		<jsp:include page="../inc/aside.jsp" />	

	</div>

	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/skel.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="../assets/js/main.js"></script>

</body>

</html>