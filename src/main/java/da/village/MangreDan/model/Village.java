package da.village.MangreDan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Village {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String langue;
	public Village() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Village(Long id, String nom, String langue) {
		super();
		this.id = id;
		this.nom = nom;
		this.langue = langue;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	@Override
	public String toString() {
		return "Village [id=" + id + ", nom=" + nom + ", langue=" + langue + "]";
	}
	
	
}
