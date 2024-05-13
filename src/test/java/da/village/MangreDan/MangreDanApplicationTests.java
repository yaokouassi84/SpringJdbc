package da.village.MangreDan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import da.village.MangreDan.model.Adresse;
import da.village.MangreDan.service.AdresseServiecJPA;

@SpringBootTest
class MangreDanApplicationTests {

	/*@PersistenceContext
	private EntityManager em;
	*/
	
	
	@Autowired
	private AdresseServiecJPA ads;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testJPA() {
		
		Adresse ad = new Adresse();
		ad.setCp("84521");
		ad.setPays("France");
		ad.setRue("De la Paix");
		ad.setVille("Paris");
		ads.addAdresse(ad);
		//em.close();
	}

}
