package dev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.api.entite.Banque;

public interface BanqueRepository extends JpaRepository<Banque, Integer> {

}
