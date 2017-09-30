package com.xyzcorp;

import com.xyzcorp.subclassing.MySafeNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SubclassTest {

    //23. Subclass Test
    @Test
    public void testIssueWithSubclassingGenerics() throws Exception {
        MySafeNode<Integer> mySafeNode = new MySafeNode<>(40);
        assertThatThrownBy(() -> {mySafeNode.setData(null);}).isInstanceOf(NullPointerException.class);
    }
}
