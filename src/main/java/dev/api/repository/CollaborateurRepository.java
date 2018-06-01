package dev.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.api.entite.Collaborateur;
import dev.api.entite.Departement;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	List<Collaborateur> findByDepartement(Departement departement);

	Collaborateur findByMatricule(String matricule);

}
