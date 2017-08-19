package com.xyzcorp;

import com.xyzcorp.bridge.MyNode;
import com.xyzcorp.bridge.Node;
import org.junit.Test;

public class BridgeTest {

    //24. Bridge Test
    @Test
    public void testBridgeMethod() throws Exception {
        MyNode mn = new MyNode(5); //raw
        Node n = mn;                     //raw
        n.setData("Hello"); //Allowed because of created Object parameter
        Integer x = mn.data; //Class cast exception obviously
    }
}
