import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class BTree extends DefaultMutableTreeNode {
	private IPatriciaTrie trie;

	public BTree(IPatriciaTrie trieNode) {
		setUserObject(trieNode);
		trie = trieNode;
	}

	@Override
	public void add (MutableTreeNode newChild) {
		IPatriciaTrie childTrie = (IPatriciaTrie) ((DefaultMutableTreeNode)newChild).getUserObject();

		if (!isRoot() && isLeaf()) {
			IPatriciaTrie parent = (IPatriciaTrie) ((DefaultMutableTreeNode)getParent()).getUserObject();
			childTrie.setParentPtr(parent);
			parent.setChildPtr(childTrie);
		}
		else {
			childTrie.setParentPtr(trie);
			trie.setChildPtr(childTrie);
		}

		Enumeration<TreeNode> children = children();
		DefaultMutableTreeNode childNode;
		while (children.hasMoreElements()) {
			childNode = (DefaultMutableTreeNode) children.nextElement();
			childTrie.setPrevPtr((IPatriciaTrie) childNode.getUserObject());

			if (!children.hasMoreElements()) {
				IPatriciaTrie trieNode = (IPatriciaTrie) childNode.getUserObject();
				trieNode.setNextPtr(childTrie);
			}
		}

		MutableTreeNode newNode = new DefaultMutableTreeNode(newChild);
		super.add(newNode);
	}

	@Override
	public void remove (int childIndex) {
		remove((MutableTreeNode) getChildAt(childIndex));
	}

	@Override
	public void remove (MutableTreeNode aChild) {
		IPatriciaTrie childTrie = (IPatriciaTrie) ((DefaultMutableTreeNode)aChild).getUserObject();
//		IPatriciaTrie parentTrie = childTrie.getParentPtr();
//
//		if (getParent().getChildCount() - 1 < 2) {
//			Enumeration<TreeNode> subTree = ((DefaultMutableTreeNode)getParent()).depthFirstEnumeration();
//			DefaultMutableTreeNode subNode;
//			boolean foundNewParent = false;
//			while (subTree.hasMoreElements()) {
//				subNode = (DefaultMutableTreeNode) subTree.nextElement();
//
//				if (subNode.getChildCount() - 1 >= 2) {
//					foundNewParent = true;
//					break;
//				}
//			}
//
//			if (!foundNewParent) {
//				//Combine two children into one
//
//			}
//
//			DefaultMutableTreeNode newChild = subNode.getChildAt(0);
//			((IPatriciaTrie) subNode.getUserObject()).setChildPtr(null);
//			((IPatriciaTrie) newChild.getUserObject()).setParentPtr((IPatriciaTrie) ((DefaultMutableTreeNode) getParent()).getUserObject());
//		}

		//Child has siblings
		if (childTrie.getNextPtr() != null || childTrie.getPrevPtr() != null) {
			//Child is a leaf
			if (aChild.isLeaf()) {
				childTrie.getParentPtr().setChildPtr(null);
			}

			//Child is internal node
			else {
				Enumeration<TreeNode> children = children();
				TreeNode firstChild = children.nextElement();
				IPatriciaTrie firstChildTrie = (IPatriciaTrie) ((DefaultMutableTreeNode)firstChild).getUserObject();

				childTrie.getParentPtr().setChildPtr(firstChildTrie);

				firstChildTrie.setNextPtr(childTrie.getNextPtr());
				firstChildTrie.setPrevPtr(childTrie.getPrevPtr());

				IPatriciaTrie prev = null;
				DefaultMutableTreeNode childNode;
				if (children.hasMoreElements()) {
					childNode = (DefaultMutableTreeNode) children.nextElement();
					while (children.hasMoreElements()) {
						((IPatriciaTrie)(childNode).getUserObject()).setPrevPtr(prev);
						prev = (IPatriciaTrie)(childNode).getUserObject();

						if (children.hasMoreElements()) {
							DefaultMutableTreeNode nextChild = (DefaultMutableTreeNode) children.nextElement();
							((IPatriciaTrie)(childNode).getUserObject()).setNextPtr((IPatriciaTrie) nextChild.getUserObject());
							childNode = nextChild;
						}
					}
				}
			}
		}

		//Only child
		else {
			//Child is a leaf
			if (aChild.isLeaf()) {
				childTrie.getParentPtr().setChildPtr(null);
			}

			//Child is internal node
			else {
				Enumeration<TreeNode> children = children();
				TreeNode firstChild = children.nextElement();
				IPatriciaTrie firstChildTrie = (IPatriciaTrie) ((DefaultMutableTreeNode)firstChild).getUserObject();

				childTrie.getParentPtr().setChildPtr(firstChildTrie);

				firstChildTrie.setNextPtr(null);
				firstChildTrie.setPrevPtr(null);

				IPatriciaTrie prev = null;
				DefaultMutableTreeNode childNode;
				if (children.hasMoreElements()) {
					childNode = (DefaultMutableTreeNode) children.nextElement();
					while (children.hasMoreElements()) {
						((IPatriciaTrie)(childNode).getUserObject()).setPrevPtr(prev);
						prev = (IPatriciaTrie)(childNode).getUserObject();

						if (children.hasMoreElements()) {
							DefaultMutableTreeNode nextChild = (DefaultMutableTreeNode) children.nextElement();
							((IPatriciaTrie)(childNode).getUserObject()).setNextPtr((IPatriciaTrie) nextChild.getUserObject());
							childNode = nextChild;
						}
					}
				}
			}
		}

		childTrie.setParentPtr(null);
		childTrie.setChildPtr(null);
		childTrie.setNextPtr(null);
		childTrie.setPrevPtr(null);

		super.remove(aChild);
	}
}
