package da.village.MangreDan.service;

import java.util.List;

import javax.sql.DataSource;

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

}
