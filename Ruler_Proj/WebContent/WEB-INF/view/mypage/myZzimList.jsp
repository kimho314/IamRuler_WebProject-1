<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
									<h1>찜 목록</h1>
									<jsp:include page="../inc/nav.jsp" />
								</header>
							<!-- Section -->
								<main class="mypageZzim">
										
										<ul class="row">
											<li class="6u 12u$(small)">
												<div class="btn_area"><a href="#" class="btn">찜 삭제</a></div>
												<table>
													<colgroup>
														<col width="30%"/>
														<col width="70%"/>
													</colgroup>
													<tbody>
														<tr>
															<td>
																<figuare>
																	<a href="#"><img src="http://placehold.it/50x70" alt="#" /></a>
																</figuare>
															</td>
															<th>
																<ul>
																	<li>2019-00-00</li>
																	<li><a href="#">제에목</a></li>
																	<li>간단한 내용</li>
																</ul>
																<div><textarea name="" id="">메모입니다</textarea></div>
															</th>
														</tr>
													</tbody>
												</table>
											</li>
											<li class="6u 12u$(small)">
												<div class="btn_area"><a href="#" class="btn">찜 삭제</a></div>
												<table>
													<colgroup>
														<col width="30%"/>
														<col width="70%"/>
													</colgroup>
													<tbody>
														<tr>
															<td>
																<figuare>
																	<a href="#"><img src="http://placehold.it/50x70" alt="#" /></a>
																</figuare>
															</td>
															<th>
																<ul>
																	<li>2019-00-00</li>
																	<li><a href="#">제에목</a></li>
																	<li>간단한 내용</li>
																</ul>
																<div><textarea name="" id="">메모입니다</textarea></div>
															</th>
														</tr>
													</tbody>
												</table>
											</li>
											<li class="6u 12u$(small)">
												<div class="btn_area"><a href="#" class="btn">찜 삭제</a></div>
												<table>
													<colgroup>
														<col width="30%"/>
														<col width="70%"/>
													</colgroup>
													<tbody>
														<tr>
															<td>
																<figuare>
																	<a href="#"><img src="http://placehold.it/50x70" alt="#" /></a>
																</figuare>
															</td>
															<th>
																<ul>
																	<li>2019-00-00</li>
																	<li><a href="#">제에목</a></li>
																	<li>간단한 내용</li>
																</ul>
																<div><textarea name="" id="">메모입니다</textarea></div>
															</th>
														</tr>
													</tbody>
												</table>
											</li>
											<li class="6u 12u$(small)">
												<div class="btn_area"><a href="#" class="btn">찜 삭제</a></div>
												<table>
													<colgroup>
														<col width="30%"/>
														<col width="70%"/>
													</colgroup>
													<tbody>
														<tr>
															<td>
																<figuare>
																	<a href="#"><img src="http://placehold.it/50x70" alt="#" /></a>
																</figuare>
															</td>
															<th>
																<ul>
																	<li>2019-00-00</li>
																	<li><a href="#">제에목</a></li>
																	<li>간단한 내용</li>
																</ul>
																<div><textarea name="" id="">메모입니다</textarea></div>
															</th>
														</tr>
													</tbody>
												</table>
											</li>
										</ul>
										<div class="btn_area">
											<a href="#" class="button special small">저장</a>
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
			<script>
				$(function(){
					$(".mypageZzim textarea").focus(function(){
						$(this).html("메모넣기");
					});
					$(".mypageZzim textarea").blur( function() {
						$(this).html("메모빼기");
					});
				});
			</script>
	</body>
</html>