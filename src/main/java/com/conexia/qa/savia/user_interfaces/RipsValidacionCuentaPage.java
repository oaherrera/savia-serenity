package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RipsValidacionCuentaPage {
	public static final Target IPS = Target.the("Ips").locatedBy("//input[contains(@id,'formValidarRips:sedeIps_input')]");
	public static final Target IPS_SELECCION = Target.the("Ips")
			.locatedBy("//li[contains(@class,'ui-autocomplete-item') and @data-item-label='{0}']");
	public static final Target SEDE = Target.the("Sede").locatedBy("//input[contains(@id,'sedeIps_input')]");
	public static final Target SEDE_SELECCION = Target.the("Sede").locatedBy(
			"//div[contains(@id,'sedeIps_panel')]/ul/li[contains(@class,'ui-autocomplete-list-item') and @data-item-label='{0}']");
	public static final Target MES_DE_PRESTACION = Target.the("Mes de prestación")
			.locatedBy("//label[contains(@id,'mesPrestacion_label')]");
	public static final Target MES_DE_PRESTACION_SELECCION = Target.the("Mes de prestación")
			.locatedBy("//li[contains(@id,'mesPrestacion') and text()='{0}']");
	public static final Target ANHO_DE_PRESTACION = Target.the("Año de prestación")
			.locatedBy("//label[contains(@id,'anioPrestacion_label')]");
	public static final Target ANHO_DE_PRESTACION_SELECCION = Target.the("Año de prestación")
			.locatedBy("//li[contains(@id,'anioPrestacion_') and text()='{0}']");
	public static final Target NUMERO_DE_CUENTA = Target.the("Numero de Cuenta")
			.locatedBy("//input[contains(@id,':noCuenta')]");
	public static final Target VALOR_CUENTA = Target.the("Valor de la cuenta")
			.locatedBy("//input[contains(@id,':valorCuenta_input')]");
	public static final Target LUPA_BUSCAR_CONTRATO = Target.the("Lupa Buscar Contrato")
			.locatedBy("//button[contains(@id,'formValidarRips:btnBuscarContrato')]");
	public static final Target INPUT_NUMERO_CONTRATO = Target.the("Input Numero de Contrato")
			.locatedBy("//input[contains(@id,'formBuscarContrato:noContratoBusqueda')]");
	public static final Target BUSCAR_CONTRATO = Target.the("Buscar Contrato").
			locatedBy("//button[contains(@id,':formBuscarContrato:buscarContratos')]");
	
	public static final Target SELECCIONAR = Target.the("Seleccionar")
			.locatedBy("(//button[contains(@id,'formBuscarContrato:tableBusquedaContratos')])[1]");
	public static final Target REGIONAL = Target.the("Regional")
			.locatedBy("//label[contains(@id,':regionalMenu_label')]");
	public static final Target REGIONAL_SELECCION = Target.the("Regional")
			.locatedBy("//li[contains(@id,':regionalMenu_') and text()='{0}']");
	
	
	
	

			
	public static final Target CONTRATO_SEDE_IPS = Target.the("Sede contrato ips")
			.locatedBy("//label[contains(@id,'formBuscarContrato:sede_label')]");
	public static final Target CONTRATO_SEDE_IPS_SELECCION = Target.the("Sede contrato ips")
			.locatedBy("//li[contains(@id,'formBuscarContrato:sede_') and text()='{0}']");
	public static final Target NUMERO_DE_CONTRATO = Target.the("Numero de Contrato")
			.locatedBy("//input[contains(@id,'noContratoBusqueda')]");
	public static final Target CONTRATO_REGIMEN = Target.the("Contrato Regimen")
			.locatedBy("//label[contains(@id,'regimen_label')]");
	public static final Target CONTRATO_REGIMEN_SELECCION = Target.the("Contrato Regimen")
			.locatedBy("//li[contains(@id,'formBuscarContrato:regimen_') and text()='{0}']");
	public static final Target CONTRATO_MODALIDAD = Target.the("Contrato Modalidad")
			.locatedBy("//label[contains(@id,'formBuscarContrato:modalidad_label')]");
	public static final Target CONTRATO_MODALIDAD_SELECCION = Target.the("Contrato Modalidad")
			.locatedBy("//li[contains(@id,'formBuscarContrato:modalidad_') and text()='{0}']");
	public static final Target CONTRATO_BUSCAR_CONTRATO = Target.the("Buscar Contrato")
			.locatedBy("//span[text()='Buscar Contrato']");
	public static final Target SELECCIONAR_CONTRATO = Target.the("Seleccionar Contrato")
			.locatedBy("//button[@title='Seleccionar']/span[1]");

	public static final Target RESPONSABE_DE_PAGO = Target.the("Responsable de pago")
			.locatedBy("//label[contains(@id,':responsablePagoMenu_label')]");
	public static final Target RESPONSABE_DE_PAGO_SELECCION = Target.the("Responsable de pago")
			.locatedBy("//li[contains(@id,'responsablePagoMenu') and text()='{0}']");
	
	public static final Target TIPO_DE_SERVICIO = Target.the("Tipo De Servicio")
			.locatedBy("//label[contains(@id,'formValidarRips:tipoServicioMenu_label')]");
	public static final Target TIPO_DE_SERVICIO_SELECCION = Target.the("Tipo de servicios Selección")
			.locatedBy("//li[contains(@id,'formValidarRips:tipoServicioMenu_1') and text()='{0}']");
	
	
	public static final Target CARGAR_ARCHIVOS = Target.the("Cargar Archivos")
			.locatedBy("//span[text()='Cargar Archivo']");
	public static final Target CONFIRMAR_CARGUE_DE_ARCHIVOS = Target.the("Aceptar cargar los archivos").locatedBy(
			"//div[@role='dialog' and contains(@style,'display')]/div/span[.='Advertencia']/following::span[.='Si'][1]");
	public static final Target ACEPTAR_PROCESO_CARGUE_TERMINADO = Target.the("Aceptar proceso completo de carga")
			.locatedBy("//button[contains(@id,'formValidarRips:')]/span[.='Aceptar']");
	public static final Target CONFIRMAR = Target.the("Confirmar")
			.locatedBy("//button[contains(@id,'formValidarRips:')]/span[.='Confirmar']");
	public static final Target CERRAR_INFORMACION_DE_VALIDACION = Target.the("Cerrar Información")
			.locatedBy("//div[@role='dialog' and contains(@style,'display')]/div/span/following::span[.='Cerrar'][1]");

	public static final Target ES_FACTURACION_MULTIUSUARIO = Target.the("Es facturación multiusuario?")
			.locatedBy("//div[contains(@id,'esCuentaMultiUsuario')]//span");

}
