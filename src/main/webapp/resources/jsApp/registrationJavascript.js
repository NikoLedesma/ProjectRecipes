/**
 * 
 */

function verificarCamposCompletos(array) {
	for ( var a in array) {
		/*
		 * if(array[a].type!="password" ){ alert(array[a].value); }
		 * 
		 * if (array[a].type=="password"){ alert("falta agregar el
		 * password...!!!"); }
		 */
		if (array[a].value == "") {
			alert("faltan completar campos...!!!");
			return false;
		}
	}
	return true;
}



function verificarAltura(altura){
	if(isNaN(altura.value)){
		alert("La altura debe ser un numero....");
		return false;
	}
	return true;
}


function validarCampos() {
	var usuario = document.getElementById("usuario");
	var password = document.getElementById("password");
	var nombre = document.getElementById("nombre");
	var altura = document.getElementById("altura");
	var edad = document.getElementById("edad");
	var campos = [ usuario, password, nombre, altura ];

	if (verificarCamposCompletos(campos)) {
		verificarAltura(altura);
	}	
	if (edad.options[edad.selectedIndex].value == -1) {
		alert("Falta ingresar la edad...!");
	}
	return true;
}