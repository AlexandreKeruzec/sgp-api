package dev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.api.entite.Banque;
import dev.api.entite.Collaborateur;
import dev.api.repository.BanqueRepository;
import dev.api.repository.CollaborateurRepository;
import dev.api.repository.DepartementRepository;

@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository collaborateurRepo;

	@Autowired
	private DepartementRepository departementRepo;

	@Autowired
	private BanqueRepository banqueRepo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Collaborateur> afficherTousCollaborateurs() {
		return collaborateurRepo.findAll();
	}

	@RequestMapping(params = { "departement" }, method = RequestMethod.GET)
	public List<Collaborateur> afficherCollaborateursByDepartement(@RequestParam("departement") int depId) {
		return collaborateurRepo.findByDepartement(departementRepo.findById(depId));
	}

	@RequestMapping(path = "/{matricule}", method = RequestMethod.GET)
	public Collaborateur afficherCollaborateurByMatricule(@PathVariable String matricule) {
		return collaborateurRepo.findByMatricule(matricule);
	}

	@RequestMapping(path = "/{matricule}", method = RequestMethod.PUT)
	public void updateCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collab) {
		collab.setId(collaborateurRepo.findByMatricule(matricule).getId());
		collaborateurRepo.save(collab);
	}

	@RequestMapping(path = "/{matricule}/banque", method = RequestMethod.GET)
	public Banque afficherBanqueByMatricule(@PathVariable String matricule) {
		return collaborateurRepo.findByMatricule(matricule).getBanque();
	}

	@RequestMapping(path = "/{matricule}/banque", method = RequestMethod.PUT)
	public void updateBanque(@PathVariable String matricule, @RequestBody Banque banque) {
		banque.setId(collaborateurRepo.findByMatricule(matricule).getBanque().getId());
		banqueRepo.save(banque);
	}

}
