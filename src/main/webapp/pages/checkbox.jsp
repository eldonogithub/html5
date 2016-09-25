<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/includes/head.jspf"%>
<title>Insert title here</title>
<style type="text/css">
.aClass {
	padding: 5px 10px;
	background-color: red;
}

div {
	background-color: green;
	padding: 5px 10px;
}

div div div div div div div div div div 
div div div div div div div div div div 
div div div div div {
	padding: 5px 10px;
	background-color: blue;
}
</style>
</head>
<body>
	<html:form action="/form/checkbox">
		<fieldset>
			<html:checkbox property="checkboxGroup" value="cb1">checkbox1</html:checkbox>
		</fieldset>
		<input type="submit" value="submit">
	</html:form>
	<div>
		<div>
			<div>
				<div>
					<div>
						<div>
							<div>
								<div>
									<div>
										<div>
											<!-- 10 -->
											<div>
												<div>
													<div>
														<div>
															<div>
																<div>
																	<div>
																		<div>
																			<div>
																				<div>
																					<!-- 20 -->
																					<div>
																						<div>
																							<div>
																								<div>
																									<!-- 25 -->
																									<div class="aClass">Test</div>
																								</div>
																							</div>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>