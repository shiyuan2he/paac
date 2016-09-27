<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//paac-core
	String path = request.getContextPath();
	//http://localhost:8080/paac-core/
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>平台云-登陆</title>
	<link href="<%=path %>/css/index/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="<%=path %>/css/index/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="<%=path %>/css/index/owl.carousel.css" rel="stylesheet" type="text/css" media="all" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="世远云平台 | 平台项目 | 云服务平台" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/index/move-top.js"></script>
	<script type="text/javascript" src="<%=path %>/js/index/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
	<link rel="stylesheet" href="<%=path %>/css/index/swipebox.css">
	<script src="<%=path %>/js/index/jquery.swipebox.min.js"></script>
	<script type="text/javascript">jQuery(function($){$(".swipebox").swipebox();});</script>
</head>
<body>
<div class="header">
	<div class="container">
		<div class="header-top">
			<div class="logo">
				<a href="<%=path %>/website/index.jsp">运动</a>
			</div>
			<div class="top-menu">
				<span class="menu"><img src="<%=path %>/images/index/nav.png" alt=""/></span>
				<ul>
					<li><a class="active" href="#home" class="scroll">首页</a></li>
					<li><a href="#about" class="scroll">关于我</a></li>
					<li><a href="#services" class="scroll">服务</a></li>
					<li><a href="#portfolio" class="scroll">图片墙</a></li>
					<li><a href="#news" class="scroll">动态</a></li>
					<li><a href="#contact" class="scroll">联系我</a></li>
					<li><h2 style="color:white">|</h2></li>
					<li>
						<a href="#contact" class="scroll">登陆</a>
						-
						<a href="#contact" class="scroll">注册</a>
					</li>
				</ul>
			</div>
			<script>
				$("span.menu").click(function(){
					$(".top-menu ul").slideToggle("slow" , function(){});
				});
			</script>
			<div class="clearfix"></div>
		</div>

		<p class="banner-center">欢迎访问我的个人网站，希望浏览我的网站能给您带来生活上的帮助。</p>
		<!-- 一段简短的说明，暂时去除  -->
		<!-- <div class="banner-bottom">
			<div class="banner-grids">
				<div class="col-md-5 left-grid">
					<img src="<%=path %>/images/index/img1.jpg" class="img-responsive" alt="/">
				</div>
				<div class="col-md-7 right-grid">
					<h3> welcome !</h3>
					<p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio.Lorem ipsum dolor sit amet, consectetur adipisc elit. Proin ultricies vestibulum vebiben dum et condimentum metusip.</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div> -->

	</div>
</div>
<div class="content">
	<div class="about-section" id="about">
		<div class="container">
			<div class="about-header">
				<h3>关于我</h3>
				<p>我的一些足迹.</p>
			</div>
			<div class="about-grids">
				<div class="col-md-3 about-grid">
					<img src="<%=path %>/images/index/p1.jpg" class="img-responsive" alt="/">
					<h4>paris</h4>
					<p>Lorem ipsum dolor sit amet consectetur adipisc elit Proin ultricies vestibulum.</p>
				</div>
				<div class="col-md-3 about-grid">
					<img src="<%=path %>/images/index/p2.jpg" class="img-responsive" alt="/">
					<h4>maldives</h4>
					<p>Lorem ipsum dolor sit amet consectetur adipisc elit Proin ultricies vestibulum.</p>
				</div>
				<div class="col-md-3 about-grid">
					<img src="<%=path %>/images/index/p4.jpg" class="img-responsive" alt="/">
					<h4>thailand</h4>
					<p>Lorem ipsum dolor sit amet consectetur adipisc elit Proin ultricies vestibulum.</p>
				</div>
				<div class="col-md-3 about-grid">
					<img src="<%=path %>/images/index/p3.jpg" class="img-responsive" alt="/">
					<h4>everest</h4>
					<p>Lorem ipsum dolor sit amet consectetur adipisc elit Proin ultricies vestibulum.</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
	<div class="services-section" id="services">
		<div class="container">
			<div class="services-header">
				<h3>services</h3>
				<p>Lorem ipsum dolor sit amet consectetur adipisc elit Proin ultricies vestibulum </p>
			</div>
			<div class="services-grids">
				<div class="ser-top">
					<div class="col-md-4 ser-grid">
						<div class="ser1">
							<img src="<%=path %>/images/index/icon1.png">
						</div>
						<h4>Route Selection</h4>
						<p>Mauris fermentum tortor non enim aliquet condimentum. Nam aliquam pretium duis sem.</p>
					</div>
					<div class="col-md-4 ser-grid">
						<div class="ser1">
							<img src="<%=path %>/images/index/icon2.png">
						</div>
						<h4>Route Selection</h4>
						<p>Mauris fermentum tortor non enim aliquet condimentum. Nam aliquam pretium duis sem.</p>
					</div>
					<div class="col-md-4 ser-grid">
						<div class="ser1">
							<img src="<%=path %>/images/index/icon3.png">
						</div>
						<h4>Wide Choice</h4>
						<p>Mauris fermentum tortor non enim aliquet condimentum. Nam aliquam pretium duis sem.</p>

					</div>
					<div class="clearfix"></div>
				</div>

				<div class="ser-bottom">
					<div class="col-md-4 ser-grid">
						<div class="ser1">
							<img src="<%=path %>/images/index/icon4.png">
						</div>
						<h4>Buy Tickets</h4>
						<p>Mauris fermentum tortor non enim aliquet condimentum. Nam aliquam pretium duis sem.</p>

					</div>
					<div class="col-md-4 ser-grid">
						<div class="ser1">
							<img src="<%=path %>/images/index/icon5.png">
						</div>
						<h4>Route Selection</h4>
						<p>Mauris fermentum tortor non enim aliquet condimentum. Nam aliquam pretium duis sem.</p>

					</div>
					<div class="col-md-4 ser-grid">
						<div class="ser1">
							<img src="<%=path %>/images/index/icon6.png">
						</div>
						<h4>Wide Choice</h4>
						<p>Mauris fermentum tortor non enim aliquet condimentum. Nam aliquam pretium duis sem.</p>

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="team-section" id="team">
		<div class="container">
			<div class="team-header">
				<h3>team</h3>
				<p>Praesent lectus tortor tincidu nt in consectetur vestibulum ultrices nec neque </p>
			</div>
			<div class="team-grids">
				<div class="col-md-4 team-grid">
					<img src="<%=path %>/images/index/t1.jpg" class="img-responsive" alt="/">
					<div class="team-info">
						<h4>Janey</h4>
						<p>lectus </p>
						<a href="#"><img src="<%=path %>/images/index/facebook.png"></a>
					</div>
				</div>
				<div class="col-md-4 team-grid">
					<img src="<%=path %>/images/index/t3.jpg" class="img-responsive" alt="/">
					<div class="team-info">
						<h4>Janey</h4>
						<p>lectus </p>
						<a href="#"><img src="<%=path %>/images/index/twitter.png"></a>
					</div>
				</div>
				<div class="col-md-4 team-grid">
					<img src="<%=path %>/images/index/t2.jpg" class="img-responsive" alt="/">
					<div class="team-info">
						<h4>janey</h4>
						<p>lectus </p>
						<a href="#"><img src="<%=path %>/images/index/google-plus.png"></a>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>

	<div class="portfolio-section" id="portfolio">
		<div class="container">
			<div class="Portfolio-header">
				<h3>portfolio</h3>
				<p>Lorem ipsum dolor sit amet consectetur adipisc elit Proin ultricies vestibulum </p>
			</div>
			<div class="Portfolio-grids">
				<div class="col-md-3 Portfolio-grid">
					<div class="Portfolio-grid1">
						<a href="<%=path %>/images/index/im2.jpg" class="swipebox"><img src="<%=path %>/images/index/im2.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>
					</div>
					<div class="Portfolio-grid1 gr2">
						<a href="<%=path %>/images/index/im3.jpg" class="swipebox"><img src="<%=path %>/images/index/im3.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>
					</div>
					<div class="Portfolio-grid1">
						<a href="<%=path %>/images/index/im4.jpg" class="swipebox"><img src="<%=path %>/images/index/im4.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>
					</div>
				</div>
				<div class="col-md-3 Portfolio-grid">
					<div class="Portfolio-grid1">
						<a href="<%=path %>/images/index/im5.jpg" class="swipebox"><img src="<%=path %>/images/index/im5.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>
					</div>
					<div class="Portfolio-grid1 gr2">
						<a href="<%=path %>/images/index/im6.jpg" class="swipebox"><img src="<%=path %>/images/index/im6.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>
					</div>
					<div class="Portfolio-grid1">
						<a href="<%=path %>/images/index/im7.jpg" class="swipebox"><img src="<%=path %>/images/index/im7.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>

					</div>
				</div>
				<div class="col-md-3 Portfolio-grid">
					<div class="Portfolio-grid1">
						<a href="<%=path %>/images/index/im8.jpg" class="swipebox"><img src="<%=path %>/images/index/im8.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>

					</div>
					<div class="Portfolio-grid1 gr2">
						<a href="<%=path %>/images/index/im9.jpg" class="swipebox"><img src="<%=path %>/images/index/im9.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>

					</div>
					<div class="Portfolio-grid1">
						<a href="<%=path %>/images/index/im10.jpg"class="swipebox"><img src="<%=path %>/images/index/im10.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>

					</div>
				</div>
				<div class="col-md-3 Portfolio-grid">
					<div class="Portfolio-grid1">
						<a href="<%=path %>/images/index/im11.jpg" class="swipebox"><img src="<%=path %>/images/index/im11.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>

					</div>
					<div class="Portfolio-grid1 gr2">
						<a href="<%=path %>/images/index/im12.jpg" class="swipebox"><img src="<%=path %>/images/index/im12.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>

					</div>
					<div class="Portfolio-grid1">
						<a href="<%=path %>/images/index/im13.jpg" class="swipebox"><img src="<%=path %>/images/index/im13.jpg" class="img-responsive" alt="/"><span class="zoom-icon"></span></a>

					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>

	<div class="Testimonials" id="testimonials">
		<div class="container">
			<div class="testimonial-header">
				<h3>testimonial</h3>
				<p>Lorem ipsum dolor sit amet consectetur adipisc elit  Proin ultricies vestibulum </p>
			</div>
			<div class="test-monials">
				<!-- start content_slider -->
				<div id="owl-demo" class="owl-carousel">
					<div class="item">

						<div class="testmonial-text">
							<p>"Lorem ipsum dolor sit amet  offendit volutpat sea ex  at omnium scripta pro, at omnium scripta pro, ei mea oratio malorum forensibus. ei mea oratio malorum forensibus. Sed ei omnes laoreet posidonium ei mea oratio malorum."</p>
							<h4>John Doe</h4>

						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="item">

						<div class="testmonial-text">
							<p>"If I don't feel confident about my body, I'm not going to sit at home and feel sorry for myself and not do something about it. It's all about taking action and not being lazy. So you do the work, whether it's fitness or whatever."</p>
							<h4>John Doe</h4>

						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="item">
						<div class="testmonial-text">
							<p>"If I don't feel confident about my body, I'm not going to sit at home and feel sorry for myself and not do something about it. It's all about taking action and not being lazy. So you do the work, whether it's fitness or whatever."</p>
							<h4>John Doe</h4>

						</div>
						<div class="clearfix"> </div>
					</div>

				</div>

				<div class="sreen-gallery-cursual">
					<script src="<%=path %>/js/index/owl.carousel.js"></script>
					<script>
						$(document).ready(function() {
							$("#owl-demo").owlCarousel({
								items : 1,
								lazyLoad : true,
								autoPlay : true,
								navigation : false,
								navigationText :  false,
								pagination : true,
							});
						});
					</script>
				</div>
			</div>
		</div>
	</div>
	<!---- testmonials ---->
	<div class="news-section"  id="news">
		<div class="container">
			<div class="new-header">
				<h3>latest news</h3>
				<p>Lorem ipsum dolor sit amet  consectetur adipisc elit  Proin ultricies vestibulum </p>
			</div>
			<div class="news-grids">
				<div class="col-md-4 new-grid">
					<div class="new-date">
						<h4>09</h4>
						<h5>july</h5>
					</div>
					<div class="new-text">
						<p>Mauris fermentum tortor non enim aliquet condimentum. Nam aliquam pretium duis sem feugiat.</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-4 new-grid">
					<div class="new-date">
						<h4>15</h4>
						<h5>june</h5>
					</div>
					<div class="new-text">
						<p>Mauris fermentum tortor non enim aliquet condimentum. Nam aliquam pretium duis sem feugiat.</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-4 new-grid">
					<div class="new-date">
						<h4>19</h4>
						<h5>july</h5>
					</div>
					<div class="new-text">
						<p>Mauris fermentum tortor non enim aliquet condimentum. Nam aliquam pretium duis sem feugiat.</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
<div class="contact-section" id="contact">
	<div class="container">
		<div class="contact-header">
			<h3>contact us</h3>
			<p>Lorem ipsum dolor sit amet  consectetur adipisc elit  Proin ultricies vestibulum </p>
		</div>
		<div class="contact-grid">
			<div class="col-md-6 contactdetails-grid">
				<h4>contact form</h4>
				<h5>name <span>*</span></h5>
				<input type="text">
				<h5>email address <span>*</span></h5>
				<input type="text">
				<h5>subject <span>*</span></h5>
				<input type="text">
				<h5>message <span>*</span></h5>
				<textarea> </textarea>
				<input type="button" value="send">
			</div>
			<div class="col-md-6 contactdetails-grid1">
				<div class="address">
					<h4>Address</h4>
					<p>500 Lorem Ipsum Dolor Sit,</p>
					<p>22-56-2-9 Sit Amet, Lorem,</p>
					<p>USA</p>
					<p>Phone:(00) 222 666 444</p>
					<p>Fax: (000) 000 00 00 0</p>
					<p>Email: <a href="mailto:example@mail.com">info@mycompany.com</a></p>
					<p>Follow on: <a href="#">Facebook</a> , <a href="#">Twitter</a></p>
				</div>
				<div class="google-map">
					<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3021.0814617966994!2d-73.96467908332265!3d40.782223218920294!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c2589a018531e3%3A0xb9df1f7387a94119!2sCentral+Park!5e0!3m2!1sen!2sin!4v1420805667126"></iframe>
				</div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<div class="footer-section">
	<div class="container">
		<div class="footer-top">
		</div>
		<div class="footer-bottom">
			<p>Copyright &copy; 2016.All rights reserved.</p>
		</div>
		<script type="text/javascript">
			$(document).ready(function() {
				$().UItoTop({ easingType: 'easeOutQuart' });
			});
		</script>
		<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
</div>
</body>
</html>