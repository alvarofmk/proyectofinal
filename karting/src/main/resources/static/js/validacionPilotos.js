	document.getElementById("nombrePiloto").addEventListener("blur",comprobarNombre);
	document.getElementById("apellidosPiloto").addEventListener("blur",comprobarApellidos);
	document.getElementById("dniPiloto").addEventListener("blur",comprobarDni);
	document.getElementById("imgPiloto").addEventListener("blur",comprobarImg);
	document.getElementById("emailPiloto").addEventListener("blur",comprobarEmail);
	document.getElementById("fechaNacimiento").addEventListener("blur",comprobarEdad);


function validarFormulario(){
	let resultado = false;

	resultado = comprobarEdad();

	return resultado;
}

function comprobarNombre(){
	
}

function comprobarApellidos(){
	
}
function comprobarDni(){
	
}
function comprobarImg(){
	
}
function comprobarEmail(){
	
}
function comprobarEdad(){
	let fecha = formPilotos.fechaNacimiento;
	let resultado = fecha.value!="";
	
	if(resultado){
		let fechaDate = fecha.valueAsDate;
		let hoy = new Date();

		let anyos = hoy.getYear()-fechaDate.getYear();		
		
		resultado = anyos>=6;
		
	}
	
	return resultado;
}