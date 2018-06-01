package dev.api.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.api.entite.Banque;
import dev.api.entite.Collaborateur;
import dev.api.entite.Departement;
import dev.api.repository.BanqueRepository;
import dev.api.repository.CollaborateurRepository;
import dev.api.repository.DepartementRepository;

@Service
public class InitDonnees {

	@Autowired
	CollaborateurRepository CollaborateurRepository;

	@Autowired
	DepartementRepository departementRepository;

	@Autowired
	BanqueRepository banqueRepository;

	@Transactional
	public void initialiser() {
		Departement dep1 = new Departement();
		dep1.setNom("Informatique");
		departementRepository.save(dep1);
		Departement dep2 = new Departement();
		dep2.setNom("Comptabilite");
		departementRepository.save(dep2);
		Departement dep3 = new Departement();
		dep3.setNom("RH");
		departementRepository.save(dep3);

		Banque ban1 = new Banque();
		ban1.setBic("Bic1");
		ban1.setIban("Iban1");
		ban1.setNom("Banque1");
		banqueRepository.save(ban1);

		Banque ban2 = new Banque();
		ban2.setBic("Bic2");
		ban2.setIban("Iban2");
		ban2.setNom("Banque2");
		banqueRepository.save(ban2);

		Collaborateur coll1 = new Collaborateur();
		coll1.setActif(true);
		coll1.setAdresse("adresse");
		coll1.setDateDeNaissance(LocalDate.of(1990, 6, 12));
		coll1.setDateHeureCreation(ZonedDateTime.now());
		coll1.setEmailPro("email");
		coll1.setMatricule("M01");
		coll1.setNom("nom");
		coll1.setNumeroDeSecuriteSociale("ssn");
		coll1.setPhoto("");
		coll1.setPrenom("prenom");
		coll1.setDepartement(dep1);
		coll1.setBanque(ban2);
		CollaborateurRepository.save(coll1);

		Collaborateur coll2 = new Collaborateur();
		coll2.setActif(true);
		coll2.setAdresse("adresse");
		coll2.setDateDeNaissance(LocalDate.of(1990, 6, 12));
		coll2.setDateHeureCreation(ZonedDateTime.now());
		coll2.setEmailPro("email2");
		coll2.setMatricule("M02");
		coll2.setNom("nom2");
		coll2.setNumeroDeSecuriteSociale("ssn2");
		coll2.setPhoto("");
		coll2.setPrenom("prenom2");
		coll2.setDepartement(dep2);
		coll2.setBanque(ban1);
		CollaborateurRepository.save(coll2);

	}

}
