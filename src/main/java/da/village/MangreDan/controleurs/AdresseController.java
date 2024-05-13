package da.village.MangreDan.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import da.village.MangreDan.model.Adresse;
import da.village.MangreDan.service.AdresseService;
import da.village.MangreDan.service.AdresseServiecJPA;

@RestController
@RequestMapping("/adresses")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @Autowired
    private AdresseServiecJPA adj;
    
    
    
    @PostMapping("/add")
    public ResponseEntity<Adresse> addAdresse(@RequestBody Adresse adresse) {
        Adresse newAdresse = adresseService.addAdresse(adresse);
        return new ResponseEntity<>(newAdresse, HttpStatus.CREATED);
    }
    
    
    @PostMapping("/addJpa")
    public ResponseEntity<Adresse> addAdresseJPA(@RequestBody Adresse adresse) {
        Adresse newAdresse = adj.addAdresse(adresse);
        return new ResponseEntity<>(newAdresse, HttpStatus.CREATED);
    }
    
    
    @GetMapping("/all")
    public ResponseEntity<List<Adresse>> findAllAdresses() {
        List<Adresse> adresses = adresseService.all();
        return new ResponseEntity<>(adresses, HttpStatus.OK);
    }
    
    @GetMapping("/byRue/{rue}")
    public Adresse getAdresseByRue(@PathVariable String rue) {
        Adresse adresse = adresseService.findAdresseByRue(rue);
        if (adresse != null) {
            System.out.println("Adresse récupérée : " + adresse.getCp()+" "+adresse.getPays()+" "+adresse.getRue());
        } else {
            System.out.println("Aucune adresse trouvée pour la rue : " + rue);
        }
        return adresse;
    }
}

