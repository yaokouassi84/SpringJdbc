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
	private String barcode; // nouvelle propriété
	private String barcodeImage; // image du code-barres en base64
	
	public Village() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 public Village(Long id, String nom, String langue, String barcode, String barcodeImage) {
	        super();
	        this.id = id;
	        this.nom = nom;
	        this.langue = langue;
	        this.barcode = barcode;
	        this.barcodeImage = barcodeImage;
	    }

	    // getters et setters
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

	    public String getBarcode() {
	        return barcode;
	    }

	    public void setBarcode(String barcode) {
	        this.barcode = barcode;
	    }

	    public String getBarcodeImage() {
	        return barcodeImage;
	    }

	    public void setBarcodeImage(String barcodeImage) {
	        this.barcodeImage = barcodeImage;
	    }

	    @Override
	    public String toString() {
	        return "Village [id=" + id + ", nom=" + nom + ", langue=" + langue + ", barcode=" + barcode + ", barcodeImage=" + barcodeImage + "]";
	    }
	
}
