package siga.pfa.reclamation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import siga.pfa.reclamation.domain.SousTypeReclamation;

@Repository
public interface SousTypeReclamationRepository extends JpaRepository<SousTypeReclamation, Long> {
	@Query("Select sous from  SousTypeReclamation sous where sous.typeReclamation.id =?1")
	List<SousTypeReclamation> allSousTypeByType(Long idType);

}
