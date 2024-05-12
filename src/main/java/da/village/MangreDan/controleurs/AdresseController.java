package da.village.MangreDan.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import da.village.MangreDan.model.Adresse;
import da.village.MangreDan.service.AdresseService;

@RestController
@RequestMapping("/adresses")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @PostMapping("/add")
    public ResponseEntity<Adresse> addAdresse(@RequestBody Adresse adresse) {
        Adresse newAdresse = adresseService.addAdresse(adresse);
        return new ResponseEntity<>(newAdresse, HttpStatus.CREATED);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Adresse>> findAllAdresses() {
        List<Adresse> adresses = adresseService.all();
        return new ResponseEntity<>(adresses, HttpStatus.OK);
    }
}

