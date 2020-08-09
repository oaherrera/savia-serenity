package com.conexia.qa.sql.tasks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conexia.qa.sql.modelos.profesional;
import com.conexia.qa.sql.utilitario.ConexionBD;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class consultoProfesional implements Task {
	private ConexionBD conexion;
	private String sentencia = "" + "select\r\n"
			+ "	p.nombre1, p.nombre2,p.apellido1,p.apellido2,td.descripcion,p.numero_documento,\r\n"
			+ "	e.descripcion , cp.descripcion\r\n" + " from maestro.profesional p \r\n"
			+ " inner join parametro.tipo_documento td on p.tipo_documento_id = td.id\r\n"
			+ " inner join parametro.cargo_profesional_ips cp on p.cargo_profesional_ips_id = cp.id\r\n"
			+ " inner join maestro.profesional_especialidad_medica pe on p.id = pe.profesional_id\r\n"
			+ " inner join maestro.especialidad_medica e on pe.especialidad_medica_id = e.id\r\n" + " where  1 = 1\r\n"
			+ " and p.deleted = 'false'\r\n" + " and pe.deleted = 'false'\r\n" + " and e.deleted = 'false'\r\n"
			+ " and td.deleted = 'false'\r\n" + " and cp.deleted = 'false'\r\n" + " ";
	
	private String sentenciaOrdenamiento = "";
	private PreparedStatement psentencia;
	
	private String buscarPör;
	private String tipoDocumnento;
	private String numeroDocumento;
	private profesional Profesional;

	public consultoProfesional(String buscarPör, String tipoDocumnento, String numeroDocumento) {
		this.buscarPör = buscarPör;
		this.tipoDocumnento = tipoDocumento(tipoDocumnento);
		this.numeroDocumento = numeroDocumento;
		this.conexion = ConexionBD.getConexion();
		this.Profesional = profesional.traerProfesional();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			switch (buscarPör) {
			case "Documento":
				sentencia = sentencia + " and p.numero_documento = ? \r\n" + " and td.descripcion = ? \r\n";
				sentenciaOrdenamiento = "order by e.id";
				psentencia = conexion.metPrepararSentcia(sentencia + sentenciaOrdenamiento);
				psentencia.setString(1, numeroDocumento);
				psentencia.setString(2, tipoDocumnento);
			}
			
			ResultSet datos = psentencia.executeQuery();
			Profesional.borrarProfesionales();
			while(datos.next()) {
				Profesional.setPrimerNombre(datos.getString(1));
				Profesional.setSegundoNombre(datos.getString(2));
				Profesional.setPrimerApellido(datos.getString(3));
				Profesional.setSegundoApellido(datos.getString(4));
				Profesional.setTipoDocumento(datos.getString(5));
				Profesional.setNumeroDocumento(datos.getString(6));
				Profesional.setEspecialidad(datos.getString(7));
				Profesional.setCargo(datos.getString(8));
				Profesional.guardarProfesionale(Profesional);
			}
			
			psentencia.clearParameters();
			psentencia.close();
			conexion.metDesconectarBd();
			
		} catch (SQLException e) {
			conexion.metDesconectarBd();
			e.printStackTrace();
		}

	}

	public static consultoProfesional porTipoDocumento(String tipoDocumento, String numeroDocumento) {
		return Tasks.instrumented(consultoProfesional.class, "Documento", tipoDocumento, numeroDocumento);
	}
	
	private String tipoDocumento(String tipoDocumento) {
		if(tipoDocumento.equals("Cédula de ciudadanía")) {
			return "Cedula ciudadania";
		}
		return tipoDocumento;
	} 

}
