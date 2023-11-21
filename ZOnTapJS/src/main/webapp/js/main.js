var myName = document.querySelector("#name1");
console.log(myName)

var output = document.querySelector("#output");

myName.oninput = function(e){
	if(e.target.value === ""){
		output.innerText = ``;
	} else {
		output.innerText = `Xin chao: ${e.target.value}`;
	}
}

var btnChange = document.querySelector("#btnChange");
var div2 = document.querySelector("#div2");
btnChange.onclick = function(e){
	div2.innerHTML = `Tao thay doi roi thang loz`;
}

div2.onmouseover = function(e){
	div2.style.backgroundColor = "green";
}
div2.onmouseout = function(e){
	div2.style.backgroundColor = "red";
}

var hide = document.querySelector("#btnHide");
hide.onclick = function(e) {
	div2.classList.toggle("disPlayNone");
}

var password = document.querySelector("#password");
var username = document.querySelector("#username");
var spUS = document.querySelector("#spUS");
var spPW = document.querySelector("#spPW");


username.onblur = function(){
	alert("Blur");
}










