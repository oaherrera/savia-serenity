Feature: Cargue de los archivos Rips, y procesamiento de los mismos 
	Yo como usuario requiero cargar, procesar y gestionar archivos Rips de las diferentes modalidades
	Capita, Evento y PGP
	
Background: 
	Given me autentico con audliqreg y contraseña conexia2017 

@CargarRipsDeCapita 
Scenario: Carga Archivos rips de modalidad Capita 
	When Ingreso al modulo de Cuenta, a Validar RIPS 
	And Diligencio el formulario de Cargue y Vaidación de Rips 
		| ips 		 | sede 					  | mesPrestacion | anhoPrestacion | nroCuenta | valorCuenta | regimen      | controto         | modalidad | responsableDePago | regional           |
		| METROSALUD | CENTRO DE SALUD SAN BLAS   | Junio         | 2019           | 020       | 816000534   | CONTRIBUTIVO | 0068-2019-01-211 | CAPITA    | EPS SAVIA SALUD   | Regional Antioquia | 
	And Adjunto el o los archivos de Rips y los Cargo 
		| archivos |
		| C:/Carga/Load/RIPS/RIPS_CAPITA/RIP_CAPITA_1.zip |
	And Consulto el estado de la cuenta gestionada para la ips 
		| ips | nroCuenta | 
		| METROSALUD | 020 |      
	Then La cuenta se encuentra en estado 
		| cuenta | estadoCuenta |
		| 020 | PENDIENTE VALIDACIÓN |
		
@GestionarCuentaEnviarAVerificarEPS 
Scenario: Envio la cuenta validada a Homologacion 
	When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas 
	And Consulto el estado de la cuenta gestionada para la ips 
		| ips | nroCuenta | 
		| METROSALUD | 020 |    
	And Gestiono la encuenta, Enviar a Verificación EPS 
	And Consulto el estado de la cuenta gestionada para la ips 
		| ips | nroCuenta | 
		| METROSALUD | 020 | 
	Then La cuenta se encuentra en estado 
		| cuenta | estadoCuenta |
		| 020 | ENVIADO |
		
@RevisarFacturasCuentaEps 
Scenario: Reviso como EPS las facturas de la cuenta 
	When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS 
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta | 
		| 020 |
	And Gestiono la encuenta como Eps, Revisión y Devolución de cuentas 
	And Marco la cuenta con todas las Facturas como Revisado 
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta | 
		| 020 |
	Then La cuenta se encuentra por la Eps en estado 
		| cuenta | estadoCuenta |
		| 020 | REVISADO |
		
@RegostroCuentaEps
Scenario: Registro como EPS las cuenta 
	When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS 
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta | 
		| 020 |
	And Gestiono la encuenta como Eps, Registrar Cuenta EPS
	And Radico la cuenta con la Eps 
		| regional | responsableDePago | Observaciones |
		| Regional Antioquia | EPS SAVIA SALUD | Observaciones |
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta | 
		| 020 |
	Then La cuenta se encuentra por la Eps en estado 
		| cuenta | estadoCuenta |
		| 020 | PROCESANDO CUENTA |