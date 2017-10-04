<!doctype html>
<html>
<head>

<meta charset="utf-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="mobile" value="true"></c:set>
<%@ include file="../head.jspf"%>

<!-- jQuery / JavaScript -->
<script src="../js/collapsible.js"></script>

<meta name="description"
	content="This demo shows how jQuery UI Controls look with a basic, custom CSS theme applied." />
<meta name="keywords"
	content="jquery,jquery ui,themeroller,widget,demo,tutorial" />
<title>jQuery UI Custom Theme Demo - Custom CSS Theme</title>

</head>
<body>
	<!-- Begin Wrapper -->
	<div id="wrapper">

		<%@ include file="../menu.jspf"%>
		<!-- Begin Accordion Container -->
		<div class="content_container_2">

			<h2>Accordion</h2>

			<!-- Begin Accordion -->
			<div id="accordion1">

				<!-- Begin Panel #1 -->
				<h3>
					<a href="#section1">Accordion</a>
					<input type="checkbox" data-role="flipswitch"
						name="flip-checkbox-1" id="flip-checkbox-1">
				</h3>
				<div>

					<!-- Begin Content Container Div -->
					<div class="content_container_main">


						<!-- Left Content Div -->
						<div class="content_1">
							<img src="images/accordion_1.png" width="350" height="180"
								alt="Accordion" />
							<p>Default Accordion</p>
							<img src="images/accordion_2.png" width="350" height="198"
								alt="Accordion" />
							<p>Accordion with Icons</p>
						</div>

						<!-- Right Content Div -->
						<div class="content_2">
							<h2>Accordion</h2>
							<p>
								An <a href="http://jqueryui.com/demos/accordion/"
									target="_blank" title="Accordion">Accordion</a> doesn't allow
								more than one content panel to be open at the same time. If you
								are looking for a widget that allows more than one content panel
								to be open, don't use an Accordion.
							</p>
							<p>The markup uses a series of headers (H3 tags) and divs so
								the content is still usable even if the browser has JavaScript
								disabled.</p>
							<p>If you want Accordion sections to be collapsible, add
								"collapsible: true" to the JavaScript code.</p>
							<p>To set the Accordion so that the accordion sections open
								and close on mouseover, add event: "mouseover" to the JavaScript
								code.</p>
							<p>
								<a href="http://jqueryui.com/demos/accordion/" target="_blank"
									title="Learn More">Learn More</a>
							</p>
						</div>

					</div>
					<!-- End Content Container Div -->

				</div>
				<!-- End Panel #1 -->
			</div>
			<div id="accordion2">

				<!-- Panel #2 -->
				<h3>
					<a href="#section2">Tabs</a>
				</h3>
				<div>

					<!-- Begin Content Container Div -->
					<div class="content_container_main">

						<!-- Left Content Div -->
						<div class="content_1">
							<img src="images/tabs_1.png" width="350" height="117" alt="Tabs" />
							<p>Default Tabs</p>
							<img src="images/tabs_2.png" width="350" height="143" alt="Tabs" />
							<p>Tabs Below Content</p>
							<img src="images/tabs_3.png" width="350" height="58" alt="Tabs" />
							<p>Content via Ajax</p>
						</div>

						<!-- Right Content Div -->
						<div class="content_2">
							<h2>Tabs</h2>
							<p>
								<a href="http://jqueryui.com/demos/tabs/" target="_blank"
									title="Tabs">Tabs</a> break content into multiple sections that
								can be swapped to save space. The widget swaps the tabbed
								sections onClick by default, but can be changed to onHover
								instead.
							</p>
							<p>If you want the Tabs sections to open on mouseover, add
								event: "mouseover" to the JavaScript code.</p>
							<p>If you want the Tabs content to be collapsible, add
								collapsible: "true" to the JavaScript code.</p>
							<p>Other options for the tabs widget include content loaded
								via Ajax, collapse content, sortable, tabs below content, simple
								manipulation and cookie persistance.</p>
							<p>
								<a href="http://jqueryui.com/demos/tabs/" target="_blank"
									title="Learn More">Learn More</a>
							</p>
						</div>

					</div>
					<!-- End Content Container Div -->

				</div>
				<!-- End Panel #2 -->

			</div>
			<div id="accordion3">

				<!-- Panel #3 -->
				<h3>
					<a href="#section3">Datepicker</a>
				</h3>
				<div>

					<!-- Begin Content Container Div -->
					<div class="content_container_main">

						<!-- Left Content Div -->
						<div class="content_1">
							<p class="left_col_1">
								<img src="images/datepicker_1.png" width="175" height="208"
									alt="Datepicker" /> <br /> Displayed Inline
							</p>

							<p class="left_col_2">
								<img src="images/datepicker_2.png" width="175" height="208"
									alt="Datepicker" /> <br /> Icon Trigger
							</p>

							<p class="left_col_3">
								<img src="images/datepicker_3.png" width="175" height="208"
									alt="Datepicker" /> <br /> With Button Bar
							</p>

							<p class="left_col_4">
								<img src="images/datepicker_4.png" width="175" height="208"
									alt="Datepicker" /> <br /> Month &amp; Year Menus
							</p>
						</div>

						<!-- Right Content Div -->
						<div class="content_2">
							<h2>Datepicker</h2>
							<p>
								<a href="http://jqueryui.com/demos/datepicker/" target="_blank"
									title="Datepicker">Datepicker</a> is tied to form field input.
								A user can choose a date for the form field from an interactive
								calendar displayed in a small overlay using this function.
							</p>
							<p>To display the Datepicker embedded inline on a web page,
								call the .datepicker() on a div instead of a form field.</p>
							<p>You can set the Datepicker to be displayed when clicking
								an icon. You can also set the Datepicker to display multiple
								months.</p>
							<p>The Datepicker function has a variety of settings
								including animations, month and year menus, dates in other
								months, display button bar, localize calendar and more.</p>
							<p>
								<a href="http://jqueryui.com/demos/datepicker/" target="_blank"
									title="Learn More">Learn More</a>
							</p>
						</div>

					</div>
					<!-- End Content Container Div -->

				</div>
				<!-- End Panel #3 -->

			</div>
			<div id="accordion4">

				<!-- Panel #4 -->
				<h3>
					<a href="#section4">Dialog</a>
				</h3>
				<div>

					<!-- Begin Content Container Div -->
					<div class="content_container_main">

						<!-- Left Content Div -->
						<div class="content_1">
							<img src="images/dialog_1.png" width="350" height="197"
								alt="Dialog" />
							<p>Basic Modal Dialog</p>
							<img src="images/dialog_2.png" width="350" height="207"
								alt="Dialog" />
							<p>Modal Message</p>
						</div>

						<!-- Right Content Div -->
						<div class="content_2">
							<h2>Dialog</h2>
							<p>
								A <a href="http://jqueryui.com/demos/dialog/" target="_blank"
									title="Dialog">Dialog</a> is a floating window displayed in an
								overlay that covers the entire web page content. It contains a
								title bar, small to medium sized content area and can be closed
								with an "x" icon.
							</p>
							<p>A scrollbar will automatically appear if the content
								length exceeds the maximum height.</p>
							<p>The jQuery UI Dialog can be animated by specifying the
								desired effect in the JavaScript code. You must include the
								individual effects file for any effects you would like to use.</p>
							<p>You can set the dialog so that it creates a modal message
								or a modal confirmation that a user must click on before
								continuing with the application.</p>
							<p>
								<a href="http://jqueryui.com/demos/dialog/" target="_blank"
									title="Learn More">Learn More</a>
							</p>
						</div>
					</div>
					<!-- End Content Container Div -->

				</div>
				<!-- End Panel #4 -->


			</div>
			<!-- End Accordion -->

		</div>
		<!-- End Accordion Container -->

	</div>
	<!-- End Wrapper -->

</body>
</html>
