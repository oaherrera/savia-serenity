package com.conexia.qa.savia.models;

import java.util.ArrayList;
import java.util.List;

public class InformacionValidarRips {

	private String ips;
	private String sede;
	private String mesPrestacion;
	private String anhoPrestacion;
	private String nroCuenta;
	private String valorCuenta;
	private String regimen;
	private String contrato;
	private String modalidad;
	private String responsableDePago;
	private String regional;
	private String tipoDeServicio;

	private static List<InformacionValidarRips> InformacionValidarRipsData = new ArrayList<InformacionValidarRips>();

	public String getIps() {
		return ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getMesPrestacion() {
		return mesPrestacion;
	}

	public void setMesPrestacion(String mesPrestacion) {
		this.mesPrestacion = mesPrestacion;
	}

	public String getAnhoPrestacion() {
		return anhoPrestacion;
	}

	public void setAnhoPrestacion(String anhoPrestacion) {
		this.anhoPrestacion = anhoPrestacion;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getValorCuenta() {
		return valorCuenta;
	}

	public void setValorCuenta(String valorCuenta) {
		this.valorCuenta = valorCuenta;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getControto() {
		return contrato;
	}

	public void setControto(String controto) {
		this.contrato = controto;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getResponsableDePago() {
		return responsableDePago;
	}

	public void setResponsableDePago(String responsableDePago) {
		this.responsableDePago = responsableDePago;
	}

	public String getRegional() {
		return regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public String getTipoDeServicio() {
		return tipoDeServicio;
	}

	public void setTipoDeServicio(String tipoDeServicio) {
		this.tipoDeServicio = tipoDeServicio;
	}

	public static InformacionValidarRips traerInformacion(int indice) {
		return InformacionValidarRipsData.get(indice);
	}

	public static void guardarInformacion(InformacionValidarRips informacionValidarRips) {
		InformacionValidarRipsData.add(informacionValidarRips);
	}

	public static void limpiarInformacionValidarRipsData() {
		InformacionValidarRipsData = new ArrayList<InformacionValidarRips>();
	}
}
