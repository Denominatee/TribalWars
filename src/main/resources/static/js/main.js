document.getElementById("create").addEventListener("click", create);
function create() {
	$.ajax({
		type : "POST",
		url : 'http://192.168.56.102:8080/create'
	}).done(function() {
	});
}
document.getElementById("login").addEventListener("click", login);
function login() {
	$.ajax({
		type : "POST",
		url : 'http://192.168.56.102:8080/login'
	}).done(function() {
	});
}
document.getElementById("build").addEventListener("click", build);
function build() {
	$.ajax({
		type : "POST",
		url : 'http://localhost:8080/build'
	}).done(function() {
	});
}
document.getElementById("events").addEventListener("click", events);
function events() {
	$.ajax({
		type : "POST",
		url : 'http://localhost:8080/events'
	}).done(function() {
	});
}
document.getElementById("scan").addEventListener("click", scan);
function scan() {
	$.ajax({
		type : "POST",
		url : 'http://localhost:8080/scan'
	}).done(function() {
	});
}
document.getElementById("testButton1").addEventListener("click", onStart1);
function onStart1() {
	$.ajax({
		type : "POST",
		url : 'http://localhost:8080/test1'
	}).done(function() {
		  console.log("doneee");
	});
}
document.getElementById("testButton2").addEventListener("click", onStart2);
function onStart2() {
	$.ajax({
		type : "POST",
		url : 'http://localhost:8080/test2'
	}).done(function() {
		  console.log("doneee");
	});
}