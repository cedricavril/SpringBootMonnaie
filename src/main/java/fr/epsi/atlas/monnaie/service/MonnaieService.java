package fr.epsi.atlas.monnaie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.atlas.monnaie.entity.Monnaie;
import fr.epsi.atlas.monnaie.repository.MonnaieRepository;
import fr.epsi.atlas.monnaie.web.MonnaieInexistanteException;

@Service
public class MonnaieService {

	@Autowired
	private MonnaieRepository monnaieRepository;

	
	public Monnaie getByCode(String codeMonnaie) throws MonnaieInexistanteException {
		Optional<Monnaie> Om = this.monnaieRepository.findById(codeMonnaie);
		Om.orElseThrow(MonnaieInexistanteException::new);
		return Om.get();
	}

	public void add(Monnaie monnaie) {
		monnaieRepository.save(monnaie);
	}

	public void delete(String monnaieId) {
		monnaieRepository.deleteById(monnaieId);
	}

}
