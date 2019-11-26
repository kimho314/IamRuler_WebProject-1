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
														<tr>
															<td>123123</td>
															<td><a href="#">게시글 타이틀입니다</a></td>
															<td>2019.11.11</td>
															<td>111</td>
														</tr>
														<tr>
															<td>123123</td>
															<td><a href="#">게시글 타이틀입니다</a></td>
															<td>2019.11.11</td>
															<td>111</td>
														</tr>
														<tr>
															<td>123123</td>
															<td><a href="#">게시글 타이틀입니다</a></td>
															<td>2019.11.11</td>
															<td>111</td>
														</tr>
														<tr>
															<td>123123</td>
															<td><a href="#">게시글 타이틀입니다</a></td>
															<td>2019.11.11</td>
															<td>111</td>
														</tr>
														<tr>
															<td>123123</td>
															<td><a href="#">게시글 타이틀입니다</a></td>
															<td>2019.11.11</td>
															<td>111</td>
														</tr>
														<tr>
															<td>123123</td>
															<td><a href="#">게시글 타이틀입니다</a></td>
															<td>2019.11.11</td>
															<td>111</td>
														</tr>
														<tr>
															<td>123123</td>
															<td><a href="#">게시글 타이틀입니다</a></td>
															<td>2019.11.11</td>
															<td>111</td>
														</tr>
														<tr>
															<td>123123</td>
															<td><a href="#">게시글 타이틀입니다</a></td>
															<td>2019.11.11</td>
															<td>111</td>
														</tr>
	
													</tbody>
												</table>
											</div>
											<ul class="pagination">
												<li><span class="disabled">< 이전</span></li>
												<li><a href="#" class="page active">1</a></li>
												<li><a href="#" class="page">2</a></li>
												<li><a href="#" class="page">3</a></li>
												<li><a href="#" >다음 ></a></li>
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
														<tr>
															<td><a href="#">게시글 타이틀</a></td>
															<td><a href="#">댓글 내용댓글 내용댓글 내용댓글 내용</a></td>
															<td>2019.11.11</td>
														</tr>
														<tr>
															<td><a href="#">게시글 타이틀</a></td>
															<td><a href="#">댓글 내용댓글 내용댓글 내용댓글 내용</a></td>
															<td>2019.11.11</td>
														</tr>
														<tr>
															<td><a href="#">게시글 타이틀</a></td>
															<td><a href="#">댓글 내용댓글 내용댓글 내용댓글 내용</a></td>
															<td>2019.11.11</td>
														</tr>
														<tr>
															<td><a href="#">게시글 타이틀</a></td>
															<td><a href="#">댓글 내용댓글 내용댓글 내용댓글 내용</a></td>
															<td>2019.11.11</td>
														</tr>
														<tr>
															<td><a href="#">게시글 타이틀</a></td>
															<td><a href="#">댓글 내용댓글 내용댓글 내용댓글 내용</a></td>
															<td>2019.11.11</td>
														</tr>
														<tr>
															<td><a href="#">게시글 타이틀</a></td>
															<td><a href="#">댓글 내용댓글 내용댓글 내용댓글 내용</a></td>
															<td>2019.11.11</td>
														</tr>
														<tr>
															<td><a href="#">게시글 타이틀</a></td>
															<td><a href="#">댓글 내용댓글 내용댓글 내용댓글 내용</a></td>
															<td>2019.11.11</td>
														</tr>
														<tr>
															<td><a href="#">게시글 타이틀</a></td>
															<td><a href="#">댓글 내용댓글 내용댓글 내용댓글 내용</a></td>
															<td>2019.11.11</td>
														</tr>
													</tbody>
												</table>
											</div>
											<ul class="pagination">
												<li><span class="disabled">< 이전</span></li>
												<li><a href="#" class="page active">1</a></li>
												<li><a href="#" class="page">2</a></li>
												<li><a href="#" class="page">3</a></li>
												<li><a href="#">다음 ></a></li>
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