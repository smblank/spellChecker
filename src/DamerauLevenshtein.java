import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class IncorrectWords {
	public String word;
	public List<String> replacements;

	public IncorrectWords (String w, List<String> r) {
		word = w;
		replacements = r;
	}
}

public class DamerauLevenshtein {
	private BTree stringTree;
	private int maxListSize = 10;
	private int maxEditDistance = 3;

	public DamerauLevenshtein (BTree root) {
		stringTree = root;
	}

	public List<String> automata (String word) {
		Enumeration<TreeNode> bfsTree = stringTree.breadthFirstEnumeration();
		List<String> replaceList = ((IPatriciaTrie) stringTree.getUserObject()).findWords(maxListSize, maxEditDistance, word);

		while (replaceList.isEmpty() && bfsTree.hasMoreElements()) {
			BTree node = (BTree) bfsTree.nextElement();
			replaceList = ((IPatriciaTrie) node.getUserObject()).findWords(maxListSize, maxEditDistance, word);
		}

		return replaceList;
	}

	public List<IncorrectWords> checkSpelling (String text) {
		String[] words = text.split(" ");
		List<IncorrectWords> incorrectWords = new ArrayList<>();

		for (String word:words) {
			List<String> replacements = automata(word);
				IncorrectWords newWord = new IncorrectWords (word, replacements);
				incorrectWords.add(newWord);
		}

		return incorrectWords;
	}
}
