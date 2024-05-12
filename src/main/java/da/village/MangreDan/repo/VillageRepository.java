package da.village.MangreDan.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import da.village.MangreDan.model.Village;

public interface VillageRepository extends JpaRepository<Village, Long> {
	
	/*@Autowired
    public void setDataSource(DataSource dataSource);*/
	
}
