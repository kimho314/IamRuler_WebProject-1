<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
									<h1>내가 작성한 글</h1>
									<jsp:include page="../inc/nav.jsp" />
								</header>
							<!-- Section -->
								<main class="mypageBoardList">
									<ul class="tab">
										<li class="active"><a href="#boardList">게시글</a></li>
										<li><a href="#cmtList">댓글보기</a></li>
									</ul>
											
											<c:set var="page" value="${(empty param.p)? 1 : param.p}"/>
											<c:if test="${empty param.t}">
												<c:set var="bpage" value="1"/>
												<c:set var="cpage" value="1"/>
											</c:if>
											<c:if test="${not empty param.t and param.t eq 'b'}">
												<c:set var="bpage" value="${page}"/>
												<c:set var="cpage" value="1"/>
											</c:if>
											<c:if test="${not empty param.t and param.t eq 'c'}">
												<c:set var="cpage" value="${page}"/>
												<c:set var="bpage" value="1"/>
											</c:if>
											<c:set var="startNum" value="${page - (page-1)%5}" />
											<c:set var="blastNum" value="${fn:substringBefore(Math.ceil(bListCount/8),'.')}"/>
											<c:set var="clastNum" value="${fn:substringBefore(Math.ceil(cListCount/8),'.')}"/>
											<%-- page: ${page}
											bpage: ${bpage}
											cpage: ${cpage}
											startNum: ${startNum}
											blastNum : ${blastNum}
											clastNum : ${clastNum} --%>
										<section class="boardList tab-content" id="boardList"> 
											<h1 class="hidden">내 게시글</h1>

											<div class="table-wrapper">
												<table>
													<caption class="hidden">게시글 목록</caption>
													<colgroup>
														<col style="width:20%"/>
														<col style="width:50%"/>
														<col style="width:20%"/>
														<col style="width:10%"/>
													</colgroup>
													<thead>
														<tr>
															<th>게시글 번호</th>
															<th>제목</th>
															<th>작성일</th>
															<th>조회수</th>
														</tr>
													</thead>
													<tbody>
													<c:if test="${empty boardList}">
														<td colspan="4">작성된 게시글이 없습니다.</td>
													</c:if>
													<c:if test="${not empty boardList}">
														<c:forEach var="b" items="${boardList}">	
															<tr>
																<td>${b.id}</td>
																<td>
																<a href="${(b.type eq 'C')? '/coordi/detail?id=':'/trade/detail?id='}${b.id}">${b.title}</a>	
																</td>
																<td>${b.regdate}</td>
																<td>${b.hit}</td>
															</tr>
														</c:forEach>
													</c:if>
													</tbody>
												</table>
											</div>
											<ul class="pagination">
												<c:choose>
													<c:when test="${startNum-1 <= 1}">
														<li><span class="disabled">< 이전</span></li>
													</c:when>
													<c:otherwise>
														<li><a href="?t=b&p=${startNum-1}"><span>이전</span></a></li>
													</c:otherwise>
												</c:choose>
												<c:forEach var="i" begin="0" end="4">
													<!-- 파라미터값 p와 index 값이 같을때 -->
														<c:if test="${bpage == (i+startNum)}">
															<c:set var="currentStyle" value="active"/>
														</c:if>
														<c:if test="${bpage != (i+startNum)}">
															<c:set var="currentStyle" value=""/>
														</c:if>
														<c:if test="${(i+startNum) <= blastNum}">
															<li><a class="page ${currentStyle}" href="?t=b&p=${startNum+i}">${startNum+i}</a></li>
														</c:if>												 	
												</c:forEach>
												<c:if test="${blastNum == 0}">
													<li><a class="page active" href="?t=b&p=1">1</a></li>
												</c:if>
												<c:if test="${(startNum+5) > blastNum}">
													<li><span class="disabled">다음 ></span></li>	
												</c:if>
												<c:if test="${(startNum+5) <= blastNum}">
													<li><a href="?t=b&p=${startNum+5}"><span>다음 ></span></a></li>	
												</c:if>
											</ul>
										</section>
										<section class="cmtList tab-content" id="cmtList" style="display:none">
											<h1 class="hidden">내 댓글</h1>
											<div class="table-wrapper">
												<table>
													<caption class="hidden">내가쓴 댓글 목록</caption>
													<colgroup>
														<col style="width:20%"/>
														<col style="width:60%"/>
														<col style="width:20%"/>
													</colgroup>
													<thead>
														<tr>
															<th>게시글 제목</th>
															<th>댓글</th>
															<th>작성일</th>
														</tr>
													</thead>
													<tbody>
														<c:if test="${empty cmtList}">
															<td colspan="3">작성된 댓글이 없습니다.</td>
														</c:if>
														<c:if test="${not empty cmtList}">
															<c:forEach var="c" items="${cmtList}">	
																<tr>
																	<td>${c.cId}</td>
																	<td>
																		<a href="${(c.type eq 'C')? '/coordi/detail?id=':'/trade/detail?id='}${c.cBId}#tradeCommentId">${c.cContent}</a>	
																	</td>
																	<td>${c.cRegdate}</td>
																</tr>
															</c:forEach>
														</c:if>														
													</tbody>
												</table>
											</div>
											<ul class="pagination">
												<c:choose>
													<c:when test="${startNum-1 <= 1}">
														<li><span class="disabled">< 이전</span></li>
													</c:when>
													<c:otherwise>
														<li><a href="?t=c&p=${startNum-1}"><span>이전</span></a></li>
													</c:otherwise>
												</c:choose>
												<c:forEach var="i" begin="0" end="4">
													<!-- 파라미터값 p와 index 값이 같을때 -->
														<c:if test="${cpage == (i+startNum)}">
															<c:set var="currentStyle" value="active"/>
														</c:if>
														<c:if test="${cpage != (i+startNum)}">
															<c:set var="currentStyle" value=""/>
														</c:if>
														<c:if test="${(i+startNum) <= clastNum}">
															<li><a class="page ${currentStyle}" href="?t=c&p=${startNum+i}">${startNum+i}</a></li>
														</c:if>												 
												</c:forEach>
												<c:if test="${clastNum == 0}">
													<li><a class="page active" href="?t=c&p=1">1</a></li>
												</c:if>
												<c:if test="${(startNum+5) > clastNum}">
													<li><span class="disabled">다음 ></span></li>	
												</c:if>
												<c:if test="${(startNum+5) <= clastNum}">
													<li><a href="?t=c&p=${startNum+5}"><span>다음 ></span></a></li>	
												</c:if>
											</ul>
										</section>
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
			<script>
				$(function(){
					//alert(getParameterByName('t'))
					if(getParameterByName('t') != null)
						load(getParameterByName('t'));
					function getParameterByName(name) {
					    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
					    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
					        results = regex.exec(location.search);
					    return results === null ? null : decodeURIComponent(results[1].replace(/\+/g, " "));
					}
					function load(type){
						var target=null;
						$(".tab li").removeClass("active");
						if(type == 'b')
							target=$(".tab li:first-child");
						if(type == 'c')
							target=$(".tab li:last-child");
						target.addClass("active");
						var activeTab =target.find("a").attr("href");
						$(".tab-content").hide();
						$(activeTab).show(); 
					}
					
					$(".tab li").click(function(){
						$(".tab li").removeClass("active");
						$(this).addClass("active");
						var activeTab = $(this).find("a").attr("href");
						//alert(activeTab);
						$(".tab-content").hide();
						$(activeTab).show(); 
					});
				});
			</script>
	</body>
</html>