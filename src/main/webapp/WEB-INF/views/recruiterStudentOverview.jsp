<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../includes/header.jsp"%>
</head>
<body ng-app="recruiterModule">
	<%@include file="../includes/navbar.jsp"%>

	<div ng-controller="recruiterStudentController as vm"
		class="ui container padded">
		<%@include file="../includes/status.jsp"%>

		<a href="#" ng-click="vm.showNewStudent()" class="ui green button"><i
			class="plus icon"></i>Nieuwe student</a>

		<table class="ui striped table">
			<thead>
				<tr>
					<th>Voornaam</th>
					<th>Achternaam</th>
					<th>Email</th>
					<th>Telefoon</th>
					<th>Geboortedatum</th>
					<th colspan="2">Studie</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="s in vm.students">
					<td>{{s.firstName}}</td>
					<td>{{s.lastName }}</td>
					<td>{{s.email }}</td>
					<td>{{s.phone }}</td>
					<td>{{s.dateOfBirthFormatted }}</td>
					<td>{{s.education.name }} {{s.education.degree}}</td>
					<td><a href="#" ng-click="vm.showUpdateStudent(s)"><i
							class="write icon"></i></a> <a href="#"
						ng-click="vm.removeStudent(s)"><i class="remove icon"></i></a></td>
				</tr>
			</tbody>
		</table>

		<div class="ui modal newstudent">
			<div class="ui main text container padded">
				<h3>Cre&euml;er nieuwe student</h3>
				<form class="ui form" ng-model="vm.newStudent" id="newStudentForm">
					<div class="field">
						<label>Naam </label>
						<div class="two fields">
							<div class="field">
								<input type="text" ng-model="newStudent.firstName"
									name="firstName" placeholder="Voornaam" required autofocus />
							</div>
							<div class="field">
								<input type="text" ng-model="newStudent.lastName"
									name="lastName" placeholder="Achternaam" required />
							</div>
						</div>
					</div>

					<div class="field">
						<label>Contact </label>
						<div class="two fields">
							<div class="field">
								<input type="email" ng-model="newStudent.email" name="email"
									placeholder="Email" required />
							</div>
							<div class="field">
								<input input="text" ng-model="newStudent.phone" name="phone"
									placeholder="Telefoonnummer" />
							</div>
						</div>
					</div>

					<div class="field">
						<label>Geboortedatum </label> <input ng-model="dateOfBirth"
							type="date" name="dateOfBirth" id="dateOfBirth" />
					</div>

					<div class="fields">
						<div class="five wide field">
							<label>School</label> <select ng-model="newStudent.university"
								ng-options="u as u.name for u in vm.universities"
								name="university">
								<option class="noneOption"></option>
							</select>
						</div>
						<div class="five wide field">
							<label>Opleiding </label> <select ng-model="newStudent.education"
								ng-options="e as e.name for e in vm.educations" name="education">
								<option class="noneOption"></option>
							</select>
						</div>
						<div class="three wide field">
							<label>Begin</label> <input type="date" ng-model="startEducation"
								id="startEducation" name="startEducation" />
						</div>
						<div class="three wide field">
							<label>Eind</label> <input type="date" ng-model="endEducation"
								id="endEducation" name="endEducation" />
						</div>
					</div>

					<div class="two fields">
						<div class="field">
							<label>Bron</label> <input type="text"
								ng-model="newStudent.contactOrigin" name="contactOrigin"
								placeholder="Bron" />
						</div>
						<div class="field">
							<label>LinkedIn status</label> <input type="text"
								ng-model="newStudent.linkedInConnectionStatus"
								name="linkedInConnectionStatus" placeholder="Status" />
						</div>
					</div>

					<button
						ng-click="vm.addStudent(newStudent, startEducation, endEducation, dateOfBirth)"
						class="ui positive right labeled icon button" type="submit">
						<i class="plus icon"></i>Cre&euml;er student
					</button>
					<br>
				</form>
				<br>
			</div>
		</div>
	

	<div class="ui modal updatestudent">
		<div class="ui main text container padded">
			<h3>Wijzig student : {{vm.currenttStudent.firstName}} {{vm.currentStudent.lastName}}</h3>
			<form class="ui form" ng-model="vm.currentStudent"
				id="updateStudentForm">
				<div class="field">
					<label>Naam </label>
					<div class="two fields">
						<div class="field">
							<input type="text" ng-model="vm.currentStudent.firstName"
								name="firstName" placeholder="Voornaam"
								value="{{vm.currentStudent.firstName}}" required autofocus />
						</div>
						<div class="field">
							<input type="text" ng-model="vm.currentStudent.lastName"
								name="lastName" placeholder="Achternaam" value="Bleep" required />
						</div>
					</div>
				</div>

				<div class="field">
					<label>Contact </label>
					<div class="two fields">
						<div class="field">
							<input type="email" ng-model="vm.currentStudent.email"
								name="email" placeholder="Email" required />
						</div>
						<div class="field">
							<input input="text" ng-model="vm.currentStudent.phone"
								name="phone" placeholder="Telefoonnummer" value="01208" />
						</div>
					</div>
				</div>

				<div class="field">
					<label>Geboortedatum </label> <input
						ng-model="dateOfBirth" type="date"
						name="dateOfBirth" id="dateOfBirth" />
				</div>

				<div class="fields">
					<div class="five wide field">
						<label>School</label> <select
							ng-model="vm.currentStudent.university"
							ng-options="u as u.name for u in vm.universities"
							name="university">
							<option class="noneOption"></option>
						</select>
					</div>
					<div class="five wide field">
						<label>Opleiding </label> <select
							ng-model="vm.currentStudent.education"
							ng-options="e as e.name for e in vm.educations" name="education">
							<option class="noneOption"></option>
						</select>
					</div>
					<div class="three wide field">
						<label>Begin</label> <input type="date"
							ng-model="startEducation" id="startEducation"
							name="startEducation" />
					</div>
					<div class="three wide field">
						<label>Eind</label> <input type="date"
							ng-model="endEducation" id="endEducation"
							name="endEducation" />
					</div>
				</div>

				<div class="two fields">
					<div class="field">
						<label>Bron</label> <input type="text"
							ng-model="vm.currentStudent.contactOrigin" name="contactOrigin"
							placeholder="Bron" />
					</div>
					<div class="field">
						<label>LinkedIn status</label> <input type="text"
							ng-model="vm.currentStudent.linkedInConnectionStatus"
							name="linkedInConnectionStatus" placeholder="Status" />
					</div>
				</div>

				<button
					ng-click="vm.updateStudent(vm.currentStudent, startEducation, endEducation, dateOfBirth)"
					class="ui positive right labeled icon button" type="submit">
					<i class="plus icon"></i>Wijzig student
				</button>
				<br>
			</form>
			<br>
		</div>
	</div>
	</div>
	<%@include file="../includes/footer.jsp"%>
	<script src="<c:url value="/resources/js/pages/recruiterModule.js" />"></script>
	<script
		src="<c:url value="/resources/js/pages/recruiterStudentController.js" />"></script>
	<script src="<c:url value="/resources/js/moments.js" />"></script>
</body>
</html>