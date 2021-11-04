public class TestDriver {
	public static void main (String[] args) {
		//Create Patricia Trie
		char[] testData = "air airplane airways has hat horse house sea".toCharArray();
		IPatriciaTrie trie = new PatriciaTrie(testData);

		System.out.println(trie.search("2"));
	}
}
