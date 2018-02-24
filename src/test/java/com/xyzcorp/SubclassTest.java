package com.xyzcorp;

import com.xyzcorp.subclassing.MySafeNode;
import com.xyzcorp.subclassing.Node;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SubclassTest {

    //23. Subclass Test
    @Test
    public void testIssueWithSubclassingGenerics() {
        Node<Integer> mySafeNode = new MySafeNode<>(40);
        mySafeNode.setData(null);
    }
}
