package siga.pfa.reclamation.service;

import java.time.LocalDateTime;

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
        reclamation.setCreatedBy("Soulaima");
        return reclamationRepository.save(reclamation);
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
