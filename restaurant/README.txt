TreeNode Midokura Code Testing

Author: Carlos Saltos


* Problem statement

You have the following Java class:

public class TreeNode {
   TreeNode parent;
   TreeNode findFirstCommonAncestor(TreeNode other);
}

Implement the 'findFirstCommonAncestor' method that given another TreeNode
finds the first (deepest in the tree) common ancestor of 'this' TreeNode and
the one passed to the method. Assume that each TreeNode is a node in a
binary tree. You may add methods but not data members to the TreeNode class.

* Solution code and running

The source code of the solution is at src/treenode and for running, there are JUnit tests at src/treenode/test.

NOTE: IntelliJ or Eclipse can be used for running the tests and also Apache Ant with the file build.xml

* Time and Space

The memory space of this solution is in order of the size of the original
tree. The bigger the original tree, the more memory uses initially. The memory
is NOT incremented while traversing the tree, since the visitors are
iterative.

The time for this solution is in order of the depth of this node and the depth
of that node. As deeper are the nodes, the time is in order of multiplication
of both since the traversal is an iteration on both nodes parents.
