package Controller;

public enum TypeAvion {
	A330(110), A340(125), A380(215), B747(400);
	
	private Integer nbPlace;
	
	TypeAvion(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}

	public Integer getNbPlace() {
		return nbPlace;
	}
	
}
