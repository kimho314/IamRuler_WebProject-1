<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="page" value="${(empty param.p)?1:param.p}"/>
<!DOCTYPE HTML>
<html>
<head>
<title>쇼핑 도우미 : 아임룰러</title>
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
</head>
<body>

   <!-- Wrapper -->
   <div id="wrapper">
      <!-- Main -->
      <div id="main">
         <div class="inner">
            <!-- Header -->
            <header id="header">
               <h1>교환 게시판</h1>
	               <jsp:include page="../inc/nav.jsp"></jsp:include>
            </header>

            <br>
            <form action="/trade/detail" method="post" name="frm">
            <div>
            <c:if test="${ boardUserName == userName }">
               <div class="edel" id="tnwjdtkrwp2">
                  <ul class="icons">
                     <li><input type="submit" name="edel" value="수정"/></li>
                     <!-- <li><span class="label">|</span></li> -->
                     <li><input type="submit" name="edel" value="삭제"/></li> 
                  </ul>
               </div>
               </c:if>
               <div>
                  <table class="center">
                     <tbody>
                        <tr>
                           <th class="center">제목</th>
                           <td colspan="3" class="left">${t.bTitle}</td>
                        </tr>

                        <tr>
                           <th class="center">작성자</th>
                           <c:if test="${boardUserName != null}">
                          <td>${boardUserName}</td>
                          </c:if>
							<c:if test="${boardUserName == null}">
								<td>[탈퇴한 회원입니다]</td>
							</c:if>
							<th class="center">등록일자</th>
                           <td>${t.bRegdate}</td>
                        </tr>
                        <tr>
                           <th class="center">의류</th>
                           <td>${t.itemCategory}　</td>
                           <th class="center">지역</th>
                           <td>${t.itemRegion}</td> 
                        </tr>
                        <tr>
                           <th class="center">체형</th>
                           <td>${t.itemBodyshape}　</td>
                           <th class="center">거래여부</th>
                           <td>${t.bTag}</td>
                        </tr>
                        <%-- <tr>
                           <th class="center">첨부파일</th>
                           <td colspan="3" class="left">
                           		<c:forTokens var="fileName" items="${t.img}" delims=",">
                               		<a download href="/upload/${fileName}"  class="black">${fileName}</a>
                                </c:forTokens></td>
                        </tr> --%>
                     </tbody>
                  </table>
                  <div>${t.bContent}</div>
                  <div class="content-img-wrapper">
				<c:forEach var="c" items="${imgs }">
               <div><img src="../..${c }"></div>                                               
               </c:forEach>                                                
              	</div>
               </div>
               <br>
               <script>
               	   window.addEventListener("load",function(){
                   var cid = document.querySelector("input[name=cId]");
                   var cmd  = document.querySelector("input[name=cmd]");
                   var deleteBtn = document.querySelectorAll(".delete-btn");
                   var editBtn = document.querySelectorAll(".edit-btn");
                   var regBtn = document.querySelector(".reg-btn");
                   for (var i = 0; i < deleteBtn.length; i++) 
                	   deleteBtn[i].onclick=function(e){
                         cid.value = e.target.nextElementSibling.value;
                         cmd.value = "삭제";
                         alert(cmd.value);
                         document.frm.submit();
                      }
                   for (var i = 0; i < editBtn.length; i++) 
                	   editBtn[i].onclick=function(e){
                         cid.value = e.target.nextElementSibling.value;
                         cmd.value = "수정";
                         location.href = "#location";
                         var content = e.target.previousElementSibling.value;
                         console.log();
                         var cContent = document.getElementsByName("cContent")[0];
                         cContent.value = content;
                         regBtn.onclick=function(e){
                             cmd.value = "수정";
                             document.frm.submit();
                          }

                      }
                   regBtn.onclick=function(e){
                       cmd.value = "등록";
                       document.frm.submit();
                    }
                });
               </script>
                <input type="hidden" name="cId"/>
               <input type="hidden" name="cmd"/>
				<table id="tnwjdtkrwp">
					<tbody>
						<c:forEach var="c" items="${c}">
							<c:if test="${0 ne c.cId}">
								<c:if test="${c.cOpenStatus==0 }">
									<tr>
										<td>
											<div>
												<c:if test="${ c.mUserName == userName }">
												<div class="">
													<ul class="a">
														<li><input type="hidden" value="${c.cContent}">
														<input type="button" class="gray edit-btn" name="cmd" value="수정"> 
														<input type="hidden" value="${c.cId}"></li>
														<!-- <li><span>|</span></li> -->
														<li><input type="button" class="gray delete-btn"
															name="cmd" value="삭제"> <input type="hidden"
															value="${c.cId}"></li>
													</ul>
												</div>
												</c:if>
												<c:if test="${c.mUserName == null}">
														<span>[탈퇴한 회원입니다]</span>
													</c:if>
												<div id="name">${c.mUserName}</div>
												<div id="date">${c.cRegdate}</div>
											</div>
											<div id="content">${c.cContent}</div>
										</td>
									</tr>
								</c:if>
								<c:if test="${c.cOpenStatus==1}">
									<tr>
										<td>
											<div>
												<c:if test="${ c.mUserName == userName }">
													<div>
														<ul class="a">
															<li><input type="hidden" value="${c.cContent}">
															<input type="button" class="gray edit-btn"
																name="cmd" value="수정"> <input type="hidden"
																value="${c.cId}"></li>
															<!-- <li><span>|</span></li> -->
															<li><input type="button" class="gray delete-btn"
																name="cmd" value="삭제"> <input type="hidden"
																value="${c.cId}"></li>
														</ul>
													</div>
												</c:if>
												
												<div id="name">
													<i class="fas fa-lock"></i> 
													<c:if test="${boardUserName != userName && c.mUserName != userName}">
													***
													</c:if>
													<c:if test="${boardUserName == userName || c.mUserName == userName}">
														${c.mUserName}
													</c:if>
													<%-- <c:if test="${c.mUserName == null}">
														<span>[탈퇴한 회원입니다]</span>
													</c:if> --%>
													</div>
													
											
											<div id="date">${c.cRegdate}</div>
											</div>
											<c:choose>
											<c:when test="${boardUserName == userName || c.mUserName == userName }">
											<div id="content">${c.cContent}</div>
											</c:when>
											<c:when test="${boardUserName != userName && c.mUserName != userName}">
											<div id="content">비밀댓글입니다</div>
											</c:when>
											</c:choose>
										</td>
										</tr>
									</c:if>
								</c:if>
						</c:forEach>
					</tbody>
				</table>
					
					<c:if test="${not empty userName}">
					<input type="hidden" name="bId" value="${t.bId}"/>
               		<div class="box" id="location">
                 	<textarea placeholder="댓글을 입력해주세요" rows="6" name="cContent"></textarea>
                  <div></div>
                  <div class="commentreg">
                     <div class="6u 12u$(small) inlineblock">
                        <input type="checkbox" id="secret" name="cOpenStatus"> <label for="secret">비밀글</label>
                     </div>
                     <div class="reg inlineblock">
                     	<input class="button special reg-btn reg" name="cmd" value="등록">
                     </div>
                     <input type="hidden" name="bId" value="${t.cId}"/>
                  </div>
				</div>
				</c:if>
				
                  <div class="btn center">
                     <a href="/trade/list" class="button">목록</a>
                  </div>
					</form>
                 <!--  <div>
                     <br>
                     <table>
                        <tr>
                           <th>이전글</th>
                           <td><a href="">교환 ㄱㄱ</a></td>
                        </tr>
                        <tr>
                           <th>다음글</th>
                           <td><a href="">다음글이 없습니다</a></td>
                        </tr>
                     </table>
                  </div> -->
					
                  <!-- Section -->
                  <section></section>
            </div>
            
         </div>
      </div>
      	<!-- Sidebar -->
	<jsp:include page="../inc/aside.jsp"></jsp:include>
   </div>

   <!-- Scripts -->
   <script src="../assets/js/jquery.min.js"></script>
   <script src="../assets/js/skel.min.js"></script>
   <script src="../assets/js/util.js"></script>
   <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
   <script src="../assets/js/main.js"></script>

</body>
</html>
