package siga.pfa.reclamation.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import siga.pfa.reclamation.domain.Reclamation;
import siga.pfa.reclamation.domain.TypeReclamation;
import siga.pfa.reclamation.repository.TypeReclamationRepository;

@RestController
@RequestMapping("/api")
 @CrossOrigin(origins = "*") 
public class TypeReclamationRest {
	
	
	private final Logger log = LoggerFactory.getLogger(TypeReclamationRest.class);

    private static final String ENTITY_NAME = "TypeReclamation";
    
    @Autowired
    private TypeReclamationRepository typeReclamationRepository;
    
    @GetMapping("/type-reclamations")
    public List<TypeReclamation> getAllTypeReclamation() {
        log.debug("REST request to get a page of Type Reclamation");

        return typeReclamationRepository.findAll();
    }
    

}
