import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataCollection {
	public static void main (String[] args) throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
		File in = new File("D:\\Desktop\\School\\Advanced Data Structures - Desktop\\spellChecker\\src\\dictionary.txt");
		Scanner scanner = new Scanner(in);

		File out = new File("D:\\Desktop\\School\\Advanced Data Structures - Desktop\\spellChecker\\src\\scriptedTests.txt");
		FileOutputStream fos = new FileOutputStream(out);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		String s = "";
		s = scanner.nextLine();
		while (scanner.hasNextLine()) {
			s = s + " " + scanner.nextLine();
		}

		char[] dictionary = s.toCharArray();

		int listSize = 10;
		int editDistance = 5;
		IPatriciaTrie trie = new PatriciaTrie(dictionary);
		List<String> replacements = new ArrayList<>();
		long startTime, endTime, elapsed;
		String word;

		word = "definately";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "expirement";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "wierd";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "acheive";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "calender";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "imediately";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "teh";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "usualy";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "vacume";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "troubleshooting";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "becuase";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "adress";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "wether";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "commited";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "lenght";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "wich";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "wheather";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "acomodate";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "basicly";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "programing";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "genderfluid";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "acumne";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "behove";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "myriad";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		word = "nosisome";
		startTime = System.nanoTime();
		bw.write(word + " ");
		replacements = trie.findWords(listSize, editDistance, word);
		for (String str: replacements) {
			bw.write(str + ", ");
		}
		endTime = System.nanoTime();
		elapsed = (long) ((endTime - startTime) /  1000000.0);
		bw.write(String.valueOf(elapsed) + " ms");
		bw.newLine();

		bw.close();


		BTree tree = new BTree(trie);
		DamerauLevenshtein dl = new DamerauLevenshtein(tree);

		Editor e = new Editor(dl);
	}
}
