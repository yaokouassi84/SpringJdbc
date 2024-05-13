package da.village.MangreDan.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import da.village.MangreDan.model.Adresse;

public class AdresseRowMapper implements RowMapper<Adresse>{

	@Override
	public Adresse mapRow(ResultSet rs, int rowNum) throws SQLException {
		Adresse adresse = new Adresse();
        adresse.setId(rs.getLong("id"));
        adresse.setRue(rs.getString("rue"));
        adresse.setVille(rs.getString("ville"));
        adresse.setPays(rs.getString("pays"));
        // Assigner d'autres attributs d'adresse ici
        return adresse;
	}

}
