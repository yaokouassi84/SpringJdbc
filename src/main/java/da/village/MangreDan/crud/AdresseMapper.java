package da.village.MangreDan.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import da.village.MangreDan.model.Adresse;

public class AdresseMapper implements RowMapper<Adresse> {

	@Override
	public Adresse mapRow(ResultSet rs, int rowNum) throws SQLException {
		Adresse ad = new Adresse();
		ad.setId(rs.getLong("id"));
		ad.setRue(rs.getString("rue"));
		ad.setCp(rs.getString("cp"));
		ad.setVille(rs.getString("ville"));
		ad.setPays(rs.getString("pays"));
		return ad;
	}

}
