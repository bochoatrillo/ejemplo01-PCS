package pe.edu.unmsm.ejemplo01.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.unmsm.ejemplo01.entidades.Alumno;
import pe.edu.unmsm.ejemplo01.repositorios.AlumnoRepositorio;

@Controller
@RequestMapping(path = "/alumno")
public class AlumnoControlador {
	@Autowired
	private AlumnoRepositorio alumnoRepositorio;
	
	@GetMapping(path = "/todos")
	public @ResponseBody Iterable<Alumno> findAll(){
		return alumnoRepositorio.findAll();
	}
	
	@GetMapping(path = "/buscar")
	public @ResponseBody Alumno buscar(@RequestParam String alu_vccodigo){
		return alumnoRepositorio.findByAluVcCodigo(alu_vccodigo);
	}
	
	@PostMapping(path = "/nuevo")
	public @ResponseBody Integer add(
		@RequestParam String alu_vccodigo,
		@RequestParam String alu_vcpaterno,
		@RequestParam String alu_vcmaterno,
		@RequestParam String alu_vcnombre
	) {
		Alumno alumno = new Alumno();
		
		alumno.setAlu_vcCodigo(alu_vccodigo);
		alumno.setAlu_vcPaterno(alu_vcpaterno);
		alumno.setAlu_vcMaterno(alu_vcmaterno);
		alumno.setAlu_vcNombre(alu_vcnombre);
		
		alumnoRepositorio.save(alumno);
		return alumno.getAlu_iCodigo();
	}
	
	@PutMapping(path = "/cambiar/{id}")
	public @ResponseBody Integer cambiar(
		@PathVariable Integer id,
		@RequestParam String alu_vccodigo,
		@RequestParam String alu_vcpaterno,
		@RequestParam String alu_vcmaterno,
		@RequestParam String alu_vcnombre
	) {
		Optional<Alumno> opt = alumnoRepositorio.findById(id);
		if(!opt.isPresent())return 0;
		
		Alumno alumno = opt.get();
		alumno.setAlu_vcCodigo(alu_vccodigo);
		alumno.setAlu_vcPaterno(alu_vcpaterno);
		alumno.setAlu_vcMaterno(alu_vcmaterno);
		alumno.setAlu_vcNombre(alu_vcnombre);
		
		try {
			alumnoRepositorio.save(alumno);
			return 1;
		}catch(Exception e){
			return -1;
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public @ResponseBody Integer borrar(@PathVariable Integer id) {
		try {
			alumnoRepositorio.deleteById(id);
			return 1;
		}catch(Exception e) {
			return -1;
		}
	}
}
