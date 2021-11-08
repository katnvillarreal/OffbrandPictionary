package offbrand_pictionary;

public class GenLobbyData {
	private String catChoice;
	private String typeChoice;
	
	public String getCat() {
	    return catChoice;
	}
	
	public String getType() {
	    return typeChoice;
	}

	public void setCat(String catChoice) {
	    this.catChoice = catChoice;
	}
	
	public void setType(String typeChoice) {
	    this.typeChoice = typeChoice;
	}

	public GenLobbyData(String catChoice, String typeChoice) {
		setCat(catChoice);
		setType(typeChoice);
	}
}
