<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>아이디/비밀번호 찾기</title>
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
    <!-- <link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" /> -->
  </head>
  <body>
    <div id="wrapper">
      <div id="main">
        <div class="inner">
          <header id="header">
            <h1 class="아이디비밀번호찾기">아이디/비밀번호 찾기</h1>
            <ul class="헤더메뉴">
              <li>
                <a href="login.html" class="로그인">
                  <span class="헤더메뉴">
                    로그인
                  </span>
                </a>
              </li>
              <li>
                <a href="sign-up.html" class="회원가입">
                  <span class="헤더메뉴">
                    회원가입
                  </span>
                </a>
              </li>
            </ul>
          </header>
          <div id="찾기테이블">
            <span class="아이디찾기">
              <p>아이디 찾기</p>
              <section class="아이디찾기">
                <form method="POST">
                  <label>이메일</label>
                  <input type="text" name="email" id="이메일" />
                </form>
              </section>

              <section>
                <span id="확인버튼">
                  <label class="button special" for="아이디-pop">확인</label>
                </span>
              </section>
            </span>
            <!-- 구분선 -->
            <span class="비밀번호찾기">
              <p>비밀번호 찾기</p>
              <section class="비밀번호찾기">
                <form method="POST">
                  <label>아이디</label>
                  <input type="text" name="phone" id="아이디" /><br />
                  <label>핸드폰</label>
                  <input type="text" name="phone" id="핸드폰" />
                </form>
              </section>

              <section>
                <span id="확인버튼">
                  <label class="button special" for="비밀번호-pop">확인</label>
                </span>
              </section>
            </span>
          </div>
        </div>
      </div>
   

    <div id="sidebar">
      <div class="inner">
        <!-- Menu -->
        <nav id="menu">       
          <h1 class="logo">
            <a href="index.html"
              ><img src="../images/logo.png" alt="아임룰러"
            /></a>
          </h1>
          <h2 class="hidden">메인 메뉴</h2>
          <ul>
            <li><a href="index.html">사이즈 비교</a></li>
            <li><a href="coordi/coordi_list_main.html">체형 별 코디</a></li>
            <li><a href="#.html">교환 게시판</a></li>
            <li><a href="#.html">쇼핑몰 랭킹</a></li>
          </ul>

          <!-- <h2 class="hidden">마이페이지 메뉴</h2>
                <ul>
                  <li><a href="mypage/member-edit.html">회원정보 수정</a></li>
                  <li><a href="mypage/reg.html">회원 탈퇴</a></li>
                  <li><a href="mypage/#.html">내가 작성한 글</a></li>
                  <li><a href="mypage/#.html">찜 목록</a></li>
                </ul> -->
        </nav>

        <!-- Section -->
        <section>
          <header class="major">
            <!-- <h2>Get in touch</h2> -->
          </header>
          <p>
            I’M RULER 는 상품에 직접 관여하지 않으며 상품 주문, 배송 및 환불의
            의무와 책임은 각 판매업체에 있습니다.
          </p>
          <ul class="contact">
            <!-- <li class="fa-home"><a href="#">I'M RULER</a></li> -->
            <li class="fa-phone">(02) 123-4567</li>
            <li class="fa-envelope-o">admin@imruler.com</li>
          </ul>
        </section>

        <!-- Footer -->
        <footer id="footer">
          <p class="copyright">
            &copy; imruler.com 2019-2021 All Right Reserved. Contact
            admin@imruler.com for more information.
          </p>
        </footer>
      </div>
    </div>

    <div>
      <input class="modal-state" id="아이디-pop" type="checkbox" />
      <div class="팝업">
        <div class="contents">
          <h2 class="title">아이디</h2>
          <p>아이디가 뜰곳</p>
          <br />
          <p id="회원가입성공버튼">
            <a href="find.html" class="button special">확인</a>
          </p>
        </div>
      </div>
      <input class="modal-state" id="비밀번호-pop" type="checkbox" />
      <div class="팝업">
        <div class="contents">
          <h2 class="title">비밀번호</h2>
          <p>비밀번호가 뜰곳</p>
          <br />
          <p id="회원가입성공버튼">
            <a href="find.html" class="button special">확인</a>
          </p>
        </div>
      </div>
    </div>
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
