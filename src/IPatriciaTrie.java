public interface IPatriciaTrie {
	int search (String word);

	void setParentPtr(IPatriciaTrie newParent);
	void setChildPtr(IPatriciaTrie newChild);
	void setNextPtr(IPatriciaTrie newNext);
	void setPrevPtr(IPatriciaTrie newPrev);

	IPatriciaTrie getParentPtr();
	IPatriciaTrie getChildPtr();
	IPatriciaTrie getNextPtr();
	IPatriciaTrie getPrevPtr();
}
