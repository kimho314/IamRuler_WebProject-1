<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<c:set var="orgUrl" value="${requestScope['javax.servlet.forward.servlet_path']}" />
	<c:set var="pathUrl" value="${fn:split(orgUrl,\"/\")[0]}" />
	
	<!-- Sidebar -->
	<div id="sidebar">
		<div class="inner">
			<!-- Menu -->
				<nav id="menu">
					<h1 class="logo"><a href="/"><img src="../images/logo.png" alt="아임룰러" /></a></h1>
					<h2 class="hidden">메인 메뉴</h2>
					<ul>
						<li class="<c:if test="${pathUrl == 'index'}">on</c:if>"><a href="/index">사이즈비교</a></li>
						<li class="<c:if test="${pathUrl == 'coordi'}">on</c:if>"><a href="/coordi/list_w">체형별코디</a></li>
						<li class="<c:if test="${pathUrl == 'trade'}">on</c:if>"><a href="/trade/list">교환게시판</a></li>
						<li class="<c:if test="${pathUrl == 'rank'}">on</c:if>"><a href="/rank">쇼핑몰랭킹</a></li>										
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