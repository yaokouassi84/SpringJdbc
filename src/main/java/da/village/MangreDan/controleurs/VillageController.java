package da.village.MangreDan.controleurs;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

import da.village.MangreDan.model.Village;
import da.village.MangreDan.repo.VillageRepository;
import da.village.MangreDan.service.VillageService;

@RestController
@RequestMapping("/villages")
public class VillageController {

	@Autowired
	private VillageService villageService;

	@Autowired
	private VillageRepository villageRepository;

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

	@PostMapping("/codeBarre")
    public ResponseEntity<Village> createVillageCodeBare(@RequestBody Village village) {
        try {
            Village savedVillage = villageService.saveVillage(village);
            return ResponseEntity.ok(savedVillage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null); // Gérer l'erreur correctement
        }
    }

    @GetMapping("/{id}/barcode")
    public ResponseEntity<FileSystemResource> getBarcode(@PathVariable Long id) {
        Optional<Village> optionalVillage = villageService.findById(id);
        if (optionalVillage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Village village = optionalVillage.get();
        String barcodePath = village.getBarcode();
        if (barcodePath == null || barcodePath.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        FileSystemResource resource = new FileSystemResource(barcodePath);
        if (!resource.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok().header("Content-Type", "image/png").body(resource);
    }

    @GetMapping("/{id}/qrcode")
    public ResponseEntity<FileSystemResource> getQrCode(@PathVariable Long id) {
        Optional<Village> optionalVillage = villageService.findById(id);
        if (optionalVillage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Village village = optionalVillage.get();
        String qrCodePath = village.getBarcodeImage();
        if (qrCodePath == null || qrCodePath.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        FileSystemResource resource = new FileSystemResource(qrCodePath);
        if (!resource.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok().header("Content-Type", "image/png").body(resource);
    }
}
