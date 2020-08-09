Feature: Cargue de los archivos Rips, y procesamiento de los mismos 
	Yo como usuario requiero cargar, procesar y gestionar archivos Rips de las diferentes modalidades
  Capita, Evento y PGP

Background: 
	Given me autentico con jlregional y contraseña pruebas 
	
@CargarRipsDeEvento 
Scenario: Carga Archivos rips de modalidad Evento 
	When Ingreso al modulo de Liquidación de Prestaciones, a Kiosko EPS 
	And Ingreso al logueo de la ips ESE PASTO SALUD - HOSPITAL LOCAL CIVIL - PASTO ( NARIÑO ) 
	And Diligencio el formulario de Cargue y Vaidación de Rips 
		| ips                                                       | mesPrestacion | anhoPrestacion | nroCuenta  | valorCuenta | contrato      | regional                   | responsableDePago    | tipoDeServicio |
		| ESE PASTO SALUD - HOSPITAL LOCAL CIVIL - PASTO ( NARIÑO ) | Febrero       |           2018 |   3450013  |        2000 | 372-1ES180003 | Regional Nariño - Putumayo | EPS EMSSANAR ESS RNP | Subsidiado     |
	And Adjunto el o los archivos de Rips y los Cargo 
		| archivos                                                        |
		| C:/Users/oherrera/Downloads/rips_mayo_homologacion/AC000062.txt |
		| C:/Users/oherrera/Downloads/rips_mayo_homologacion/AF000062.txt |
		| C:/Users/oherrera/Downloads/rips_mayo_homologacion/AM000062.txt |
		| C:/Users/oherrera/Downloads/rips_mayo_homologacion/CT000062.txt |
		| C:/Users/oherrera/Downloads/rips_mayo_homologacion/US000062.txt |
		
@validarCuenta_EnviarAHomologacion 
Scenario: 
	Validación de la cuenta que este en estado validado y enviar a homologacion 
	When Ingreso al modulo de Liquidación de Prestaciones, a Kiosko EPS 
	And para Ingreso al logueo de la ips ESE PASTO SALUD - HOSPITAL LOCAL CIVIL - PASTO ( NARIÑO ) para validar la cuenta 
	And Consulto el estado de la cuenta 3450013 gestionada para la ips 
	And La cuenta se encuentra en estado 
		| cuenta  | estadoCuenta|
		| 3450013 | VALIDADO    |
	And envio al proceso de homologacion 
	
	
@validarEstadoDeLaCuenta_FinalizarHomologacion
Scenario: Validación de la cuenta en estado pendiente homologación y finalizar 
	When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS 
	And Consulto el estado de la cuenta 3450013 gestionada para la ips en gestion cuentas EPS
	And se valida el estado de la cuenta en gestion de cuentas EPS 
		| cuenta   | estadoCuenta          |
		| 3450013  | PENDIENTE HOMOLOGACION|
	And Gestiono la encuenta, Finalizar homologación
	
	
	
	
	
	@validarEstadoDeLaCuenta_EnviaAVerificaciónEPS
	Scenario: Validación de la cuenta en estado Homologación Terminada y enviar a Verificación EPS
	When Ingreso al modulo de Liquidación de Prestaciones, a Kiosko EPS 
	And para Ingreso al logueo de la ips ESE PASTO SALUD - HOSPITAL LOCAL CIVIL - PASTO ( NARIÑO ) para validar la cuenta
	And Consulto el estado de la cuenta 3450013 gestionada para la ips 
	And La cuenta se encuentra en estado 
		| cuenta  | estadoCuenta          |
		| 3450013 | HOMOLOGACION TERMINADA|
	And Gestiono la encuenta, Enviar a Verificación EPS  
	When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS 
	And Consulto el estado de la cuenta 3450013 gestionada para la ips en gestion cuentas EPS
	And se valida el estado de la cuenta en gestion de cuentas EPS 
		| cuenta   | estadoCuenta|
		| 3450013  | EN PROCESO  |
	And Gestiono la encuenta como Eps, Devolución EPS 
	And Marco la cuenta con todas las Facturas como Revisado 
	And Consulto el estado de la cuenta 3450013 gestionada para la ips en gestion cuentas EPS
	And se valida el estado de la cuenta en gestion de cuentas EPS 
		| cuenta   | estadoCuenta|
		| 3450013  | REVISADO    |
	And Gestiono la encuenta como Eps, Registrar Cuenta EPS
	
	And Radico la cuenta con la Eps
		| regional                   | claseDeServicio          | responsableDePago    |observaciones|
		| Regional Nariño - Putumayo | Promoción y prevención   | EPS EMSSANAR ESS RNP |observaciones|
	
	And se valida el estado de la cuenta en gestion de cuentas EPS 
		| cuenta   | estadoCuenta      |
		| 3450013  | PROCESANDO CUENTA |
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RegostroCuentaEps 
Scenario: Registro como EPS las cuenta 
	When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS 
	And Consulto el estado de la cuenta 3450010 gestionada para la ips en gestion cuentas EPS
	And se valida el estado de la cuenta en gestion de cuentas EPS 
		| cuenta   | estadoCuenta|
		| 3450010  | REVISADO    |
	And Gestiono la encuenta como Eps, Registrar Cuenta EPS
	And Radico la cuenta con la Eps
		| regional                   | claseDeServicio          | responsableDePago    |observaciones|
		| Regional Nariño - Putumayo | Promoción y prevención   | EPS EMSSANAR ESS RNP |observaciones|
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta |
		|       030 |
	Then La cuenta se encuentra por la Eps en estado 
		| cuenta | estadoCuenta      |
		|    030 | PROCESANDO CUENTA |
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RevisarFacturasCuentaEps 
Scenario: Reviso como EPS las facturas de la cuenta 
	When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS 
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta |
		|       030 |
	And Gestiono la encuenta como Eps, Devolución EPS 
	And Marco la cuenta con todas las Facturas como Revisado 
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta |
		|       030 |
	Then La cuenta se encuentra por la Eps en estado 
		| cuenta | estadoCuenta |
		|    030 | REVISADO     |
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
@GestionarCuentaFinalizarHomologacion 
Scenario: Finalizar Homologacion de cuenta 
	When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS 
	#	And Consulto el estado de la cuenta gestionada para la ips
	#		| ips        | nroCuenta |
	#		| METROSALUD |       030 |
	And Consulto el estado de la cuenta 3456781 gestionada para la ips 
	##And Gestiono la encuenta, Finalizar homologación 
	##	And Consulto el estado de la cuenta gestionada para la ips 
	#		| ips        | nroCuenta |
	#		| METROSALUD |       030 |
	#	Then La cuenta se encuentra en estado 
	#		| cuenta | estadoCuenta           |
	#		|    030 | PENDIENTE HOMOLOGACION |
	#	
	
	
	
	
	
	
	
	
	
	
	#@GestionarCuentaFinalizarHomologacion 
	#Scenario: Envio la cuenta validada a Homologacion 
	#	When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas 
	#	And Consulto el estado de la cuenta gestionada para la ips 
	#		| ips        | nroCuenta |
	#		| METROSALUD |       030 |
	#	And Gestiono la encuenta, Finalizar homologación 
	#	And Consulto el estado de la cuenta gestionada para la ips 
	#		| ips        | nroCuenta |
	#		| METROSALUD |       030 |
	#	Then La cuenta se encuentra en estado 
	#		| cuenta | estadoCuenta           |
	#		|    030 | HOMOLOGACION TERMINADA |
	#		
@GestionarCuentaEnviarAVerificarEPS 
Scenario: Envio la cuenta validada a Homologacion 
	When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas 
	And Consulto el estado de la cuenta gestionada para la ips 
		| ips        | nroCuenta |
		| METROSALUD |       030 |
	And Gestiono la encuenta, Enviar a Verificación EPS 
	And Consulto el estado de la cuenta gestionada para la ips 
		| ips        | nroCuenta |
		| METROSALUD |       030 |
	Then La cuenta se encuentra en estado 
		| cuenta | estadoCuenta |
		|    030 | ENVIADO      |
		
@RevisarFacturasCuentaEps 
Scenario: Reviso como EPS las facturas de la cuenta 
	When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS 
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta |
		|       030 |
	And Gestiono la encuenta como Eps, Revisión y Devolución de cuentas 
	And Marco la cuenta con todas las Facturas como Revisado 
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta |
		|       030 |
	Then La cuenta se encuentra por la Eps en estado 
		| cuenta | estadoCuenta |
		|    030 | REVISADO     |
		
@RegostroCuentaEps 
Scenario: Registro como EPS las cuenta 
	When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS 
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta |
		|       030 |
	And Gestiono la encuenta como Eps, Registrar Cuenta EPS 
	And Radico la cuenta con la Eps 
		| regional           | responsableDePago | Observaciones |
		| Regional Antioquia | EPS SAVIA SALUD   | Observaciones |
	And Consulto como Eps el estado de la cuenta 
		| nroCuenta |
		|       030 |
	Then La cuenta se encuentra por la Eps en estado 
		| cuenta | estadoCuenta      |
		|    030 | PROCESANDO CUENTA |
