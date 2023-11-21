<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>From Validation</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	</head>
	
	<body class="container pt-4">
		<h1 class="text-center">Đăng ký thành viên</h1>
		<p class="text-center">Cùng nhau học lập trình miễn phí tại DungVipPro.com</p>
		
		<form action="#" method="get" id="from-1" class="mt-4">
			<div class="mb-3 form-group">
				<label for="fullName" class="form-label">Tên đầy đủ</label> 
				<input type="text" class="form-control" id="fullName" placeholder="VD: Đức Dũng">
				<div id="fullNameHelp" class="form-text errorHelp"></div>
			</div>
			<div class="mb-3 form-group">
				<label for="age" class="form-label">Tuổi</label> 
				<input type="text" class="form-control" id="age" placeholder="VD: 18">
				<div id="ageHelp" class="form-text errorHelp"></div>
			</div>
			<div class="mb-3 form-group">
				<label for="phone" class="form-label">Số điện thoại</label> 
				<input type="text" class="form-control" id="phone" placeholder="VD: 0906786902">
				<div id="phoneHelp" class="form-text errorHelp"></div>
			</div>
			<div class="mb-3 form-group">
				<label for="inputEmail1" class="form-label">Email</label> 
				<input type="email" class="form-control" id="inputEmail1" aria-describedby="emailHelp" placeholder="VD: email@gamil.com">
				<div id="emailHelp" class="form-text errorHelp"></div>
			</div>
			<div class="mb-3 form-group">
				<label for="inputPassword" class="form-label">Mật khẩu</label>
				<input type="password" class="form-control" id="inputPassword" placeholder="Nhập mật khẩu">
				<div id="passwordHelp" class="form-text errorHelp"></div>
			</div>
			<div class="mb-3 form-group">
				<label for="inputConformPassword" class="form-label">Nhập lại mật khẩu</label>
				<input type="password" class="form-control" id="inputConformPassword" placeholder="Nhập lại mật khẩu">
				<div id="conformPasswordHelp" class="form-text errorHelp"></div>
			</div>
			<div class="mb-3 form-group">
			 	<label for="formFile" class="form-label">Default file input example</label>
			  	<input class="form-control" type="file" id="formFile">
			  	<div id="fileHelp" class="form-text errorHelp"></div>
			</div>
			<div class="mb-3 form-group">
			 	<select class="form-select" id="province" name="province" aria-label="Default select example">
				  	<option value="" selected>Open this select menu</option>
				  	<option value="1">One</option>
				  	<option value="2">Two</option>
				  	<option value="3">Three</option>
				</select>
				<div id="selectHelp" class="form-text errorHelp"></div>
			</div>
			<div class="mb-3 form-group">
				<label>CheckBox</label>
				<div class="form-check mt-2">
					<input class="form-check-input ckb" type="checkbox" value="html" id="flexCheckDefault">
				  	<label class="form-check-label" for="flexCheckDefault"> HTML </label>
				</div>
				<div class="form-check">
				  	<input class="form-check-input ckb" type="checkbox" value="css" id="flexCheckChecked">
				  	<label class="form-check-label" for="flexCheckChecked"> CSS </label>
				</div>
				<div id="checkBoxHelp" class="form-text errorHelp"></div>
			</div>
			<div class="mb-3 form-group">
				<label>Radio</label>
				<div class="form-check mt-2">
				  	<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="nam">
				  	<label class="form-check-label" for="flexRadioDefault1"> Nam </label>
				</div>
				<div class="form-check">
				  	<input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" value="nu""> 
				  	<label class="form-check-label" for="flexRadioDefault2"> Nữ </label>
				</div>
				<div id="radioHelp" class="form-text errorHelp"></div>
			</div>
			<div class="mb-3 d-flex flex-column">
				<button type="submit" class="btn btn-primary">Đăng ký</button>
			</div>
		</form>


		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
		<script src="./js/validation.js"></script>
		<script>
			Validator({
				workplace: "#from-1",
				formGroupSelector: '.form-group',
				rules: [
					Validator.isRequired("#fullName"),
					Validator.isRequired("#age"),
					Validator.isRequired("#phone"),
					Validator.isRequired("#inputEmail1"),
					Validator.isEmail("#inputEmail1"),
					Validator.isRequired("#inputPassword"),
					Validator.isLengthMin("#inputPassword"),
					Validator.isRequired("#inputConformPassword"),
					Validator.isLengthMin("#inputConformPassword"),
					Validator.isConfirm("#inputConformPassword", function() {
						return document.querySelector("#inputPassword").value
					}),
					Validator.isRequired("#formFile"),
					Validator.isRequired("#province"),
					Validator.isRequired("input[name='flexRadioDefault']"),
					Validator.isRequired("input[type='checkbox']"),
				]
			});
		</script>
	</body>
</html>














