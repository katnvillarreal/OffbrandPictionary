package offbrand_pictionary;

import java.io.Serializable;

public class WinningData implements Serializable{
	// Private Data Members
	private String results;
	// Getter
	public String getResults() {return results;}
	// Setter
	public void setResults(String results) {this.results = results;}
	// Constructor
	public WinningData(String results) { setResults(results); }
}