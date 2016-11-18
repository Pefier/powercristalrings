package com.pefier.powercristalrings.utility;

/**
 * Created by Pefier on 14.11.2016.
 */
public class TestTree {
    private GenericTree<Integer> tree = null;

    public TestTree() {
        GenericTreeNode<Integer> node = new GenericTreeNode<Integer>(1);
        node.addChild(new GenericTreeNode<Integer>(2));
        node.addChild(new GenericTreeNode<Integer>(3));
        node.getChildren().get(0).addChild(new GenericTreeNode<Integer>(4));

    }
}
