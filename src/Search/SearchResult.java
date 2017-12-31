package Search;

public class SearchResult {
	public SearchResult(int i, String string) {
		ID = i;
		name = string;
	}

	@Override
	public String toString() {
		return "" + ID + "," + name;
	}

	public int ID;
	public String name;
}
