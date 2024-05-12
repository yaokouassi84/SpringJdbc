package da.village.MangreDan.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import da.village.MangreDan.model.Village;
import da.village.MangreDan.repo.VillageRepository;

@Service
public class VillageService {

    @Autowired
    private VillageRepository villageRepository;

    @Autowired
    private DataSource dataSource; // Injectez la DataSource
    
    public Village enregistrerVillage(Village village) {
        return villageRepository.save(village);
    }
    
    public Village add(Village village) {
        // Utilisez la DataSource pour accéder à la base de données
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        // Exemple d'utilisation de JdbcTemplate pour exécuter une requête SQL
        jdbcTemplate.update("INSERT INTO village (langue,nom) VALUES (?, ?)",
        		village.getLangue(),village.getNom());
        
        // Maintenant, vous pouvez également utiliser votre repository pour enregistrer l'entité
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
        Village village = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Village.class));
        
        return village;
    }
    
    public Village updateVillage(Village village) {
        // Utilisez la DataSource pour accéder à la base de données
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        // Exécutez une requête SQL pour mettre à jour le village dans la base de données
        String sql = "UPDATE village SET nom = ?, langue = ? WHERE id = ?";
        jdbcTemplate.update(sql, village.getNom(), village.getLangue(), village.getId());
        
        return village;
    }
}
