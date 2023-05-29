package pe.edu.unmsm.ejemplo01.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="alu_iCodigo")
	private Integer alu_iCodigo;
	@Column(name="alu_vcCodigo")
	private String aluVcCodigo;
	@Column(name="alu_vcPaterno")
	private String alu_vcPaterno;
	@Column(name="alu_vcMaterno")
	private String alu_vcMaterno;
	@Column(name="alu_vcNombre")
	private String alu_vcNombre;
	
	public Integer getAlu_iCodigo() {
		return alu_iCodigo;
	}
	public void setAlu_iCodigo(Integer alu_iCodigo) {
		this.alu_iCodigo = alu_iCodigo;
	}
	public String getAlu_vcCodigo() {
		return aluVcCodigo;
	}
	public void setAlu_vcCodigo(String alu_vcCodigo) {
		this.aluVcCodigo = alu_vcCodigo;
	}
	public String getAlu_vcPaterno() {
		return alu_vcPaterno;
	}
	public void setAlu_vcPaterno(String alu_vcPaterno) {
		this.alu_vcPaterno = alu_vcPaterno;
	}
	public String getAlu_vcMaterno() {
		return alu_vcMaterno;
	}
	public void setAlu_vcMaterno(String alu_vcMaterno) {
		this.alu_vcMaterno = alu_vcMaterno;
	}
	public String getAlu_vcNombre() {
		return alu_vcNombre;
	}
	public void setAlu_vcNombre(String alu_vcNombre) {
		this.alu_vcNombre = alu_vcNombre;
	}
}
