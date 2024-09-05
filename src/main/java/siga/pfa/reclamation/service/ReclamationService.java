package siga.pfa.reclamation.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siga.pfa.reclamation.domain.InputTreatReclamationDTO;
import siga.pfa.reclamation.domain.Reclamation;
import siga.pfa.reclamation.repository.ReclamationRepository;

@Service
@Transactional
public class ReclamationService  {
	
	private final Logger log = LoggerFactory.getLogger(ReclamationService.class);
     
	@Autowired
    private  ReclamationRepository reclamationRepository;
	
	public Reclamation save(Reclamation reclamation) {
        log.debug("Request to save Reclamation : {}", reclamation);
        reclamation.setCreatedDate(LocalDateTime.now());
        reclamation.setSituation(0);
         return reclamationRepository.save(reclamation);
    }
	 // Statistiques par situation
    public List<Object[]> getReclamationsBySituation() {
        return reclamationRepository.countReclamationsBySituation();
    }

    // Statistiques par mois
    public List<Object[]> getReclamationsByMonth() {
        return reclamationRepository.countReclamationsByMonth();
    }
    // Statistiques par createur

    public List<Object[]> getReclamationsByCreator() {
        return reclamationRepository.countReclamationsByCreator();
    }
    // Délai moyen pour les réclamations clôturées
    public Double getAverageDelayForClosedReclamations() {
        return reclamationRepository.averageDelayForClosedReclamations();
    }
    public List<Object[]> getSousReclamationsStatistiques() {
        // Exemple de requête pour obtenir les sous-réclamations et leurs occurrences
        return reclamationRepository.findSousReclamationsStatistiques();
    }
	public Reclamation treat(InputTreatReclamationDTO input) {
		Reclamation recl =  reclamationRepository.findById(input.getId()).get();
      

		recl.setObservation(input.getObservation());
		recl.setModifiedBy(input.getModifiedBy());
		recl.setModifiedDate(LocalDateTime.now());
		recl.setSituation(1);
		recl = reclamationRepository.save(recl);
		return recl;
        
    }

}
