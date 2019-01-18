import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name="vol_seq")
public class Vol{
	@Id
	@GeneratedValue
	(strategy=GenerationType.SEQUENCE, generator="vol_seq")
	private Integer id;
	@NotNull
	@Column(unique = true)
	private Integer numVol;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private TypeAvion typeAvion;
	@NotNull
	private Integer nbPlace;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Villes villeDep;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Villes villeArr;
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date dateDep;
	
	public Vol() {
		
	}

	public Vol(Integer numVol, TypeAvion typeAvion, Villes villeDep, Villes villeArr,
			String dateDep) {
		this.numVol = numVol;
		this.typeAvion = typeAvion;
		this.nbPlace = typeAvion.getNbPlace();
		this.villeDep = villeDep;
		this.villeArr = villeArr;
		this.setDateDep(dateDep);
	}

	public Integer getNumVol() {
		return numVol;
	}

	public void setNumVol(Integer numVol) {
		this.numVol = numVol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeAvion getTypeAvion() {
		return typeAvion;
	}

	public void setTypeAvion(TypeAvion typeAvion) {
		this.typeAvion = typeAvion;
	}

	public Integer getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}

	public Villes getVilleDep() {
		return villeDep;
	}

	public void setVilleDep(Villes villeDep) {
		this.villeDep = villeDep;
	}

	public Villes getVilleArr() {
		return villeArr;
	}

	public void setVilleArr(Villes villeArr) {
		this.villeArr = villeArr;
	}

	public Date getDateDep() {
		return dateDep;
	}

	public void setDateDep(String dateDep) {
		try {
			this.dateDep = new SimpleDateFormat("yyyy/MM/dd").parse(dateDep);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "Vol [id=" + id + ", numVol=" + numVol + ", typeAvion=" + typeAvion + ", nbPlace=" + nbPlace
				+ ", villeDep=" + villeDep + ", villeArr=" + villeArr + ", dateDep=" + dateDep + "]";
	}
}
