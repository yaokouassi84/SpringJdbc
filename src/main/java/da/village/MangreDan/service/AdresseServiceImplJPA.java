package da.village.MangreDan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import da.village.MangreDan.model.Adresse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class AdresseServiceImplJPA implements AdresseServiecJPA{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Adresse addAdresse(Adresse adresse) {
		em.persist(adresse);
		em.close();
		return adresse;
	}

	@Override
	public Adresse findAdresseByRue(String rue) {
		
		return null;
	}

	@Override
	public List<Adresse> all() {
		
		return null;
	}
	
	
	

}
