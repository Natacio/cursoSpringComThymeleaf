package curso.spring.cursoSpringComThymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.spring.cursoSpringComThymeleaf.model.Pessoa;
import curso.spring.cursoSpringComThymeleaf.services.PessoaService;

@Controller
@RequestMapping("/")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("cadastropessoa")
	public String cadPessoa() {
		return "pessoa/cadastro";
	}
	
	@PostMapping
	public ModelAndView save(Pessoa p) {
		pessoaService.save(p);
		
		ModelAndView andView = new ModelAndView("pessoa/cadastro");
		Iterable<Pessoa> pessoas = pessoaService.getAll();
		andView.addObject("pessoas",pessoas);
		
		return andView;
	}
	
	@GetMapping("/listpessoas")
	public ModelAndView getPessoas() {
		ModelAndView andView = new ModelAndView("pessoa/cadastro");
		Iterable<Pessoa> pessoas = pessoaService.getAll();
		andView.addObject("pessoas",pessoas);
		
		return andView;
	}
}
