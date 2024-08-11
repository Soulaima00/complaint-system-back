package siga.pfa.reclamation.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import siga.pfa.reclamation.domain.Reclamation;
import siga.pfa.reclamation.domain.SousTypeReclamation;
import siga.pfa.reclamation.repository.SousTypeReclamationRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SousTypeReclamationRest {
	
	private final Logger log = LoggerFactory.getLogger(SousTypeReclamationRest.class);

    private static final String ENTITY_NAME = "SousTypeReclamation";
    
    
    @Autowired
    private SousTypeReclamationRepository sousTypeReclamationRepository;
    
    
    @GetMapping("/sous-type-reclamations/{idType}")
    public List<SousTypeReclamation> getAllSousTypeReclamation(@PathVariable Long idType) {
        log.debug("REST request to get a page of SousTypeReclamation");

        return sousTypeReclamationRepository.allSousTypeByType(idType);
    }
    

}
