<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
										<ul class="cover">
											<c:if test="${empty list}">
												<li class="nolist">찜한 목록이 없습니다.</li>
											</c:if>
											<c:if test="${not empty list}">
											<c:forEach var="z" items="${list}">
													<li class="6u 12u$(small)"> 
														<form action="/mypage/myzzim" method="post" name="frm">
														<div class="btn_area"> <input type="submit" value="찜 삭제"  class="btn"/></div>
														<table>
															<colgroup>
																<col width="30%"/>
																<col width="70%"/>
															</colgroup>
															<tbody>
																<tr>
																	<td>
																		<figuare>
																			<a href="/coordi/id=${z.coordiId}"><img src="${(empty z.img)? '/images/noimg.gif':z.img}" alt="#" /></a>
																		</figuare>
																	</td>
																	<th>
																		<ul>
																			<li>${z.regdate}</li>
																			<li><a href="/coordi/id=${z.coordiId}">${z.title}</a></li>
																			<li>${fn:substring(z.content,0,20)}</li>
																		</ul>
																		<div><textarea name="memo" id="">${z.memo}</textarea></div>
																		<input type="hidden" name="dibsId" value="${z.dibsId}" />
																		<input type="hidden" name="orgmemo" value="${z.memo}" />
																		<input type="hidden" name="del" value="${z.coordiId}" />
																	</th>
																</tr>
															</tbody>
														</table>
														</form>	
													</li>
											</c:forEach>
											</c:if>
											<%-- <li class="6u 12u$(small)">
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
																<div><textarea name="memo" id="">메모입니다22</textarea></div>
															</th>
														</tr>
													</tbody>
												</table>
												<input type="hidden" name="dibsId" value="2" />
												<input type="hidden" name="orgmemo" value="메모입니다" />
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
																<div><textarea name="memo" id="">메모입니다123</textarea></div>
																
															</th>
														</tr>
													</tbody>
												</table>
												<input type="hidden" name="dibsId" value="1" />
												<input type="hidden" name="orgmemo" value="메모입니다" />
											</li> --%>
										</ul>
										<div class="btn_area">
											<c:if test="${empty list}">
											<a href="/coordi/" class="button special small">찜하러 가기</a>
											</c:if>
											<c:if test="${not empty list}">
											<a href="#" class="button special small" onclick="compare()">저장</a>
											</c:if>
										</div>
										<input type="hidden" id="eidtlist" />
									
									<div id="anno" style="display:none">
										찜목록이 저장 되었습니다.										
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
				
				function infobox(txt){
					$("#anno").html(txt);
					$("#anno").fadeIn().delay(2000).fadeOut();
				}
				function compare(){
					var dataArr = new Array();
					var memoArr = document.getElementsByName("memo");
					var orgMemoArr  = document.getElementsByName("orgmemo");
					var dibsIdArr  = document.getElementsByName("dibsId");
				
					var obj = {};
					for(var i=0;i<memoArr.length;i++)
						if(memoArr[i].value != orgMemoArr[i].value){
							obj = {"dibsId" : dibsIdArr[i].value,
									"memo" : memoArr[i].value
								   };
							dataArr.push(obj);
							//alert("수정됨");
						}
					
					//$.post("/mypage/myzzim", dataArr, function(){alert("aa")});
					
					/* var request = new XMLHttpRequest();
					request.addEventListener("load", function(){
						alert("done");
					}); */
					//request.open("POST", "/mypage/myzzim");
					//request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
					//request.send("list="+JSON.stringfy(dataArr));
					
					
					
				}
					
			</script>
			<c:if test="${not empty del and del == 1}">
				<script>infobox('찜이 삭제되었습니다.')</script>
			</c:if>
			<c:if test="${not empty del and del == 2}">
				<script>infobox('찜이 삭제가 실패되었습니다.')</script>
			</c:if>
	</body>
</html>