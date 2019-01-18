import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name="resa_seq")
public class Reservation {
	@Id
	@GeneratedValue
	(strategy=GenerationType.SEQUENCE, generator="resa_seq")
	private Integer id;
	@Column(unique = true)
	private String numResa;
	@NotNull
	@ManyToOne
	private Vol vol;
	@NotBlank
	private String nom;
	@NotBlank
	private String prenom;
	@NotNull
	private Integer age;
	
	public Reservation() {
		
	}

	public Reservation(Vol vol, String nom, String prenom, Integer age) {
		this.vol = vol;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNumResa() {
		return numResa;
	}

	public void setNumResa(String numResa) {
		this.numResa = numResa;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", numResa=" + numResa + ", vol=" + vol + ", nom=" + nom + ", prenom=" + prenom
				+ ", age=" + age + "]";
	}
}
