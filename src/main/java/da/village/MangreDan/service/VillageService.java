package da.village.MangreDan.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;

import da.village.MangreDan.crud.BarcodeUtil;
import da.village.MangreDan.model.Village;
import da.village.MangreDan.repo.VillageRepository;

@Service
public class VillageService {

	@Autowired
	private VillageRepository villageRepository;

	@Autowired
	private BarcodeService barcodeService;

	@Autowired
	private DataSource dataSource; // Injectez la DataSource

	public Village enregistrerVillage(Village village) {
		return villageRepository.save(village);
	}

	public Village add(Village village) {
		// Utilisez la DataSource pour accéder à la base de données
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// Exemple d'utilisation de JdbcTemplate pour exécuter une requête SQL
		jdbcTemplate.update("INSERT INTO village (langue,nom) VALUES (?, ?)", village.getLangue(), village.getNom());

		// Maintenant, vous pouvez également utiliser votre repository pour enregistrer
		// l'entité
		return village;
	}

	public List<Village> getAllVillages() {
		// Utilisez la DataSource pour accéder à la base de données
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// Exécutez une requête SQL pour sélectionner tous les villages
		String sql = "SELECT * FROM village";
		List<Village> villages = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Village.class));

		return villages;
	}

	@SuppressWarnings("deprecation")
	public Village getVillageById(Long id) {
		// Utilisez la DataSource pour accéder à la base de données
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// Exécutez une requête SQL pour sélectionner un village par son ID
		String sql = "SELECT * FROM village WHERE id = ?";
		Village village = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<>(Village.class));

		return village;
	}

	public Village updateVillage(Village village) {
		// Utilisez la DataSource pour accéder à la base de données
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		// Exécutez une requête SQL pour mettre à jour le village dans la base de
		// données
		String sql = "UPDATE village SET nom = ?, langue = ? WHERE id = ?";
		jdbcTemplate.update(sql, village.getNom(), village.getLangue(), village.getId());

		return village;
	}

	public Village saveVillage(Village village) throws IOException, WriterException {
		// Vérifier et créer le répertoire 'barcodes' si nécessaire
		File barcodeDir = new File("barcodes");
		if (!barcodeDir.exists()) {
			barcodeDir.mkdirs();
		}

		// Générer un chemin pour le fichier du code-barres
		String barcodePath = Paths.get("barcodes", village.getNom() + "_barcode.png").toString();
		String qrCodePath = Paths.get("barcodes", village.getNom() + "_qrcode.png").toString();

		// Générer et enregistrer le code-barres et le QR code en fichier
		barcodeService.generateBarcodeImage(village.getNom(), 200, 200, barcodePath);
		barcodeService.generateQrCodeImage(village.getNom(), 200, 200, qrCodePath);

		// Générer les codes en base64
		String barcodeBase64 = barcodeService.generateBarcodeBase64(village.getNom(), 200, 200);
		String qrCodeBase64 = barcodeService.generateQrCodeBase64(village.getNom(), 200, 200);

		// Enregistrer les chemins et les images en base64 dans le village
		village.setBarcode(barcodePath);
		village.setBarcodeImage(barcodeBase64);
		village.setBarcode(qrCodePath);
		village.setBarcodeImage(qrCodeBase64);

		// Sauvegarder le village dans la base de données
		return villageRepository.save(village);
	}

	public Optional<Village> findById(Long id) {
		return villageRepository.findById(id);
	}
}