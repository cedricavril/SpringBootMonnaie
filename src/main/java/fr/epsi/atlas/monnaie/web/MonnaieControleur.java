package fr.epsi.atlas.monnaie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.epsi.atlas.monnaie.entity.Monnaie;
import fr.epsi.atlas.monnaie.repository.MonnaieRepository;
import fr.epsi.atlas.monnaie.service.MonnaieService;

import javax.transaction.Transactional;

@RestController
public class MonnaieControleur {

	@Autowired
	private MonnaieService monnaieService;
	
	MonnaieRepository monnaieRepo;
	
	@PostMapping(path = "monnaie/")
	public Monnaie add(	@ModelAttribute("salaire") Monnaie monnaie, Model model) {
		monnaieService.add(monnaie);
		return monnaie;
	}

	@GetMapping(path = "monnaie/{codeMonnaie}")
	public Monnaie getByCode(@PathVariable String codeMonnaie) throws MonnaieInexistanteException {
		return monnaieService.getByCode(codeMonnaie);
	}

	@Transactional
	@DeleteMapping(path = "monnaie/{codeMonnaie}")
	public void deleteByCode(@PathVariable String codeMonnaie) {
		monnaieService.delete(codeMonnaie);
	}

	@Transactional
	@PutMapping(path = "monnaie/{codeMonnaie}")
	public Monnaie saveMonnaie(@PathVariable String codeMonnaie, @ModelAttribute Monnaie m, Model model) {
		monnaieService.add(m);
		return m;
	}
}
