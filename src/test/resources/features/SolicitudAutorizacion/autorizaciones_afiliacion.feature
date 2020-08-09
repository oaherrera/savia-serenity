Feature: Solicitudes Autorizacion para afiliacion 
	Yo como usuario requiero crear soicitudes de autorizacion de los siguientes tipos:
	Autorizacion PBS, Autorizacion No PBS, Autorizacion PBS Condicionada
	
Background: 
	Given me autentico con jenny.ocampo@saviasaludeps.com y contraseña 1017174219
	And Consulto afiliado con Cédula de ciudadanía Nro 1015186940  en Autorizaciones
	
Scenario: Crear solicitud Autorización 
	When Diligencio el formulario de autorizaciones con los datos MEDICINA GENERAL (CONSULTA EXTERNA),GENERAL 
	And Asocio la sede con razon social HOSPITAL PABLO TOBON URIBE
	And Asigno el profesional identifacado con Cédula de ciudadanía, 5024008
	And Asocio Diagnostico con el codigo A040
	And Agrego procedimiento con el id 210402 CONTROL DE EPISTAXIS, POR LIGADURA DE ARTERIAS ETMOIDALES VIA ENDOSCOPICA
	And Agrego medicamento con el id 0127 : ACETAMINOFEN 100 MG TABLETA MASTICABLE, del Diagnostico A040
	And Agrego insumo con el id 962701100 - 9/10 ULTAMET 28MM HEADS +0 (JOHNSON), del Diagnostico A040
	And Diligencio campos complementarios de la autorizacion
	And Ajunto soporte fisico formato PDF ubicado en la ruta C:/Carga/Load/Anexo3.pdf de Tipo Fórmula médica
	And Envio la solicitud a Validar
	Then Se debe generar una solicitud de afiliacion anexo4  