package pe.edu.unmsm.ejemplo01.repositorios;

import org.springframework.data.repository.CrudRepository;
import pe.edu.unmsm.ejemplo01.entidades.Alumno;


public interface AlumnoRepositorio extends CrudRepository<Alumno, Integer>{
	/***
	 * Busca un alumno por su codigo
	 * @param alu_vcCodigo
	 * @return
	 */
	public Alumno findByAluVcCodigo(String alu_vcCodigo);
}
