<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>쇼핑 도우미 : 아임룰러</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="../assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../css/ranking.css" >
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
									<h1>쇼핑몰 랭킹</h1>
									<jsp:include page="../inc/nav.jsp" />
								</header>
							<!-- Section -->
								<main class="rankingList">
									<nav>
										<h1 class="hidden">성별 선택 메뉴</h1>
											<ul class="genderMenu">
												<li>
													<div class="4u 12u$(small)">
														<input type="radio" id="rank-gender-man" name="gender" value="man" >
														<label for="rank-gender-man">남성쇼핑몰</label>
													</div>
												</li>
												<li>
													<div class="4u 12u$(small)">
														<input type="radio" id="rank-gender-woman" name="gender" value="woman" >
														<label for="rank-gender-woman">여성쇼핑몰</label>
													</div>
												</li>
											</ul>
									</nav>
									<div id="rank-list">
									<c:forEach var ="og" items="${oglist}">
										<img src="${og.sitetxt}" alt="" />
									</c:forEach>	
									<ul class="list best">
									 	<c:forEach var ="r" items="${list}" begin="0" end="2" varStatus="status">
										<li>
											<figuare>
												<a href="${r.url}" target="_blank"><img src="${r.img}" alt="#"></a>
												<figcaption><a href="${r.url}" target="_blank">${r.mall_name}</a></figcaption>
											</figuare>
											<span class="fas fa-medal fa-5x"></span>
											<span class="icon">${status.count}위</span>
										</li>
										</c:forEach>
										<!-- <li>
											<figuare>
												<a href="#" target="_blank"><img src="http://placehold.it/200x200" alt="#"></a>
												<figcaption><a href="#" target="_blank">쇼핑몰1</a></figcaption>
											</figuare>
											<span class="fas fa-medal fa-5x"></span>
											<span class="icon">2위</span>
										</li>
										<li>
											<figuare>
												<a href="#" target="_blank"><img src="http://placehold.it/200x200" alt="#"></a>
												<figcaption><a href="#" target="_blank">쇼핑몰1</a></figcaption>
											</figuare>
											<span class="fas fa-medal fa-5x"></span>
											<span class="icon">3위</span>
										</li> -->
									</ul>
									<ul class="list">
									<c:forEach var ="r" items="${list}" begin="3" end="10" varStatus="status">
										<li data-hit="0">
											<figuare>
												<a href="${r.url}" target="_blank"><img src="${r.img}" alt="#"></a>
												<figcaption><a href="${r.url}" target="_blank">${r.mall_name}</a></figcaption>
											</figuare>
											<i class="far fa-certificate fa-3x"></i>
											<span class="icon">${status.index + 1}위</span>
										</li>
									</c:forEach>
										<!-- <li>
											<figuare>
												<a href="#" target="_blank"><img src="http://placehold.it/200x200" alt="#"></a>
												<figcaption><a href="#" target="_blank">쇼핑몰1</a></figcaption>
											</figuare>
											<i class="far fa-certificate fa-3x"></i>
											<i class="far fa-circle fa-3x"></i>
											<span class="icon">5위</span>
										</li>
										<li>
											<figuare>
												<a href="#" target="_blank"><img src="http://placehold.it/200x200" alt="#"></a>
												<figcaption><a href="#" target="_blank">쇼핑몰1</a></figcaption>
											</figuare>
											<i class="far fa-certificate fa-3x"></i>
											<span class="icon">6위</span>
										</li>
										<li>
											<figuare>
												<a href="#" target="_blank"><img src="http://placehold.it/200x200" alt="#"></a>
												<figcaption><a href="#" target="_blank">쇼핑몰1</a></figcaption>
											</figuare>
											<i class="far fa-certificate fa-3x"></i>
											<span class="icon">7위</span>
										</li>
										<li>
											<figuare>
												<a href="#" target="_blank"><img src="http://placehold.it/200x200" alt="#"></a>
												<figcaption><a href="#" target="_blank">쇼핑몰1</a></figcaption>
											</figuare>
											<i class="far fa-certificate fa-3x"></i>
											<span class="icon">8위</span>
										</li>
										<li>
											<figuare>
												<a href="#" target="_blank"><img src="http://placehold.it/200x200" alt="#"></a>
												<figcaption><a href="#" target="_blank">쇼핑몰1</a></figcaption>
											</figuare>
											<i class="far fa-certificate fa-3x"></i>
											<span class="icon">9위</span>
										</li>
										<li>
											<figuare>
												<a href="#" target="_blank"><img src="http://placehold.it/200x200" alt="#"> </a>
												<figcaption><a href="#" target="_blank">쇼핑몰1</a></figcaption>
											</figuare>
											<i class="far fa-certificate fa-3x"></i>
											<span class="icon">10위</span>
										</li> -->
										
									</ul>
									</div>
								</main>
						</div>
					</div>
				<jsp:include page="../inc/aside.jsp" />
			</div>

		<!-- Scripts -->
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/skel.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="../assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../assets/js/main.js"></script>
			<!-- <script>
				$(function(){
					$(".genderMenu li input").click(function(){
						$(".genderMenu li input").prop("checked","");
						$(this).prop("checked","checked");
						if($(this).attr("value") == "man"){
							 location.href='/rank/?type=0';
							 return false;
						}
						else{
							 location.href='/rank/?type=1';
					        return false;
						}
					});
				});
			</script> -->
			<script>
			$(function(){
				$(".list li").click(function(){					
					var hit = $(this).attr("data-hit");					
					$(this).attr("data-hit",hit++);
					alert(hit);
				});
			});
			</script>
	</body>
</html>