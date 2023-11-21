 
function Validator(job) {
	var workplace = document.querySelector(job.workplace);
	var listRule = {};
	
	workplace.onsubmit = function(e) {
		e.preventDefault();
		
		job.rules.forEach(function(rule) {
			var workplaceElement = workplace.querySelector(rule.select);
			
			validate(workplaceElement, rule);
			
		});
	}
	
	function getParent(workplaceElement, parent) {
		while(workplaceElement.parentElement){
			if(workplaceElement.parentElement.matches(parent)) {
				return workplaceElement.parentElement;
			}
			workplaceElement = workplaceElement.parentElement;
		}
	}
	
	function validate(workplaceElement, rule) {
		var errorMessage = "";
		for(var i = 0; i < listRule[rule.select].length; i++){
			switch(workplaceElement.type){
					case "radio":
					case "checkbox":
						errorMessage = listRule[rule.select][i](workplace.querySelector(rule.select + ":checked") ? workplace.querySelector(rule.select + ":checked").value : undefined)
						break; 
					default:
						errorMessage = listRule[rule.select][i](workplaceElement.value)
						break;
					
			};
			if(errorMessage){
				break;
			}
		}
		
		if(errorMessage){
			getParent(workplaceElement, job.formGroupSelector).querySelector(".errorHelp").innerHTML = errorMessage;
			getParent(workplaceElement, job.formGroupSelector).querySelector(".errorHelp").style.color = "red";
		} else {
			getParent(workplaceElement, job.formGroupSelector).querySelector(".errorHelp").innerHTML = "";
		}
		
		return errorMessage;
	}
	
	job.rules.forEach(function(rule) {
		var workplaceElements = workplace.querySelectorAll(rule.select);
		
		if(Array.isArray(listRule[rule.select])){
			listRule[rule.select].push(rule.test)
		} else {
			listRule[rule.select] = [rule.test];
		}
		
		Array.from(workplaceElements).forEach(function(workplaceElement){
			workplaceElement.onblur = function() {
				validate(workplaceElement, rule);
			};
		})
	})
}




Validator.isRequired = function(select, message) {
	return {
		select: select,
		test: function(value) {
			return value ? undefined : message || "Vui lòng nhập trường này";
		}
	}
}

Validator.isEmail = function(select, message) {
	return {
		select: select,
		test: function(value) {
			var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			return regex.test(value) ? undefined :  message || 'Trường này phải là email';
		}
	}
}


Validator.isLengthMin = function(select, minValue, message) {
	return {
		select: select,
		test: function(value) {
			var min = minValue ? minValue : 6
			return value.length >= min ? undefined :  message || `Trường này phải chứa ít nhất ${min} ký tự`;
		}
	}
}

Validator.isConfirm = function(select, confirm, message) {
	return {
		select: select,
		test: function(value) {
			return value == confirm() ? undefined :  message || `Trường này nhập không đúng`;
		}
	}
}






// code cua f8

// Đối tượng `Validator`
/*
function Validator(options) {
    function getParent(element, selector) {
        while (element.parentElement) {
            if (element.parentElement.matches(selector)) {
                return element.parentElement;
            }
            element = element.parentElement;
        }
    }

    var selectorRules = {};

    // Hàm thực hiện validate
    function validate(inputElement, rule) {
        var errorElement = getParent(inputElement, options.formGroupSelector).querySelector(options.errorSelector);
        var errorMessage;

        // Lấy ra các rules của selector
        var rules = selectorRules[rule.selector];
        
        // Lặp qua từng rule & kiểm tra
        // Nếu có lỗi thì dừng việc kiểm
        for (var i = 0; i < rules.length; ++i) {
            switch (inputElement.type) {
                case 'radio':
                case 'checkbox':
                    errorMessage = rules[i](
                        formElement.querySelector(rule.selector + ':checked')
                    );
                    break;
                default:
                    errorMessage = rules[i](inputElement.value);
            }
            if (errorMessage) break;
        }
        
        if (errorMessage) {
            errorElement.innerText = errorMessage;
            getParent(inputElement, options.formGroupSelector).classList.add('invalid');
        } else {
            errorElement.innerText = '';
            getParent(inputElement, options.formGroupSelector).classList.remove('invalid');
        }

        return !errorMessage;
    }

    // Lấy element của form cần validate
    var formElement = document.querySelector(options.form);
    if (formElement) {
        // Khi submit form
        formElement.onsubmit = function (e) {
            e.preventDefault();

            var isFormValid = true;

            // Lặp qua từng rules và validate
            options.rules.forEach(function (rule) {
                var inputElement = formElement.querySelector(rule.selector);
                var isValid = validate(inputElement, rule);
                if (!isValid) {
                    isFormValid = false;
                }
            });

            if (isFormValid) {
                // Trường hợp submit với javascript
                if (typeof options.onSubmit === 'function') {
                    var enableInputs = formElement.querySelectorAll('[name]');
                    var formValues = Array.from(enableInputs).reduce(function (values, input) {
                        
                        switch(input.type) {
                            case 'radio':
                                values[input.name] = formElement.querySelector('input[name="' + input.name + '"]:checked').value;
                                break;
                            case 'checkbox':
                                if (!input.matches(':checked')) {
                                    values[input.name] = '';
                                    return values;
                                }
                                if (!Array.isArray(values[input.name])) {
                                    values[input.name] = [];
                                }
                                values[input.name].push(input.value);
                                break;
                            case 'file':
                                values[input.name] = input.files;
                                break;
                            default:
                                values[input.name] = input.value;
                        }

                        return values;
                    }, {});
                    options.onSubmit(formValues);
                }
                // Trường hợp submit với hành vi mặc định
                else {
                    formElement.submit();
                }
            }
        }

        // Lặp qua mỗi rule và xử lý (lắng nghe sự kiện blur, input, ...)
        options.rules.forEach(function (rule) {

            // Lưu lại các rules cho mỗi input
            if (Array.isArray(selectorRules[rule.selector])) {
                selectorRules[rule.selector].push(rule.test);
            } else {
                selectorRules[rule.selector] = [rule.test];
            }

            var inputElements = formElement.querySelectorAll(rule.selector);

            Array.from(inputElements).forEach(function (inputElement) {
               // Xử lý trường hợp blur khỏi input
                inputElement.onblur = function () {
                    validate(inputElement, rule);
                }

                // Xử lý mỗi khi người dùng nhập vào input
                inputElement.oninput = function () {
                    var errorElement = getParent(inputElement, options.formGroupSelector).querySelector(options.errorSelector);
                    errorElement.innerText = '';
                    getParent(inputElement, options.formGroupSelector).classList.remove('invalid');
                } 
            });
        });
    }

}



// Định nghĩa rules
// Nguyên tắc của các rules:
// 1. Khi có lỗi => Trả ra message lỗi
// 2. Khi hợp lệ => Không trả ra cái gì cả (undefined)
Validator.isRequired = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return value ? undefined :  message || 'Vui lòng nhập trường này'
        }
    };
}

Validator.isEmail = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            return regex.test(value) ? undefined :  message || 'Trường này phải là email';
        }
    };
}

Validator.minLength = function (selector, min, message) {
    return {
        selector: selector,
        test: function (value) {
            return value.length >= min ? undefined :  message || `Vui lòng nhập tối thiểu ${min} kí tự`;
        }
    };
}

Validator.isConfirmed = function (selector, getConfirmValue, message) {
    return {
        selector: selector,
        test: function (value) {
            return value === getConfirmValue() ? undefined : message || 'Giá trị nhập vào không chính xác';
        }
    }
}
*/

/*

document.addEventListener('DOMContentLoaded', function () {
        // Mong muốn của chúng ta
        Validator({
          form: '#form-1',
          formGroupSelector: '.form-group',
          errorSelector: '.form-message',
          rules: [
            Validator.isRequired('#fullname', 'Vui lòng nhập tên đầy đủ của bạn'),
            Validator.isEmail('#email'),
            Validator.minLength('#password', 6),
            Validator.isRequired('#password_confirmation'),
            Validator.isConfirmed('#password_confirmation', function () {
              return document.querySelector('#form-1 #password').value;
            }, 'Mật khẩu nhập lại không chính xác')
          ],
          onSubmit: function (data) {
            // Call API
            console.log(data);
          }
        });


        Validator({
          form: '#form-2',
          formGroupSelector: '.form-group',
          errorSelector: '.form-message',
          rules: [
            Validator.isEmail('#email'),
            Validator.minLength('#password', 6),
          ],
          onSubmit: function (data) {
            // Call API
            console.log(data);
          }
        });
});

*/




