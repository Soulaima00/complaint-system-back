package siga.pfa.reclamation.rest;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siga.pfa.reclamation.service.ReclamationService;

import java.util.List;

@RestController
@RequestMapping("/api/statistiques")
@CrossOrigin
public class StatistiqueController {

    @Autowired
    private ReclamationService reclamationService;

    @GetMapping("/par-situation")
    public List<Object[]> getReclamationsBySituation() {
        return reclamationService.getReclamationsBySituation();
    }

    @GetMapping("/par-mois")
    public List<Object[]> getReclamationsByMonth() {
        return reclamationService.getReclamationsByMonth();
    }
    @GetMapping("/by-creator")
    public List<Object[]> getStatByCreator() {
 
        return reclamationService.getReclamationsByCreator();
    }

    @GetMapping("/sous-reclamations-statistiques")
    public List<Object[]> getSousReclamationsStatistiques() {
        return reclamationService.getSousReclamationsStatistiques();
    }
    @GetMapping("/delai-moyen-cloturees")
    public Double getAverageDelayForClosedReclamations() {
        return reclamationService.getAverageDelayForClosedReclamations();
    }
}
