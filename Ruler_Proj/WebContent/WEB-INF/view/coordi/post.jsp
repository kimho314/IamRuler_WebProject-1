<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<title>쇼핑 도우미 : 아임룰러</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8
      ]><script src="assets/js/ie/html5shiv.js"></script
    ><![endif]-->
<link rel="stylesheet" href="../css/seop.css" />
<!--[if lte IE 9
      ]><link rel="stylesheet" href="assets/css/ie9.css"
    /><![endif]-->
<!--[if lte IE 8
      ]><link rel="stylesheet" href="assets/css/ie8.css"
    /><![endif]-->
<script src="https://kit.fontawesome.com/1af26a8adc.js"
	crossorigin="anonymous"></script>
<script> 
                function openPopUp() {
                document.getElementsByClassName("newpost-popup")[0].style.display = "block";
                document.getElementsByClassName("newpost-mask")[0].style.display = "block";
                
            }
    
            function closePopUp() {
                document.getElementsByClassName("newpost-popup")[0].style.display = "none";
                document.getElementsByClassName("newpost-mask")[0].style.display = "none";
              
            }
            
    </script>
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
				<section id="banner">
					<div class="content">
						<div class="visual-wrapper">
							<div class="visual-top-coordi-post">
								<div class="visual-top-right">
									<c:if test="${not empty userName }">
										<a href="#" class="button small"
											style="box-shadow: none; font-size: 100%; padding: 0 1em;"
											onclick="openPopUp()">찜하기</a>
										<a href="post?cb_id=${param.cb_id }&opt=1"
											class="button small"
											style="box-shadow: none; font-size: 100%; padding: 0 1em;">수정</a>
										<a href="post?cb_id=${param.cb_id }&opt=2"
											class="button small"
											style="box-shadow: none; font-size: 100%; padding: 0 1em;">삭제</a>
									</c:if>
								</div>
							</div>

							<div class="visual-bottom"></div>
						</div>

						<div class="coordi-post-table-wrapper">
							<table class="coordi-post-table" style="color: black">
								<tr>
									<td colspan="4">게시글</td>
								</tr>

								<tr>
									<td>제목</td>
									<td colspan="4"><input readonly type="text"
										name="coordi-post-table-title" id="demo-name" value="${pdetail.cct_title }"
										placeholder="제목" /></td>
								</tr>

								<tr>
									<td>작성자</td>
									<td><input readonly type="text"
										name="coordi-post-table-title" id="demo-name" value="${pdetail.m_userName }"
										placeholder="작성자" /></td>
									<td>게시 날짜</td>
									<td><input readonly type="text"
										name="coordi-post-table-title" id="demo-name" value="${pdetail.cb_regdate }"
										placeholder="게시 날짜" /></td>
								</tr>

								<tr>
									<td>체형</td>
									<td colspan="4"><input readonly type="text"
										name="coordi-post-table-title" id="demo-name" value="${pdetail.co_bodyshape }"
										placeholder="체형" /></td>
								</tr>

								<tr>
									<td>내용</td>
									<td colspan="4">
										<div class="coordi-post-content">
											<textarea readonly name="demo-message" id="demo-message"
												placeholder="내용" rows="6" style="overflow: scroll;">${pdetail.cct_content }</textarea>
											<img src="../..${pdetail.ci_img }">
										</div>
									</td>

								</tr>
							</table>
						</div>

						<div class="coordi-post-icons-bottom">
							<c:if test="${pdetail.co_gender eq '남성' }">
								<a href="list_m?p=1&g=${pdetail.co_gender }&b=${pdetail.co_bodyshape}" class="button">목록</a> 
							</c:if>
							<c:if test="${pdetail.co_gender eq '여성' }">
								<a href="list_w?p=1&g=${pdetail.co_gender }&b=${pdetail.co_bodyshape}" class="button">목록</a> 
							</c:if>
							<a href="comment?cb_id=${pdetail.cb_id }" class="button">댓글</a>
						</div>
					</div>
				</section>
			</div>
		</div>

		<!-- Sidebar -->
		<jsp:include page="../inc/aside.jsp" />	

		<div class="newpost-popup" style="display: none">
			<div class="contents popup-contents">
				<p class="title">이 게시글을 찜 하였습니다.</p>
				<p></p>
				<div class="btn">
					<a href="reg_dibs?g=${pdetail.co_gender }&m_id=${pdetail.m_id }&cb_id=${pdetail.cb_id}" class="button close" onclick="closePopUp()">닫기</a>
				</div>
			</div>
		</div>
		<div class="newpost-mask" style="display: none"></div>



	</div>

	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/skel.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<!--[if lte IE 8
      ]><script src="assets/js/ie/respond.min.js"></script
    ><![endif]-->
	<script src="../assets/js/main.js"></script>
</body>

</html>
