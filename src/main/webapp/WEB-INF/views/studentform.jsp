<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
<script src="<c:url value="/resources/js/formControl.js" />"></script>
</head>
<body>
	<%@include file="../includes/navbar.jsp"%>

	<div class="ui main text container padded">
		<%@include file="../includes/status.jsp"%>

		<div class="ui breadcrumb">
			<a id="personCrumb" class="section">Persoon</a> <i
				class="right angle icon divider"></i> <a id="contactCrumb"
				class="section">Contact</a> <i class="right angle icon divider"></i>
			<a id="educationCrumb" class="section">Studie</a> <i
				class="right angle icon divider"></i> <a id="miscCrumb"
				class="section">Overig</a>
		</div>

		<hr />
		<form:form method="post" modelAttribute="student" cssClass="ui form">
			<div id="person" class="formPart">
				<div class="field">
					<label>Naam <form:errors path="firstName"
							cssClass="form-error" /> <form:errors path="lastName"
							cssClass="form-error" /></label>
					<div class="two fields">
						<div class="field">
							<form:input path="firstName" placeholder="Voornaam" />
						</div>
						<div class="field">
							<form:input path="lastName" placeholder="Achternaam" />
						</div>
					</div>
				</div>

				<div class="field">
					<label>Geboortedatum <form:errors path="dateOfBirth"
							cssClass="form-error" /></label>
					<form:input type="date" path="dateOfBirth" />
				</div>
			</div>

			<div id="contact" class="formPart">
				<div class="field">
					<label>E-mail <form:errors path="email"
							cssClass="form-error" />
					</label>
					<form:input path="email" placeholder="Email" />
				</div>
				<div class="field">
					<label>Telefoon<form:errors path="phone"
							cssClass="form-error" /></label>
					<form:input path="phone" placeholder="Telefoonnummer" />
				</div>


			</div>

			<div id="education" class="formPart">
				<div class="field">
					<div class="field">
						<label>School</label>
						<form:select path="">
							<c:forEach items="${universities}" var="u">
								<option value="${u.id}">${u.name}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="field">
					<div class="field">
						<label>Opleiding <form:errors path="education"
								cssClass="form-error" /></label>
						<form:select path="education">
							<c:forEach items="${educations}" var="e">
								<option value="${e.id}">${e.name}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="fields">
					<div class="eight wide field">
						<label>Begin<form:errors path="startEducation"
								cssClass="form-error" /></label>
						<form:input type="date" path="startEducation" />
					</div>
					<div class="eight wide field">
						<label>Eind<form:errors path="endEducation"
								cssClass="form-error" /></label>
						<form:input type="date" path="endEducation" />
					</div>
				</div>
			</div>


			<div id="misc" class="formPart">
				<div class="two fields">
					<div class="field">
						<label>Bron</label>
						<form:input path="contactOrigin" placeholder="Bron" />
					</div>
					<div class="field">
						<label>LinkedIn status</label>
						<form:input path="linkedInConnectionStatus" placeholder="Status" />
					</div>
				</div>

				<div class="field">
					<label>Events? <form:errors path="isInterestedInEvents"
							cssClass="form-error" /></label>
					<form:checkbox path="isInterestedInEvents" />
				</div>
			</div>

			<div class="formControl">
				<a id="prevPart" class="ui left floated labeled icon button"><i
					class="left arrow icon"></i>Vorige</a> <a id="nextPart"
					class="ui right floated labeled icon button">Volgende<i
					class="right arrow icon"></i></a>
			</div>

			<br>
			<br>
			<button type="submit" class="ui centre floated button">Submit</button>

		</form:form>
	</div>

</body>
</html>