package da.village.MangreDan.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import da.village.MangreDan.model.Village;
import da.village.MangreDan.service.VillageService;

@RestController
@RequestMapping("/villages")
public class VillageController {

    @Autowired
    private VillageService villageService;
   
    
    @PostMapping("/add")
    public Village enregistrerVillage(@RequestBody Village village) {
        return villageService.enregistrerVillage(village);
    }
    
    @PostMapping("/insert")
    public Village ajouterVillage(@RequestBody Village village) {
        return villageService.add(village);
    }
    
    @GetMapping("/liste")
    public List<Village> getAllVillages() {
        return villageService.getAllVillages();
    }
    
    @GetMapping("/get/{id}")
    public Village getVillageById(@PathVariable Long id) {
        return villageService.getVillageById(id);
    }
    
    @PutMapping("/update/{id}")
    public Village updateVillage(@RequestBody Village village, @PathVariable Long id) {
        village.setId(id);
        return villageService.updateVillage(village);
    }
    
    
}

