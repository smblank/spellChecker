import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class PatriciaTrie implements IPatriciaTrie {
	private IPatriciaTrie parentPtr = null;
	private List<IPatriciaTrie> childPtr;
	private IPatriciaTrie nextPtr = null;
	private IPatriciaTrie prevPtr = null;

	private char[] page;
	private List<List<Integer>> nextArr;
	private List<Integer> rootNext;

	private int listHasChar(char c, List<Integer> arr) {
		for (int i = 0; i < arr.size(); ++i) {
			if (arr.get(i) != -1 && page[arr.get(i)] == c) {
				return arr.get(i);
			}
		}
		return -1;
	}

	public PatriciaTrie(char[] page) {
		childPtr = new ArrayList<>();
		this.page = page;
		rootNext = new ArrayList<>();

		//Initialize nextArr's size and set Integers to -1 to mark no next
		nextArr = new ArrayList<>();
		for (int i = 0; i < page.length; ++i) {
			List<Integer> temp = new ArrayList<>();

			nextArr.add(temp);
		}


		int nextInd = -1;
		//Loop through characters in page
		for (int i = 0; i < page.length; ++i) {
			if (page[i] != ' ') {
				//If next doesn't contain character, add it and then go to that character index in nextArr
				//Check root node
				if (nextInd == -1) {
					int charLocation = listHasChar(page[i], rootNext);
					if (charLocation < 0) {
						rootNext.add(i);
						nextInd = i;
					}
					else {
						nextInd = charLocation;
					}
				}

				//Check next array
				else {
					int charLocation = listHasChar(page[i], nextArr.get(nextInd));
					if (charLocation < 0) {
						nextArr.get(nextInd).add(i);
						nextInd = i;
					}
					else {
						nextInd = charLocation;
					}
				}
			}

			//Mark word as completed with -1 and reset next array at each new word (hitting a space)
			else {
				nextArr.get(i - 1).add(-1);
				nextInd = -1;
			}
		}
		//Mark last node in the list as end of word
		nextArr.get(page.length - 1).add(-1);
	}

	public int search(String word) {
		//Loop through characters in word & page
		int pageInd = 0;
		int next = -1;
		for (char c: word.toCharArray()) {
			boolean foundChar = false;
			//Loop through nexts for current page index
			if (next == -1) {
				for (int i = 0; i < rootNext.size() && !foundChar; ++i) {
					if (rootNext.get(i) != -1 &&
						page[rootNext.get(i)] == c) {
						pageInd = rootNext.get(i);
						next = pageInd;

						foundChar = true;
					}
				}
			}

			else {
				for (int i = 0; i < nextArr.get(next).size() && !foundChar; ++i) {
					//If the character stored at the index for current next == current character
					if (nextArr.get(next).get(i) != -1 &&
							page[nextArr.get(next).get(i)] == c) {
						//Increment page index to that next index
						pageInd = nextArr.get(next).get(i);
						next = pageInd;

						foundChar = true;
					}
				}
			}

			//If a next index wasn't found, return -1 to indicate word was not found in trie
			if (!foundChar) {
				return -1;
			}
		}
		//Check if word is marked as complete at this point and return the current index the page is at
		if (nextArr.get(pageInd).contains(-1)) {
			return pageInd;
		}

		else {
			return -1;
		}
	}

	int getLength(int pageInd) {
		int length = 0;

		for (int i = pageInd; page[i] != ' ' && i != 0; --i) {
			length++;
		}

		return length;
	}

	public List<String> findWords(int listSize, int editDistance, String word) {
		List<String> wordList = new ArrayList<>(listSize);

		//Stacks to track progress through tree
		Stack<Integer> horizontalStack = new Stack<>();
		Stack<Stack <Integer>> verticalStack = new Stack<>();

		boolean root = true;
		int pageInd = 0;
		int i = 0;
		boolean wordExists = true;
		for (char c:word.toCharArray()) {
			if (root) {
				horizontalStack.push(-1);
				for (i = 0; i < rootNext.size() && root; ++i) {
					horizontalStack.push(i);
					if (page[rootNext.get(i)] == c) {
						pageInd = rootNext.get(i);
						verticalStack.push(horizontalStack);
						horizontalStack = new Stack<>();
						root = false;
					}
				}

				if (root) {
					wordExists = false;
					break;
				}
			}

			else {
				boolean foundChar = false;
				horizontalStack.push(pageInd);
				for (i = 0; i < nextArr.get(pageInd).size() && !foundChar; ++i) {
					horizontalStack.push(i);
					if (page[nextArr.get(pageInd).get(i)] == c) {
						pageInd = nextArr.get(pageInd).get(i);
						verticalStack.push(horizontalStack);
						horizontalStack = new Stack<>();

						foundChar = true;
					}
				}

				if (!foundChar) {
					wordExists = false;
					break;
				}
			}
		}

		if (!wordExists) {
			int currDistance = 0;
			int tempDistance = 0;
			i--;
			while (wordList.size() < listSize) {
				if (pageInd == -1) {
					if (rootNext.get(i) == -1) {
						String newWord = new String(page, pageInd - getLength(pageInd) + 1, getLength(pageInd));
						wordList.add(newWord);

						return wordList;
					}

					else {
						verticalStack.push(horizontalStack);
						horizontalStack = new Stack<>();

						pageInd = rootNext.get(i);
						horizontalStack.push(pageInd);
						i = 0;
						horizontalStack.push(i);
						tempDistance++;
					}
				}
				if (nextArr.get(pageInd).get(i) == -1) {
					String newWord = new String(page, pageInd - getLength(pageInd) + 1, getLength(pageInd));
					wordList.add(newWord);

					horizontalStack = verticalStack.pop();
					pageInd = horizontalStack.get(0);
					i = horizontalStack.peek();
					++currDistance;
					if (pageInd == -1) {
						if (i + 1 < rootNext.size()) {
							i++;
							horizontalStack.push(i);
							continue;
						}

						//Hit the root node
						else {
							return wordList;
						}
					}
					while (i + 1 >= nextArr.get(pageInd).size()) {
						horizontalStack = verticalStack.pop();
						pageInd = horizontalStack.get(0);
						i = horizontalStack.peek();
						++currDistance;

						if (pageInd == -1) {
							if (i + 1 < rootNext.size()) {
								break;
							}

							//Hit the root node
							else {
								return wordList;
							}
						}
					}

					i++;
					horizontalStack.push(i);
				}

				else {
					verticalStack.push(horizontalStack);
					horizontalStack = new Stack<>();

					pageInd = nextArr.get(pageInd).get(i);
					horizontalStack.push(pageInd);
					i = 0;
					horizontalStack.push(i);
					tempDistance++;
				}
			}
		}

		return wordList;
	}

	public void setParentPtr(IPatriciaTrie newParent) {
		parentPtr = newParent;
	}

	public void addChildPtr(IPatriciaTrie newChild) {
		childPtr.add(newChild);
	}

	public void removeChildPtr(IPatriciaTrie child) {
		childPtr.remove(child);
	}

	public void removeChildPtrs() {
		childPtr.clear();
	}

	public void setNextPtr(IPatriciaTrie newNext) {
		nextPtr = newNext;
	}

	public void setPrevPtr(IPatriciaTrie newPrev) {
		prevPtr = newPrev;
	}

	public IPatriciaTrie getParentPtr() {
		return parentPtr;
	}

	public List<IPatriciaTrie> getChildPtr() {
		return childPtr;
	}

	public IPatriciaTrie getNextPtr() {
		return nextPtr;
	}

	public IPatriciaTrie getPrevPtr() {
		return prevPtr;
	}
}
