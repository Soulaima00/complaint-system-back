package siga.pfa.reclamation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import siga.pfa.reclamation.domain.TypeReclamation;


@Repository
public interface TypeReclamationRepository extends JpaRepository<TypeReclamation, Long>{

}
