package treenode.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import treenode.TreeNode;

/**
 * Test cases for TreeNode
 *
 * Carlos Saltos 29/10/12 11:31
 */
public class TreeNodeTest {

    // Fixture

    private TreeNode tree;
    private TreeNode f;
    private TreeNode b;
    private TreeNode h;
    private TreeNode a;
    private TreeNode d;
    private TreeNode c;
    private TreeNode e;
    private TreeNode g;
    private TreeNode i;

    private TreeNode otherTree;
    private TreeNode x;
    private TreeNode y;
    private TreeNode z;

    @Before public void setUp() {

        // Tree:
        //                                            F
        //                         |------------------|-----------------|
        //                         B                                    H
        //              |----------|----------|              |----------|----------|
        //              A                     D              G                     I
        //                         |----------|----------|
        //                         C                     E
        this.f = new TreeNode(null);
        this.b = new TreeNode(f);
        this.h = new TreeNode(f);
        this.a = new TreeNode(b);
        this.d = new TreeNode(b);
        this.c = new TreeNode(d);
        this.e = new TreeNode(d);
        this.g = new TreeNode(h);
        this.i = new TreeNode(h);
        this.tree = f;

        // Tree:
        //                                            Y
        //                         |------------------|-----------------|
        //                         X                                    Z
        this.y = new TreeNode(null);
        this.x = new TreeNode(y);
        this.z = new TreeNode(y);
        this.otherTree = y;
    }

    @Test public void testFindFirstCommonAncestorNullCase() {
        TreeNode other = null;
        TreeNode result = tree.findFirstCommonAncestor(other);
        Assert.assertNull(result);
    }

    @Test public void testFindFirstCommonAncestorNullParentCase() {
        TreeNode other = new TreeNode(null);
        TreeNode result = tree.findFirstCommonAncestor(other);
        Assert.assertNull(result);
    }

    @Test public void testFindFirstCommonAncestorNoCommonTree() {
        TreeNode result = tree.findFirstCommonAncestor(otherTree);
        Assert.assertNull(result);
    }

    @Test public void testFindFirstCommonAncestorTree() {
        // The first common ancestor of C and G is F
        TreeNode result = c.findFirstCommonAncestor(g);
        Assert.assertEquals(result, f);
    }

    @Test public void testFindFirstCommonAncestorTree2() {
        // The first common ancestor of A and E is B
        TreeNode result = a.findFirstCommonAncestor(e);
        Assert.assertEquals(result, b);
    }

    @Test public void testFindFirstCommonAncestorTree3() {
        // The first common ancestor of A and I is F
        TreeNode result = a.findFirstCommonAncestor(i);
        Assert.assertEquals(result, f);
    }

    @Test public void testFindFirstCommonAncestorOtherTree() {
        // The first common ancestor of X and Z is Y
        TreeNode result = x.findFirstCommonAncestor(z);
        Assert.assertEquals(result, y);
    }

}
