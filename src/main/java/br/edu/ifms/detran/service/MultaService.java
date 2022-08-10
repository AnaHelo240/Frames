package br.edu.ifms.detran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.model.Multa;
import br.edu.ifms.detran.repository.MultaRepository;
import br.edu.ifms.detran.service.exception.DataIntegrityException;
import br.edu.ifms.detran.service.exception.ObjectNotFoundException;

@Service
public class MultaService {

	@Autowired
	private MultaRepository repo;
	
	public Multa buscarPorId(Integer id) {
		Optional<Multa> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Multa.class.getName()));		
	}
	
	public Multa insert (Multa obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Multa update(Multa obj) {
		Multa newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
	
		buscarPorId(id);
		try {
			repo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover. Verifique a integridade referencial.");
		}
	}

	public List<Multa> findAll() {
			
		return repo.findAll();
}
	
	private void updateData(Multa newObj, Multa obj) {
		newObj.setId(obj.getId());
		newObj.setCidade(obj.getCidade());
		newObj.setAno(obj.getAno());
		newObj.setCarro(obj.getCarro());
		newObj.setInfracao(obj.getInfracao());
	}
}