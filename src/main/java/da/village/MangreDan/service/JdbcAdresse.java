package da.village.MangreDan.service;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import da.village.MangreDan.crud.AdresseMapper;
import da.village.MangreDan.model.Adresse;

@Service
public class JdbcAdresse implements AdresseService {

	@Autowired
	private DataSource dts;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setDts(DataSource dts) {
		this.dts = dts;
		this.jdbcTemplate = new JdbcTemplate();
	}

	@Override
	public Adresse addAdresse(Adresse adresse) {
	    String sql = "INSERT INTO Adresse (rue, cp, ville, pays) VALUES (?, ?, ?, ?)";
	    jdbcTemplate.update(sql, adresse.getRue(), adresse.getCp(), adresse.getVille(), adresse.getPays());
	    return adresse;
	}

	@Override
	public List<Adresse> all() {
		String sql = "select id,rue,cp,ville,pays from Adresse";
		return jdbcTemplate.query(sql,new AdresseMapper());
	}

	@Override
	public Adresse findAdresseByRue(String rue) {
		 String sql = "SELECT * FROM Adresse WHERE rue = ?";
		    List<Adresse> adresses = jdbcTemplate.query(sql, new Object[]{rue}, new AdresseMapper());

		    if (adresses.isEmpty()) {
		        // Aucune adresse trouvée pour la rue spécifiée
		        return null;
		    } else {
		        // Retourner la première adresse trouvée
		        return adresses.get(0);
		    }
	}
	
	
	public void insertDataFromSQLFile() {
        try {
            // Charger le fichier insert.sql depuis les ressources
            Resource resource = new ClassPathResource("insert.sql");
            BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));

            String line;
            StringBuilder query = new StringBuilder();

            // Lire chaque ligne du fichier SQL
            while ((line = reader.readLine()) != null) {
                // Ajouter la ligne à la requête
                query.append(line);

                // Si la ligne se termine par un point-virgule, exécuter la requête
                if (line.trim().endsWith(";")) {
                    jdbcTemplate.update(query.toString());
                    // Réinitialiser la requête pour la prochaine instruction
                    query.setLength(0);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
