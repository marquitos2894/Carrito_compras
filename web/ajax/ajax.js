function getXMLHTTPRequest() {
	var req;
	try {
		req = new XMLHttpRequest();
	} catch(err1) {
		try {
			req = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (err2) {
			try {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (err3) {
				req = false;
			}
		}
	}
	return req;
}

function MostrarConsulta(datos,div){
//alert(datos);
//alert(div);
divResultado = document.getElementById(div);
nomb = document.getElementById("nombre").value;
//alert(combo);
ajax =objetoAjax();
pagina=datos+"?nombre="+nomb;
ajax.open("GET", pagina);
ajax.onreadystatechange=function() {
if (ajax.readyState == 4) {
divResultado.innerHTML = ajax.responseText
}
}
ajax.send(null)
}