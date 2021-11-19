public class TestDriver {
	public static void main (String[] args) {
		//Create Patricia Trie
		char[] testData = "air airplane airways has hat horse house sea".toCharArray();
		char[] testData2 = "Popplio Peepachu merlot driver test".toCharArray();
		char[] testData3 = "Cat in the Hat Joan of Ark Pikachu Pokemon Pizza Halloween Ladylike".toCharArray();
		IPatriciaTrie trie = new PatriciaTrie(testData);
		IPatriciaTrie trie2 = new PatriciaTrie(testData2);
		IPatriciaTrie trie3 = new PatriciaTrie(testData3);

		System.out.println(trie.search("airplane"));

		BTree newNode = new BTree(trie);
		BTree node2 = new BTree(trie2);
		BTree node3 = new BTree(trie3);

		newNode.add(node2);
		newNode.add(node3);
		newNode.remove(node2);

		System.out.println(newNode.getUserObject());
		System.out.println(((PatriciaTrie) newNode.getUserObject()).getParentPtr());
		System.out.println(((PatriciaTrie) newNode.getUserObject()).getChildPtr());
		System.out.println("\n\n");

		System.out.println(node2.getUserObject());
		System.out.println(((PatriciaTrie) node2.getUserObject()).getParentPtr());
		System.out.println(((PatriciaTrie) node2.getUserObject()).getChildPtr());
		System.out.println(((PatriciaTrie) node2.getUserObject()).getNextPtr());
		System.out.println(((PatriciaTrie) node2.getUserObject()).getPrevPtr());
		System.out.println("\n\n");

		System.out.println(node3.getUserObject());
		System.out.println(((PatriciaTrie) node3.getUserObject()).getParentPtr());
		System.out.println(((PatriciaTrie) node3.getUserObject()).getChildPtr());
		System.out.println(((PatriciaTrie) node3.getUserObject()).getNextPtr());
		System.out.println(((PatriciaTrie) node3.getUserObject()).getPrevPtr());
	}
}
