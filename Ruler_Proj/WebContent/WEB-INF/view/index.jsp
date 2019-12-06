<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head profile="http://www.w3.org/2005/10/profile">
<link rel="icon" type="image/png" href="http://example.com/myicon.png">
<title>쇼핑 도우미 : 아임룰러</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="css/mainpage.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->

<script src="https://kit.fontawesome.com/1af26a8adc.js"
	crossorigin="anonymous"></script>
<script src='index.js'></script>

</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
					<jsp:include page="inc/nav.jsp"></jsp:include>

				</header>
				<!-- Banner -->
				<div class="wrapBox">
					<section id="banner">
						<div class="content">
							<header>
								<h1>
									더 이상 반품은 노!<br /> 사이즈를 알기 쉽게
								</h1>
								<p>
									아임룰러는 키 몸무게와 세분화된 체형정보 입력을 통해 신체<br />
									<!--  -->
									데이터를 옷의 실측사이즈와 비교하여 사이즈를 추천드립니다.
								</p>
							</header>

							<ul class="actions">
								<li><a href="#infor" class="button big infoBtn">사이즈 비교
										→</a></li>
							</ul>
						</div>

						<div class="main-img">
							<img src="images/main_visualPc.gif" alt="" id="mainPc" />
							<!--  -->
							<img src="images/main_visualMo.png" alt="" id="mainMo" />
							<!--  -->
							<img src="images/main_visualM.png" alt="" id="mainCom" />
						</div>

					</section>
					<div class="innerWrapBox">
						<form action="/index" method="post" name="inputInfor">
							<input type="hidden" name="type">
							<!-- Section -->
							<section id="infor">
								<header class="major">
									<h2>내 정보 입력</h2>
								</header>
								<div class="posts">

									<article>
										<!-- 체형 이미지 -->
										<div class="image object-stage">
											<img src="images/main_simulator1.png">
										</div>
									</article>

									<article>
										<!-- 내 정보 입력 -->
										<table class="alt body-form">
											<tr class="inforform">
												<th>성별</th>
												<td id="inforline">
													<div class="maingender">
														<input type="radio" id="demo-priority-low" name="gender"
															value="woman"
															<c:if test="${userGender == '여성'|| empty userGender}">checked</c:if>>
														<!--  -->
														<label for="demo-priority-low">여성</label>
													</div>

													<div class="maingender">
														<input type="radio" id="demo-priority-normal"
															name="gender" value="man"
															<c:if test="${userGender == '남성'}">checked</c:if>>
														<!--  -->
														<label for="demo-priority-normal">남성</label>
													</div>
													
												</td>
											</tr>
											<tr class="inforform">
												<th>연령대</th>
												<td id="inforline">
													<div class="select-wrapper" id="agecheck">
														<c:if test="${empty userAge || userAge == 10}">
															<select name="area">
																<option value="10" selected="selected">10대</option>
																<option value="20">20대</option>
																<option value="30">30대</option>
																<option value="40">40대+</option>
															</select>
														</c:if>
														<c:if test="${userAge == 20}">
															<select name="area">
																<option value="10">10대</option>
																<option value="20" selected="selected">20대</option>
																<option value="30">30대</option>
																<option value="40">40대+</option>
															</select>
														</c:if>
														<c:if test="${userAge == 30}">
															<select name="area">
																<option value="10">10대</option>
																<option value="20">20대</option>
																<option value="30" selected="selected">30대</option>
																<option value="40">40대+</option>
															</select>
														</c:if>
														<c:if test="${userAge == 40}">
															<select name="area">
																<option value="10">10대</option>
																<option value="20">20대</option>
																<option value="30">30대</option>
																<option value="40" selected="selected">40대+</option>
															</select>
														</c:if>
													</div>
												</td>
											</tr>

											<tr class="inforform">
												<th>체형</th>
												<td id="inforline">
													<div class="select-wrapper">
														<c:if
															test="${empty userBodyshape || userBodyshape == '보통'}">
															<select name="bodyshape" id="bodyshape">
																<option value="nomal" selected="selected">보통</option>
																<option value="smallInverseTriangle">작은 역삼각</option>
																<option value="triangle">삼각</option>
																<option value="inverseTriangle">역삼각</option>
																<option value="square">사각</option>
															</select>
														</c:if>
														<c:if test="${userBodyshape == '작은역삼각'}">
															<select name="bodyshape" id="bodyshape">
																<option value="nomal">보통</option>
																<option value="smallInverseTriangle" selected="selected">작은
																	역삼각</option>
																<option value="triangle">삼각</option>
																<option value="inverseTriangle">역삼각</option>
																<option value="square">사각</option>
															</select>
														</c:if>
														<c:if test="${userBodyshape == '삼각'}">
															<select name="bodyshape" id="bodyshape">
																<option value="nomal">보통</option>
																<option value="smallInverseTriangle">작은 역삼각</option>
																<option value="triangle" selected="selected">삼각</option>
																<option value="inverseTriangle">역삼각</option>
																<option value="square">사각</option>
															</select>
														</c:if>
														<c:if test="${userBodyshape == '역삼각'}">
															<select name="bodyshape" id="bodyshape">
																<option value="nomal">보통</option>
																<option value="smallInverseTriangle">작은 역삼각</option>
																<option value="triangle">삼각</option>
																<option value="inverseTriangle" selected="selected">역삼각</option>
																<option value="square">사각</option>
															</select>
														</c:if>
														<c:if test="${userBodyshape == '사각'}">
															<select name="bodyshape" id="bodyshape">
																<option value="nomal">보통</option>
																<option value="smallInverseTriangle">작은 역삼각</option>
																<option value="triangle">삼각</option>
																<option value="inverseTriangle">역삼각</option>
																<option value="square" selected="selected">사각</option>
															</select>
														</c:if>
													</div>
												</td>
											</tr>
											<tr class="inforform">
												<th>키</th>
												<td id="inforline"><c:if test="${empty userHeight}">
														<input type="text" name="x" value="" placeholder="키 입력"
															class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"  />
														<span>cm</span>
													</c:if> <c:if test="${!empty userHeight}">
														<input type="text" name="x" value="${userHeight}"
															placeholder="키 입력" class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/>
														<span>cm</span>
													</c:if>
												</td>
											</tr>

											<tr class="inforform">
												<th>몸무게</th>
												<td id="inforline"><c:if test="${empty userWeight}">
														<input type="text" name="y" value="" placeholder="몸무게 입력"
															class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/>
														<span>kg</span>
													</c:if> <c:if test="${!empty userWeight}">
														<input type="text" name="y" value="${userWeight}"
															placeholder="몸무게 입력" class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/>
														<span>kg</span>
													</c:if></td>
											</tr>
										</table>
										<ul class="actions" id="main-nextbutton">
											<li><a href="#clothcheck" class="button big moveBtn">다음 입력 →</a></li>
										</ul>
									</article>

								</div>
							</section>

							<!-- Section -->
							<section id="clothcheck">
								<header class="major">
									<h2>의류 선택</h2>
								</header>
								<!-- 여성 선택 -->
								<div class="features" id="genderW">
									<article id="checkTop" class="clothcheck-box">
										<div class="iconBox">
											<a href="#detailsize" class="spin moveBtn2" data-type="T">
												<span class="icon"></span> <img src="images/main_ic1.png"
												alt="#" />
											</a>
										</div>
										<div class="description">
											<h3>
												<a href="#detailsize" data-type="T" class="moveBtn2">상의</a>
											</h3>
										</div>
									</article>

									<article id="checkOuter" class="clothcheck-box">
										<div class="iconBox">
											<a href="#detailsize" class="spin moveBtn2" data-type="O">
												<span class="icon"></span> <img src="images/main_ic3.png"
												alt="#" />
											</a>
										</div>
										<div class="description">
											<h3>
												<a href="#detailsize" data-type="O" class="moveBtn">아우터</a>
											</h3>
										</div>
									</article>

									<article id="checkPants" class="clothcheck-box">
										<div class="iconBox">
											<a href="#detailsize" class="spin moveBtn2" data-type="P">
												<span class="icon"></span> <img src="images/main_ic2.png"
												alt="#" />
											</a>
										</div>
										<div class="description">
											<h3>
												<a href="#detailsize" data-type="P" class="moveBtn2">바지</a>
											</h3>
										</div>
									</article>

									<article id="checkSkirt" class="clothcheck-box">
										<div class="iconBox">
											<a href="#detailsize" class="spin moveBtn2" data-type="Sk">
												<span class="icon"></span> <img src="images/main_ic4.png"
												alt="#" />
											</a>
										</div>
										<div class="description">
											<h3>
												<a href="#detailsize" data-type="Sk" class="moveBtn2">치마</a>
											</h3>
										</div>
									</article>

									<article id="checkOnepiece" class="clothcheck-box">
										<div class="iconBox">
											<a href="#detailsize" class="spin moveBtn2" data-type="Op">
												<span class="icon"></span> <img src="images/main_ic5.png"
												alt="#" />
											</a>
										</div>
										<div class="description">
											<h3>
												<a href="#detailsize" data-type="Op" class="moveBtn2">원피스</a>
											</h3>
										</div>
									</article>
								</div>

								<!-- 남성 선택 -->
								<div class="features" id="genderM" style="display: none;">
									<article id="checkTop" class="clothcheck-box">
										<div class="iconBox">
											<a href="#detailsize" class="spin moveBtn2" data-type="T">
												<span class="icon"></span> <img src="images/main_ic1.png"
												alt="#" />
											</a>
										</div>
										<div class="description">
											<h3>
												<a href="#detailsize" data-type="T" class="moveBtn2">상의</a>
											</h3>
										</div>
									</article>

									<article id="checkOuter" class="clothcheck-box">
										<div class="iconBox">
											<a href="#detailsize" class="spin moveBtn2" data-type="O">
												<span class="icon"></span> <img src="images/main_ic3.png"
												alt="#" />
											</a>
										</div>
										<div class="description">
											<h3>
												<a href="#detailsize" data-type="O" class="moveBtn2">아우터</a>
											</h3>
										</div>
									</article>

									<article id="checkPants" class="clothcheck-box">
										<div class="iconBox">
											<a href="#detailsize" class="spin moveBtn2" data-type="P">
												<span class="icon"></span> <img src="images/main_ic2.png"
												alt="#" />
											</a>
										</div>
										<div class="description">
											<h3>
												<a href="#detailsize" data-type="P" class="moveBtn2">바지</a>
											</h3>
										</div>
									</article>
								</div>
							</section>

							<section id="detailsize">
								<header class="major">
									<h2>상세 사이즈 입력</h2>
								</header>

								<!-- 상의 -->
								<div class="posts" id="top">
									<article>
										<span class="image object"> <img
											src="images/main_size1.png" />
										</span>
									</article>
									
									<article>
										<table class="alt">
											<tr class="inforform">
												<th>어깨 너비</th>
												<td id="inforline"><input type="text"
													name="tshoulderWidth" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>가슴 단면</th>
												<td id="inforline"><input type="text"
													name="tchestBreadth" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>소매 길이</th>
												<td id="inforline"><input type="text"
													name="tsleeveLength" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>총 장</th>
												<td id="inforline"><input type="text"
													name="ttopTotalLength" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>
										</table>
									</article>
								</div>

								<!-- 바지 -->
								<div class="posts" id="pants">
									<article>
										<span class="image object"> <img
											src="images/main_size2.png" />
										</span>
									</article>
									
									<article>
										<table class="alt">
											<tr class="inforform">
												<th>허리 단면</th>
												<td id="inforline"><input type="text"
													name="pwaistWidth" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>허벅지 단면</th>
												<td id="inforline"><input type="text" name="thighWidth"
													value="" placeholder="입력" class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>밑위 길이</th>
												<td id="inforline"><input type="text"
													name="crotchWidth" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>밑단 단면</th>
												<td id="inforline"><input type="text" name="hemWidth"
													value="" placeholder="입력" class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>총 장</th>
												<td id="inforline"><input type="text"
													name="pantsTotalLength" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>
										</table>
									</article>
								</div>

								<!-- 아우터 -->
								<div class="posts" id="outer">
									<article>
										<span class="image object"> <img
											src="images/main_size4.png" />
										</span>
									</article>
									<article>
										<table class="alt">
											<tr class="inforform">
												<th>어깨 너비</th>
												<td id="inforline"><input type="text"
													name="oshoulderWidth" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>가슴 단면</th>
												<td id="inforline"><input type="text"
													name="ochestBreadth" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>소매 길이</th>
												<td id="inforline"><input type="text"
													name="osleeveLength" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>총 장</th>
												<td id="inforline"><input type="text"
													name="otopTotalLength" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>
										</table>
									</article>
								</div>

								<!-- 치마 -->
								<div class="posts" id="skirt">
									<article>
										<span class="image object"> <img
											src="images/main_size3.png" />
										</span>
									</article>
									<article>
										<table class="alt">
											<tr class="inforform">
												<th>허리 단면</th>
												<td id="inforline"><input type="text"
													name="skwaistWidth" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>밑단 단면</th>
												<td id="inforline"><input type="text"
													name="skirtHemWidth" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>총 장</th>
												<td id="inforline"><input type="text"
													name="skirtTotalLength" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>
										</table>
									</article>
								</div>

								<!-- 원피스 -->
								<div class="posts" id="onepiece">
									<article>
										<span class="image object"> <img
											src="images/main_size5.png" />
										</span>
									</article>
									<article>
										<table class="alt">
											<tr class="inforform">
												<th>어깨 너비</th>
												<td id="inforline"><input type="text"
													name="opshoulderWidth" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>가슴 단면</th>
												<td id="inforline"><input type="text"
													name="opchestBreadth" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>소매 길이</th>
												<td id="inforline"><input type="text"
													name="opsleeveLength" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;" /><span>cm</span></td>
											</tr>

											<tr class="inforform">
												<th>총 장</th>
												<td id="inforline"><input type="text"
													name="onePieceTotalLength" value="" placeholder="입력"
													class="maintextbox" onKeyDown="return numkeyCheck(this)" onkeyup="removeChar(event)" style="ime-mode:disabled;"/><span>cm</span></td>
											</tr>
										</table>
									</article>
								</div>

								<div>
									<ul class="actions" id="main-compbutton">
										<li><input type="button" value="비교하기 →" class="button big" id="compsize" onclick="cfm();"></li>
									</ul>
								</div>

							</section>
						</form>
					</div>
					<!-- innerwrapBox -->
					<a href="#" class="topBtn">Top</a>
				</div>
				<!-- wrapBox -->
			</div>
		</div>



		<jsp:include page="inc/aside.jsp"></jsp:include>

	</div>
	<div id="popup">
		<div class="contents popup" id="con-small">
			<p class="title">
				<i class="far fa-grin-beam-sweat"></i><br>사이즈가 작아요!
			</p>
			<p class="overlayment">좀 더 큰 사이즈로 주문하시는걸 추천드려요!</p>
			<div class="btn" id="overlayClose">
				<a href="/index" class="button close">닫기</a>
			</div>
		</div>

		<div class="contents popup" id="con-middle">
			<p class="title">
				<i class="far fa-grin-hearts fa-5x"></i><br>사이즈가 딱 맞네요!
			</p>
			<p class="overlayment">이걸로 당장 구매하세요</p>
			<div class="btn" id="overlayClose">
				<a href="/index" class="button close">닫기</a>
			</div>
		</div>

		<div class="contents popup" id="con-big">
			<p class="title">
				<i class="far fa-laugh-wink"></i><br>사이즈가 크네요!
			</p>
			<p class="overlayment">좀 더 작은 사이즈로 입어도 괜찮을듯b</p>
			<div class="btn" id="overlayClose">
				<a href="/index" class="button close">닫기</a>
			</div>
		</div>

		<div class="contents popup" id="con-error">
			<p class="title">
				<i class="far fa-sad-tear"></i><br>오류가 발생했습니다!
			</p>
			<p class="overlayment">다시 시도해주세요.</p>
			<div class="btn" id="overlayClose">
				<a href="/index" class="button close">닫기</a>
			</div>
		</div>

	</div>
	<div class="mask"></div>
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
	<script>
	var boxtype =  null;
		function openpop(id) {
			$(".mask, #" + id).fadeIn();

		}
		function typeChange(txt) {
			document.getElementsByName("type")[0].value = txt;
			//alert(document.getElementsByName("type")[0].value);
			return txt;
		}
		$(function() {
			var wrapBoxheg = resizeHeg();
			//alert(wrapBoxheg);
			
			$(".infoBtn").bind("click",function(e) {
				e.preventDefault();
				$(".wrapBox").css({
					"overflow-y" : "auto"
				}).animate({
					scrollTop : wrapBoxheg
				}, 400).css({
					"overflow-y" : "hidden"
				});				
				$(".topBtn").fadeIn();
				$("#banner").fadeOut();
			});

			$(".moveBtn").bind("click", function(e) {
				e.preventDefault();
				var target = $(this).attr("href");
				var currentp = $(".innerWrapBox").scrollTop();
				var targetp = $(target).position().top;
				$(".innerWrapBox").animate({
					scrollTop : currentp + targetp
				}, 400);
			});
			$(".moveBtn2").bind("click", function(e) {
				e.preventDefault();
				var type = $(this).data("type");
				boxtype = typeChange(type);
				var target = $(this).attr("href");
				var currentp = $(".innerWrapBox").scrollTop();
				var targetp = $(target).position().top;
				$(".innerWrapBox").animate({
					scrollTop : currentp + targetp
				}, 400);
			});
			$(".topBtn").click(function(e) {
				e.preventDefault();
				$(".innerWrapBox").animate({
					scrollTop : 0
				}, 400);
			});
			$(window).resize(function() {
				wrapBoxheg = resizeHeg();
			});
			
		});
		function resizeHeg() {
			var heg = $(window).height();
			var headheg = $("#header").height();
			var wrapBoxheg = heg - headheg;
			//alert(wrapBoxheg);
			$(".wrapBox").css({
				"height" : wrapBoxheg
			});
			$(".innerWrapBox").css({
				"height" : wrapBoxheg
			});
			$(".wrapBox section").css({
				"height" : wrapBoxheg
			});
			return wrapBoxheg;
		}
		
		function numkeyCheck(e) {
			var keyValue = event.keyCode; 
			if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 )
	            return;
			else if((keyValue < 48) || (keyValue > 57)) 
				return false;
		}
		function removeChar(event) {
	        event = event || window.event;
	        var keyID = (event.which) ? event.which : event.keyCode;
	        if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 )
	            return;
	        else
	            event.target.value = event.target.value.replace(/[^0-9]/g, "");
	    }
		function cfm(){
            var tar = document.querySelector(".body-form").querySelectorAll(".maintextbox");
            var sw = true;
            for (var i = 0; i < tar.length; i++){
               if(tar[i].value == ""){
                  alert("정보를 입력해주세요");
                  tar[i].focus();
                  sw = false;
                  break;
               }   
            }
            if(sw) cfm2();
         }
      function cfm2(){
         var target = null;
         var sw = true;
         switch (boxtype) {
         case "T":
            target=document.querySelector("#top");
            break;
         case "O":
            target=document.querySelector("#outer");
            break;
         case "P":
            target=document.querySelector("#pants");
            break;
         case "Sk":
            target=document.querySelector("#skirt");
            break;
         case "Op":
            target=document.querySelector("#onepiece");
            break;
         default:
            target=document.querySelector("#top");
            break;
         }
         
         var inputs= target.querySelectorAll(".maintextbox");
         for (var i = 0; i < inputs.length; i++) {
            if(inputs[i].value == ""){
                  alert("정보를 입력해주세요");
                  inputs[i].focus();
                  sw = false;
                  break;
               }   
         }
         if(sw) document.inputInfor.submit();
      }
	</script>
	<c:if test="${result eq 3}">
		<script>
			openpop("con-small");
		</script>
	</c:if>
	<c:if test="${result eq 2}">
		<script>
			openpop("con-middle");
		</script>
	</c:if>
	<c:if test="${result eq 1}">
		<script>
			openpop("con-big");
		</script>
	</c:if>
	<c:if test="${result eq 0 || result > 3 || result < 0}">
		<script>
			openpop("con-error");
		</script>
	</c:if>
	<c:if test="${userGender == '여성'}">
		<script>
			$(function() {
				$("#genderW").css("display", "flex");
				$("#genderM").hide();
			});
		</script>
	</c:if>
	<c:if test="${userGender == '남성'}">
		<script>
			$(function() {
				$("#genderW").hide();
				$("#genderM").css("display", "flex");
			});
		</script>
	</c:if>
</body>
</html>