<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>회원가입</title>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, user-scalable=no"
    />
    <!--[if lte IE 8]>
      <script src="assets/js/ie/html5shiv.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="../css/sign.css" />
    <!--[if lte IE 9]>
      <link rel="stylesheet" href="assets/css/ie9.css" />
    <![endif]-->
    <!--[if lte IE 8]>
      <link rel="stylesheet" href="assets/css/ie8.css" />
    <![endif]-->
  </head>
  <body>
    <!-- 래퍼 -->
    <div id="wrapper">
      <!-- 메인 -->
      <div id="main">
        <div class="inner">
          <!-- 헤더 -->
          <header id="header">
            <h1>약관동의</h1>
            <ul class="헤더메뉴">
              <li>
                <a href="login" class="로그인">
                  <span class="헤더메뉴">로그인</span>
                </a>
              </li>
              <li>
                <a href="sign-up" class="회원가입">
                  <span class="헤더메뉴">회원가입</span>
                </a>
              </li>
            </ul>
          </header>
          <!-- <input onmousewheel=""> -->
          <!-- 테이블 -->
          <div id="약관">
            <label>약관내용</label>
            <div class="작은약관 약관내용스크롤">
              <span id="약관내용" class="약관">
                길고긴약관<br />
                길고긴약관<br />
                아무튼 길고긴약관<br />
                길고긴약관<br />
                길고긴약관<br />
                길고긴약관<br />
                아무튼 길고긴약관<br />
                길고긴약관<br />
                길고긴약관<br />
                길고긴약관<br />
              </span>
            </div>
            <br />
            <label>주의사항</label>
            <div class="작은약관">
              <span class="약관">
                I’M RULER 는 상품에 직접 관여하지 않으며 상품 주문, <br />배송
                및 환불의 의무와 책임은 각 판매업체에 있습니다.
              </span>
            </div>
          </div>
          <!-- Section -->
          <section>
            <span id="약관취소버튼">
              <a href="../index"><label class="button">취소</label></a>
            </span>
            <span id="약관동의버튼">
              <a>
                <label class="button 버튼아님">동의</label>
              </a>
            </span>
          </section>
        </div>
      </div>

      <jsp:include page="../inc/aside.jsp" />
    </div>

    <!-- Scripts -->
    <script src="../assets/js/jquery.min.js"></script>
    <script src="../assets/js/skel.min.js"></script>
    <script src="../assets/js/util.js"></script>
    <script src="../../../js/sign/agree.js"></script>
    <!--[if lte IE 8]>
      <script src="assets/js/ie/respond.min.js"></script>
    <![endif]-->
    <script src="../assets/js/main.js"></script>
  </body>
</html>
