	document.getElementById("fechaSesion").addEventListener("blur",comprobarReserva);
	
	document.querySelectorAll(".errorForm").forEach(p => p.hidden = true);

function validarFormulario(){
	let resultado = false;

	resultado = comprobarReserva();

	return resultado;
}
function comprobarReserva(){
	let fecha = formSesiones.fechaSesion;
	let correcto = fecha.value!="" && Date.parse(fecha.value) > Date.now();
	
	if(correcto){
		fecha.nextElementSibling.hidden = true;
	}else{
		fecha.nextElementSibling.hidden = false;
	}
	
	return correcto;
}