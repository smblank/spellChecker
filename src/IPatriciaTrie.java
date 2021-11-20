import java.util.ArrayList;
import java.util.List;

public interface IPatriciaTrie {
	int search (String word);
	List<String> findWords(int listSize, int editDistance, String word);

	void setParentPtr(IPatriciaTrie newParent);
	void addChildPtr(IPatriciaTrie newChild);
	void removeChildPtr(IPatriciaTrie child);
	void removeChildPtrs();
	void setNextPtr(IPatriciaTrie newNext);
	void setPrevPtr(IPatriciaTrie newPrev);

	IPatriciaTrie getParentPtr();
	List<IPatriciaTrie> getChildPtr();
	IPatriciaTrie getNextPtr();
	IPatriciaTrie getPrevPtr();
}
