package siga.pfa.reclamation.rest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import siga.pfa.reclamation.domain.InputTreatReclamationDTO;
import siga.pfa.reclamation.domain.Reclamation;
import siga.pfa.reclamation.repository.ReclamationRepository;
import siga.pfa.reclamation.service.ReclamationService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ReclamationRest {
	private final Logger log = LoggerFactory.getLogger(ReclamationRest.class);

    private static final String ENTITY_NAME = "Reclamation";
    
    
    @Autowired
    private ReclamationService reclamationService;
    @Autowired
    private ReclamationRepository reclamationRepository;
    
    @Value("PFA")
    private String applicationName;
    
    
    @PostMapping("/reclamations")
    public Reclamation createReclamation(
    		@RequestPart("reclamation") final Reclamation reclamation,
            @RequestPart(value = "file", required = false) final MultipartFile file
            ) throws URISyntaxException, IOException {
        log.debug("REST request to save Reclamation : {}", reclamation);
        if (reclamation.getId() != null) {
        	return null;
        }
        if (file != null) {
        	reclamation.setImage(file.getBytes());
        }
    


        Reclamation result = reclamationService.save(reclamation);
        return result;
    }
    
    @PostMapping("/reclamation-treat")
    public Reclamation treatReclamation(@RequestBody InputTreatReclamationDTO input) throws URISyntaxException {
    	  

        log.debug("REST request to treat Reclamation");
        if (input.getId() == null) {
        	return null;
        }
        Reclamation result = reclamationService.treat(input);
        return result;
    }
    
    @GetMapping("/reclamations")
    public List<Reclamation> getAllReclamation() {
        log.debug("REST request to get a page of Reclamation");

        return reclamationRepository.findAll();
    }
    

}
