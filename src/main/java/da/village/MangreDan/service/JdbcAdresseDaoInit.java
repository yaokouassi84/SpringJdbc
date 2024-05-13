package da.village.MangreDan.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import da.village.MangreDan.model.Adresse;
import da.village.MangreDan.crud.*;
@SuppressWarnings("unused")
public class JdbcAdresseDaoInit implements AdresseService,InitializingBean {

	@Autowired
	private DataSource dts;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setDts(DataSource dts) {
		this.dts = dts;
		this.jdbcTemplate = new JdbcTemplate();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if(dts == null) {
			throw new BeanCreationException("Obligatoire DataSource");
		}
		
	}

	@Override
    public Adresse addAdresse(Adresse adresse) {
        String sql = "INSERT INTO Adresse (rue, cp, ville, pays) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, adresse.getRue(), adresse.getCp(), adresse.getVille(), adresse.getPays());
        return adresse;
    }

    @Override
    public List<Adresse> all() {
        String sql = "SELECT * FROM Adresse";
        List<Adresse> adresses = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Adresse.class));
        return adresses;
    }

    @Override
    public Adresse findAdresseByRue(String rue) {
        //String sql = "SELECT * FROM Adresse WHERE rue = ?";
        //List<Adresse> adresses = jdbcTemplate.query(sql, new Object[]{rue}, new AdresseRowMapper());

        //if (adresses.isEmpty()) {
            // Aucune adresse trouvée pour la rue spécifiée
            //return null;
        //} else {
            // Si vous vous attendez à une seule adresse pour cette rue, vous pouvez renvoyer la première de la liste
            //return adresses.get(0);
        //}
    	return null;
    }

	}

	

    

