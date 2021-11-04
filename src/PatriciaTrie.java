import java.util.List;
import java.util.ArrayList;

public class PatriciaTrie implements IPatriciaTrie {
	private IPatriciaTrie parentPtr = null;
	private IPatriciaTrie childPtr = null;
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
		this.page = page;
		rootNext = new ArrayList<>();

		//Initialize nextArr's size and set Integers to -1 to mark no next
		nextArr = new ArrayList<>();
		for (int i = 0; i < page.length; ++i) {
			List<Integer> temp = new ArrayList<>();
			//temp.add(-1);

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
		for (char c: word.toCharArray()) {
			//Loop through nexts for current page index
			for (int i = 0; i < nextArr.get(pageInd).size(); ++i) {
				//If the character stored at the index for current next == current character
				if (nextArr.get(pageInd).get(i) != -1 &&
					page[nextArr.get(pageInd).get(i)] == c) {
					//Increment page index to that next index
					pageInd = nextArr.get(pageInd).get(i);

					break;
				}
			}

			//If a next index wasn't found, return -1 to indicate word was not found in trie
			return -1;
		}
		//Return the current index the page is at
		return pageInd;
	}

	public void setParentPtr(IPatriciaTrie newParent) {
		parentPtr = newParent;
	}

	public void setChildPtr(IPatriciaTrie newChild) {
		childPtr = newChild;
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

	public IPatriciaTrie getChildPtr() {
		return childPtr;
	}

	public IPatriciaTrie getNextPtr() {
		return nextPtr;
	}

	public IPatriciaTrie getPrevPtr() {
		return prevPtr;
	}
}
