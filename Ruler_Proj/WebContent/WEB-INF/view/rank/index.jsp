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
									<ul class="list best best-list"> </ul>
									<ul class="list g-list"> </ul>
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
			<script>
				$(function(){
					$(".genderMenu li input").click(function(){
						$(".genderMenu li input").prop("checked","");
						$(this).prop("checked","checked");
						switch ($(this).attr("value")) {
						case "man":
							getData("/rank-json?type=0");
							break;
						case "woman":
							getData("/rank-json?type=1");
							break;	
						default:
							getData("/rank-json");
							break;
						}					
					});					
				});
				function getData(url){
					loader();
					$.getJSON(url,function(data){load(data)})
					.fail(function(){alert('실패되었습니다.');});
				}
				function loader(){
					 $(".list").html("");
					 var temp = '<li><img src="/images/ajax-loader.gif" alt="loading"></li>';
				 	$(".best-list").append(temp); 
					$(".g-list").append(temp);
				}
				function load(data){
					var temp = null;
					//alert(data[0].url);
					 $(".list").html("");
					if(data.length <1){
						temp = '<li>리스트가 없습니다.</li>';	
						$(".list").append(temp); 
					}
					for(var i =0;i<10;i++){
						var medal = null;
						 if(i<3)
							 medal = "fas fa-medal";
						 else
							 medal = "far fa-certificate";
						 temp = '<li><figuare><a href="'+data[i].url+
						 '" target="_blank"><img src="'+data[i].img+
						 '" alt="#"></a><figcaption><a href="'+data[i].url+
						 '" target="_blank">'+data[i].mall_name+
						 '</a></figcaption></figuare><i class="'+ medal
						 +' fa-3x"></i><span class="icon">'+
						 (i+1)+'위</span></li>';
						 //alert("Data Loaded: " + temp);
						 if(i<3)
						 	$(".best-list").append(temp); 
						 else
							$(".g-list").append(temp);
					}
				}
			</script>
			<c:if test="${empty userGender}">
				<script>getData("/rank-json");</script>
			</c:if>
			<c:if test="${not empty userGender and userGender eq '남성'}">
				<script>$(".genderMenu li:first-child input").click();getData("/rank-json?type=0");</script>
			</c:if>
			<c:if test="${not empty userGender and userGender eq '여성'}">
				<script>$(".genderMenu li:last-child input").click();getData("/rank-json?type=1");</script>
			</c:if>
	</body>
</html>