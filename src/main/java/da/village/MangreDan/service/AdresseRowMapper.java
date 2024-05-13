package da.village.MangreDan.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

import da.village.MangreDan.model.Adresse;

public class AdresseRowMapper implements RowCallbackHandler {

	@Override
	public void processRow(ResultSet rs) throws SQLException {
		Adresse adresse = new Adresse();
        adresse.setId(rs.getLong("id"));
        adresse.setRue(rs.getString("rue"));
        adresse.setVille(rs.getString("ville"));
        adresse.setPays(rs.getString("pays"));
        // Assigner d'autres attributs d'adresse ici        
	}

}
