package curso.spring.cursoSpringComThymeleaf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.spring.cursoSpringComThymeleaf.model.Pessoa;
import curso.spring.cursoSpringComThymeleaf.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	private final PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoaService(PessoaRepository p) {
		this.pessoaRepository = p;
	}
	
	public Pessoa save(Pessoa p) {
		return pessoaRepository.save(p);
	}
	
	public Iterable<Pessoa> getAll() {
		return pessoaRepository.findAll();
	}

}
