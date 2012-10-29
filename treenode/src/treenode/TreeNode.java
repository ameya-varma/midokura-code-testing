package treenode;

/**
 * Binary tree with only parent data for Midokura code testing
 * <p/>
 * Carlos Saltos 29/10/12 11:25
 */
public class TreeNode {

    private TreeNode parent;

    /**
     * Constructs a tree node with its parent information
     * @param parent maybe null for a root node or a parent node for a child node
     */
    public TreeNode(TreeNode parent) {
        this.parent = parent;
    }

    /**
     * Given another TreeNode finds the first (deepest in the tree) common ancestor of 'this' TreeNode and
     * the one passed to the method
     * @param other the node where to look for the first common ancestor
     * @return the first common ancestor if found, null otherwise
     */
    public TreeNode findFirstCommonAncestor(TreeNode other) {
        if (other == null) {
            return null;
        }
        return findFirstCommonAncestorRecursive(this, this, other);
    }


    /**
     * Iterates this nodes parents in look for a first common parent in the other parents nodes
     * @param thisInitialNode the original this node to continue the traversing to the next other parent
     * @param thisVisitor for traversing the this node parents
     * @param otherVisitor for traversing the other node parents
     * @return first common parent node if found or null otherwise
     */
    private TreeNode findFirstCommonAncestorRecursive(TreeNode thisInitialNode, TreeNode thisVisitor, TreeNode otherVisitor) {
        if (thisVisitor == null && otherVisitor == null) {
            // empty tree nodes case
            return null;
        } else if (thisVisitor.parent == null && otherVisitor.parent == null) {
            // no common ancestor found (the nodes are not part of the same tree)
            return null;
        } else if (thisVisitor.parent == null && otherVisitor.parent != null) {
            // traversing "other" parent nodes iteration
            return findFirstCommonAncestorRecursive(thisInitialNode, thisInitialNode, otherVisitor.parent);
        } else {
            // testing common ancestor parent
            if (thisVisitor.parent == otherVisitor.parent) {
                return thisVisitor.parent;
            }
            // traversing "this" parent nodes
            return findFirstCommonAncestorRecursive(thisInitialNode, thisVisitor.parent, otherVisitor);
        }
    }

}
