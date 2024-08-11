package siga.pfa.reclamation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import siga.pfa.reclamation.domain.Reclamation;



@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long>{

}
