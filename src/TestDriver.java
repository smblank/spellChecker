public class TestDriver {
	public static void main (String[] args) {
		//Create Patricia Trie
		char[] testData = "air airplane airways has hat horse house sea".toCharArray();
		char[] testData2 = "Popplio Peepachu merlot driver test".toCharArray();
		IPatriciaTrie trie = new PatriciaTrie(testData);
		IPatriciaTrie trie2 = new PatriciaTrie(testData2);

		System.out.println(trie.search("airplane"));

		BTree newNode = new BTree(trie);
		BTree node2 = new BTree(trie2);

		newNode.add(node2);
		newNode.remove(node2);
	}
}
