
public enum TypeAvion {
	A330(110), A340(125), A380(215), B747(400);
	
	private Integer nbPlace;
	
	TypeAvion(Integer nbPlace) {
		this.setNbPlace(nbPlace);
	}

	public Integer getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}

	
}
