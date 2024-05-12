package da.village.MangreDan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rue;
	private String cp;
	private String ville;
	private String pays;	
	
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Adresse(Long id, String rue, String cp, String ville, String pays) {
		super();
		this.id = id;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + ", pays=" + pays + "]";
	}
	
}
