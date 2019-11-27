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
	               <nav>
					<ul class="icons">
						<!-- 로그인 -->
						<li><a href="/login">로그인</a></li>
						<li>&#124;</li>
						<li><a href="/signup">회원가입</a></li>
						<!-- 로그아웃 --><!--
						<li><a href="/logout">로그아웃</span></a></li>
						<li>&#124;</li>
						<li><a href="/mypage/index">마이페이지</a></li> -->
					</ul>
				</nav>
            </header>

            <br>
            <div>
               <div class="edel">
                  <ul class="icons">
                     <li><a href=""><span class="label gray">수정</span></a></li>
                     <li><span class="label">|</span></li>
                     <li><a href=""><span class="label gray">삭제</span></a></li>
                  </ul>
               </div>

               <div>
                  <table class="center">
                     <tbody>
                        <tr>
                           <th class="center">제목</th>
                           <td colspan="3" class="left">${t.bTitle}</td>
                        </tr>

                        <tr>
                           <th class="center">작성자</th>
                           <td>${t.mUserName}</td>
                           <th class="center">등록일자</th>
                           <td>${t.bRegdate}</td>
                        </tr>
                        <tr>
                           <th class="center">의류</th>
                           <td>${t.itemCategory}</td>
                           <th class="center">지역</th>
                           <td>${t.itemRegion}</td> 
                        </tr>
                        <tr>
                           <th class="center">체형</th>
                           <td>${t.itemBodyshape}</td>
                           <th class="center">거래여부</th>
                           <td>거래중</td>
                        </tr>
                        <tr>
                           <th class="center">태그</th>
                           <td colspan="3" class="left">${t.bTag}</td>
                        </tr> 
                        <tr>
                           <th class="center">첨부파일</th>
                           <td colspan="3" class="left">${t.img}</td>
                        </tr>
                     </tbody>
                  </table>
                  <div>${t.bContent}</div>
               </div>
               <br>
               <table>
                  <tbody>
                     <tr>
                        <td>
                           <div>
                              <div>
                                 <ul class="a">
                                    <li><a href="" class="gray"><span>수정</span></a></li>
                                 
                                    <li><span>|</span></li>
                                    <li><a href="" class="gray"><span>삭제</span></a></li>
                                 </ul>
                              </div>
                              <div id="name">${c.mUserName}</div>
                              <div id="date">${c.cRegdate}</div>
                           </div>
                           <div id="content">${c.cContent}</div>
                        </td>
                     </tr>
                     <tr>
                        <td>
                           <div>
                              <div>
                                 <ul class="a">
                                    <li><a href="" class="gray"><span>수정</span></a></li>
                                    <li><span>|</span></li>
                                    <li><a href="" class="gray"><span>삭제</span></a></li>
                                 </ul>
                              </div>

                              <div id="name">
                                 <i class="fas fa-lock"></i> ***
                              </div>
                              <div id="date">2019-05-05</div>
                           </div>
                           <div id="content">비밀 댓글입니다.</div>
                        </td>
                     </tr>
                  </tbody>
               </table>
               
			   <form action="/trade/detail" method="post">
			   <input type="hidden" name="bId" value="${c.bId}"/>
               <div class="box">
                  <textarea placeholder="댓글을 입력해주세요" rows="6" name="cContent"></textarea>
                  
                  <div></div>
                  <div class="commentreg">
                     <div class="6u 12u$(small) inlineblock">
                        <input type="checkbox" id="secret" name="secret"> <label for="secret">비밀글</label>
                     </div>
                     <div class="reg inlineblock">
                     	<input class="button special" type="submit" value="댓글등록"/>
                     </div>
                  </div>
				</div>
				</form>

                  <div class="btn center">
                     <a href="/trade/list" class="button">목록</a>
                  </div>

                  <div>
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
                  </div>

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