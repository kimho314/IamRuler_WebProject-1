<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<!-- Sidebar -->
	<c:set var="orgUrl" value="${requestScope['javax.servlet.forward.servlet_path']}" />
	<c:set var="pathUrl" value="${fn:split(orgUrl,\"/\")[1]}" />
	<div id="sidebar">
		<div class="inner">
			<!-- Menu -->
				<nav id="menu">
					<h1 class="logo"><a href="/"><img src="../images/logo.png" alt="아임룰러" /></a></h1>
					<h2 class="hidden">마이페이지 메뉴</h2>
					<ul>
						<li class="<c:if test="${pathUrl == 'reg'}">on</c:if>">
						<a href="reg">회원 정보 수정</a></li>
						<li class="<c:if test="${pathUrl == 'withdraw'}">on</c:if>">						
						<a href="withdraw">회원 탈퇴</a></li>
						<li class="<c:if test="${pathUrl == 'mylist'}">on</c:if>">						
						<a href="mylist">내가 작성한 글</a></li>
						<li class="<c:if test="${pathUrl == 'myzzim'}">on</c:if>">						
						<a href="myzzim">찜 목록</a></li>															
					</ul>
				</nav>
				<section>
					<header class="major">
					   <!-- <h2>Get in touch</h2> -->
					</header>
					<p>I’M RULER 는 상품에 직접 관여하지 않으며 상품 주문, 배송 및 환불의 의무와 책임은 각 판매업체에
					   있습니다.</p>
					<ul class="contact">
						<li class="fa-home">I'M RULER</li>
						<li class="fa-envelope-o"><a href="mailto:admin@imruler.com"></a>admin@imruler.com</a></li>
						<!-- <li class="fa-phone-alt">(02) 538-3643</li> -->
					</ul>
				 </section>
	 
				 <!-- Footer -->
				 <footer id="footer">
					<p class="copyright">&copy; imruler.com 2019-2021 All Right
					   Reserved. Contact admin@imruler.com for more information.
				 </footer>

		</div>
	</div>