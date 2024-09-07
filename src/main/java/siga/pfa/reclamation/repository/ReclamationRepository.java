package siga.pfa.reclamation.repository;

 import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.stereotype.Repository;

import siga.pfa.reclamation.domain.Reclamation;



@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long>{
 	   @Query("SELECT r.situation, COUNT(r) FROM Reclamation r GROUP BY r.situation")
	    List<Object[]> countReclamationsBySituation();

	    // Nombre de réclamations par mois
	    @Query("SELECT YEAR(r.createdDate), MONTH(r.createdDate), COUNT(r) FROM Reclamation r GROUP BY YEAR(r.createdDate), MONTH(r.createdDate)")
	    List<Object[]> countReclamationsByMonth();

	    // Délai moyen de traitement pour les réclamations clôturées
	    @Query("SELECT AVG(DATEDIFF(r.modifiedDate, r.createdDate)) FROM Reclamation r WHERE r.situation = 'Clôturé'")
	    Double averageDelayForClosedReclamations();
	    
	    @Query("SELECT r.createdBy, COUNT(r) FROM Reclamation r GROUP BY r.createdBy")
	    List<Object[]> countReclamationsByCreator();
	    

	    @Query("SELECT sr.sousTypeReclamation.libFr, COUNT(sr) FROM Reclamation sr GROUP BY sr.sousTypeReclamation.libFr")
	    List<Object[]> findSousReclamationsStatistiques();
 
}
