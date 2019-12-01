<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html class="no-js">

<head>
    <title>쇼핑 도우미 : 아임룰러</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
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
    <script src="assets/js/modernizr.custom.js"></script>
    <script src="https://kit.fontawesome.com/1af26a8adc.js" crossorigin="anonymous"></script>
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
	<form name="frmData" action="reg_post" method="post" enctype="multipart/form-data">
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
                                	<c:if test="${empty pDetail }">
                                    <a href="#" class="button small"
                                        style="box-shadow: none; font-size:1em; padding: 0 1em;">수정
                                    </a>
                                    <a href="#" class="button small"
                                        style="box-shadow: none; font-size:1em; padding: 0 1em;">삭제
                                    </a>
                                    </c:if>
                                </div>
                            </div>

                            <div class="visual-bottom"></div>
                        </div>

                        <!-- <form name="frmData" id="frmData" method="post" enctype="multipart/form-data"> -->
                            <div class="coordi-post-table-wrapper">
                                <table class="coordi-post-table" style="color:black">
                                    <tr>
                                        <td colspan="4">게시글</td>
                                    </tr>

                                    <tr>
                                        <td>제목</td>
                                        <td colspan="4">
                                        	<c:if test="${not empty pDetail }">
                                        	<input type="text" name="coordi-post-table-title" id="demo-name" value="${pDetail.cct_title }"
                                                placeholder="제목" />
                                        	</c:if>
                                        	<c:if test="${empty pDetail }">
                                            <input type="text" name="coordi-post-table-title" id="demo-name" value=""
                                                placeholder="제목" />
                                            </c:if>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>작성자</td>
                                        <td>    
                                             <input readonly="readonly" type="text" name="coordi-post-table-writerId" id="demo-name" value="${userName }"
                                                placeholder="작성자" />
                                        </td>

                                        <td>게시 날짜</td>
                                        <td>      	
                                             <c:set var="now" value="<%= new java.util.Date() %>" />                                             
                                             <input readonly="readonly" type="text" name="coordi-post-table-regdate" id="demo-name" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${now }"/> "
                                                placeholder="게시 날짜" />      
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>체형</td>
                                        <td>
                                            <div class="select-wrapper">
                                            	<c:if test="${not empty pDetail }">
                                            	<c:if test="${g eq '여성' || empty g}">
                                                <select name="bodyshape-category" id="select-bodyshape">
                                                    <option value="${pDetail.co_bodyshape }">${pDetail.co_bodyshape }</option>
                                                    <option value="작은 역삼각">작은 역삼각</option>
                                                    <option value="큰 역삼각">큰 역삼각</option>
                                                    <option value="역삼각">역삼각</option>
                                                    <option value="사각">사각</option>
                                                </select>
                                                </c:if>
                                                <c:if test="${g eq '남성' }">
                                                 <select name="bodyshape-category" id="select-bodyshape">
                                                    <option value="${pDetail.co_bodyshape }">${pDetail.co_bodyshape }</option>
                                                    <option value="작은 역삼각">작은 역삼각</option>
                                                    <option value="큰 사각">큰 사각</option>
                                                    <option value="사각">사각</option>                                                    
                                                </select>
                                                </c:if>
                                                </c:if>
                                                <c:if test="${empty pDetail }">
                                                <c:if test="${g eq '여성' || empty g}">
                                                <select name="bodyshape-category" id="select-bodyshape">
                                                    <option value>선택</option>
                                                    <option value="작은 역삼각">작은 역삼각</option>
                                                    <option value="큰 역삼각">큰 역삼각</option>
                                                    <option value="역삼각">역삼각</option>
                                                    <option value="사각">사각</option>
                                                </select>
                                                </c:if>
                                                <c:if test="${g eq '남성' }">
                                                 <select name="bodyshape-category" id="select-bodyshape">
                                                    <option value>선택</option>
                                                    <option value="작은 역삼각">작은 역삼각</option>
                                                    <option value="큰 사각">큰 사각</option>
                                                    <option value="사각">사각</option>                                                    
                                                </select>
                                                </c:if>                                                
                                                </c:if>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>내용</td>
                                        <td colspan="4">
                                        	<c:if test="${not empty pDetail }">
                                            <textarea name="content-message" id="demo-message" placeholder="내용"
                                                rows="6">${pDetail.cct_content }</textarea>
                                            </c:if>
                                            <c:if test="${empty pDetail }">
                                             <textarea name="content-message" id="demo-message" placeholder="내용"
                                                rows="6"></textarea>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>첨부내용</td>
                                        <td colspan="4">
                                            <input type="file" name="files[]" multiple="multiple" />
                                        </td>
                                    </tr>
                                </table>
                            </div>

                            <div class="coordi-post-icons-bottom">
                                <input type="hidden" name="gender-field" value="${param.g }">
                                <button class="popup-open" type="button" onclick="openPopUp()">등록</button>
                                <a href="coordi_list_w_main.html" style="margin:0 0;">
                                    <button class="popup-open" type="button">취소</button>
                                </a>                               
                            </div>
                        <!-- </form> -->
                    </div>

                </section>
            </div>
        </div>

        <!-- Sidebar -->
        <jsp:include page="../inc/aside.jsp" />
        

        <div class="newpost-popup" style="display:none">
            <div class="contents popup-contents">
                <p class="title">정상적으로 등록되었습니다 </p>
                <p></p>
                <div class="btn">
                    <!-- <a href="#" class="button close" onclick="closePopUp()">닫기</a> -->
                	<input type="submit" value="닫기" class="">
                </div>
            </div>
        </div>
        <div class="newpost-mask" style="display:none"></div>
       

    </div>
    </form>

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