<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8
      ]><script src="assets/js/ie/html5shiv.js"></script
    ><![endif]-->
<link rel="stylesheet" href="../css/sign.css" />
<!--[if lte IE 9
      ]><link rel="stylesheet" href="assets/css/ie9.css"
    /><![endif]-->
<!--[if lte IE 8
      ]><link rel="stylesheet" href="assets/css/ie8.css"
    /><![endif]-->
<!-- <link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" /> -->
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<header id="header">
					<h1>회원가입</h1>
					<jsp:include page="../inc/nav.jsp" />
				</header>
				<form method="POST">
					<section id="테이블">
						<table class="회원가입테이블">
							<tr>
								<td title="영문, 숫자, 한글을 자유롭게 섞어서 적어주시면됩니다.">아이디</td>
								<td><input type="text" class="텍스트" name="아이디" /> <span
									id="기타라벨"> 영문 + 숫자 4~16자, 한글 2~8자 (4~16byte) </span> <c:if
										test="${param.error ==1}">
										<span class="오류"> 올바른 아이디를 입력해주세요. </span>
									</c:if></td>
							</tr>
							<tr>
								<td title="영문과 숫자만 사용이 가능합니다.">비밀번호</td>
								<td class="비밀번호입력"><input type="password" class="텍스트"
									name="비밀번호" /> <span id="기타라벨"> 영문 + 숫자 4~16자 </span> <c:if
										test="${param.error ==2}">
										<span class="오류"> 올바른 비밀번호를 입력해주세요. </span>
									</c:if></td>
							</tr>
							<tr>
								<td title="위에 입력한 비밀번호를 한번더 입력해주세요.">비밀번호 확인</td>
								<td class="비밀번호입력"><input type="password" class="텍스트"
									name="비밀번호확인" /> <span id="기타라벨"> 비밀번호를 다시 입력해주세요. </span> <c:if
										test="${param.error ==2}">
										<span class="오류"> 비밀번호가 틀렸습니다. </span>
									</c:if></td>
							</tr>
							<tr>
								<td title="자신의 성별을 선택해주시면됩니다.">성별</td>
								<td><input type="radio" id="남자" name="성별" value="남성"
									checked="checked" /> <label for="남자" class="성별">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;남자 </label> &nbsp;&nbsp; <input
									type="radio" id="여자" name="성별" value="여성" /> <label for="여자"
									class="성별"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;여자 </label></td>
							</tr>
							<tr>
								<td
									title="자신의 연령대를 선택해주시면됩니다.&#13;나중에 수정할사항이 생기면 회원정보 수정에서 수정해주시기 바랍니다.">
									연령대</td>
								<td>
									<div class="select-wrapper">
										<select name="연령대" id="연령대">
											<option value="10">10대</option>
											<option value="20">20대</option>
											<option value="30">30대</option>
											<option value="40">40대 이상</option>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td title="나중에 아이디 및 비밀번호를 찾으실때 사용되니 정확히 입력해주시기 바랍니다.">휴대폰
									번호</td>
								<td><input type="text" class="텍스트" name="전화번호" /> <span
									id="기타라벨"> '-' 를 제외하고 11자리 입력해주세요 </span> <c:if
										test="${param.error ==3}">
										<span class="오류"> 올바른 전화번호를 입력해주세요. </span>
									</c:if></td>
							</tr>
							<tr>
								<td title="나중에 아이디 및 비밀번호를 찾으실떄 사용되니 정확히 입력해주시기 바랍니다.">이메일</td>
								<td><input type="text" class="작은텍스트" name="이메일1" /> <span
									id="이메일라벨"> @ </span> <input type="text" class="텍스트"
									name="이메일2" /> <c:if test="${param.error ==4}">
										<span class="오류"> 올바른 이메일을 입력해주세요. </span>
									</c:if></td>
							</tr>
							<tr>
								<td
									title="자신의 키를 입력해주세요.&#13;나중에 수정할사항이 생기면 회원정보 수정에서 수정해주시기 바랍니다.">
									키</td>
								<td><input type="text" class="작은텍스트" name="키" /> <span
									id="기타라벨"> cm </span></td>
							</tr>
							<tr>
								<td
									title="자신의 몸무게를 입력해주세요.&#13;나중에 수정할사항이 생기면 회원정보 수정에서 수정해주시기 바랍니다.">
									몸무게</td>
								<td><input type="text" class="작은텍스트" name="체중" /> <span
									id="기타라벨"> kg </span></td>
							</tr>
							<tr>
								<td title="키와 체중과 체형을 기준으로 옷 사이즈를 비교합니다.">체형</td>
								<td>
									<div class="select-wrapper">
										<select name="체형" id="체형">
											<option value="보통">보통</option>
											<option value="작은역삼각">작은 역삼각</option>
											<option value="삼각">사각</option>
											<option value="역삼각">역삼각</option>
											<option value="사각">사각</option>
										</select>
									</div>
								</td>
							</tr>
						</table>
					</section>

					<section class="회원가입확인">
						<span id="확인버튼"> <br> <input type="submit"
							class="button special" value="확인">
						</span>
					</section>
				</form>
			</div>
		</div>

		<jsp:include page="../inc/aside.jsp" />
	</div>
	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/skel.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<!--[if lte IE 8]>
      <script src="assets/js/ie/respond.min.js"></script>
    <![endif]-->
	<script src="../assets/js/main.js"></script>
</body>
</html>
