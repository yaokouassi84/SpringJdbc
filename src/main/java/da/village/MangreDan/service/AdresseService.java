package da.village.MangreDan.service;

import java.util.List;

import da.village.MangreDan.model.Adresse;

public interface AdresseService {

	public Adresse addAdresse(Adresse adresse);
	
	public List<Adresse> all();
}
