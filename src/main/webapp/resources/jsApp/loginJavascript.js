function validarCamposCompletos() {
	var textUsuario = document.getElementById("user");
	var textPassword = document.getElementById("password");

	if (textUsuario.value.length == 0 && textPassword.value.length == 0) {
		alert("Falta agregar el usuario y la contrase�a");
		return false;
	}

	if (textUsuario.value.length == 0 && !textPassword.value.length == 0) {
		alert("Falta agregar el usuario");
		return false;
	}
	if (!textUsuario.value.length == 0 && textPassword.value.length == 0) {
		alert("Falta agregar la contrase�a");
		return false;
	}
	return true;
}

//function createSelectOption() {
//	var select_option = '<form:select path="edad" class="form-control">';
//	for (i = 18; i <= 80; i++) {
//		select_option += '<form:option value=' + i + '>' + i + '</form:option>';
//	}
//	select_option += '</form:select>';
//	document.getElementById('xx').innerHTML = select_option;
//
//}