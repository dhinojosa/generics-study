package com.xyzcorp;

import com.xyzcorp.subclassing.MySafeNode;
import com.xyzcorp.subclassing.Node;
import org.junit.Test;

public class SubclassTest {

    /**
     * 23. Subclass Test
     * Node<Integer> is the assigned variable. On the right hand
     * side is the MySafeNode which merely "passes the generic along"
     */
    @Test
    public void testIssueWithSubclassingGenerics() {
        Node<Integer> mySafeNode = new MySafeNode<>(40);
        mySafeNode.setData(null);
    }
}
