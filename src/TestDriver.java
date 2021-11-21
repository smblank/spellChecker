import javax.swing.*;
import java.util.List;

public class TestDriver {
	public static void main (String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
		//Create Patricia Trie
		char[] testData = "air airplane airways has hat horse house sea".toCharArray();
		char[] testData2 = "Popplio Peepachu merlot driver test".toCharArray();
		char[] testData3 = "Cat in the Hat Joan of Ark Pikachu Pokemon Pizza Halloween Ladylike".toCharArray();
		IPatriciaTrie trie = new PatriciaTrie(testData);
		IPatriciaTrie trie2 = new PatriciaTrie(testData2);
		IPatriciaTrie trie3 = new PatriciaTrie(testData3);

		//System.out.println(trie.search("airplane"));

		BTree newNode = new BTree(trie);
		BTree node2 = new BTree(trie2);
		BTree node3 = new BTree(trie3);

		newNode.add(node2);
		newNode.add(node3);
		newNode.remove(node2);

		//List<String> words = trie.findWords(2, 10, "host");

		//System.out.println(words);

		DamerauLevenshtein dl = new DamerauLevenshtein(newNode);
		String test = "horny host";
		List<IncorrectWords> incorrects = dl.checkSpelling(test);
		for (IncorrectWords w:incorrects) {
			System.out.println(w.word);
			for (String r:w.replacements) {
				System.out.println(r);
			}
			System.out.println("\n\n");
		}

		Editor e = new Editor(dl);
	}
}
