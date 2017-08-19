package com.xyzcorp;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

public class HeapPollutionTest {

    //21: HeapPollutionTest
    @Test
    @SuppressWarnings({"unchecked", "UnnecessaryLocalVariable"})
    public void testTypePollution() {
        List ln = Lists.<Number>newArrayList(5,1,3,5,6,10); //Converting to RawType!
        List<String> ls = ln;  // unchecked warning
        String s = ls.get(0); // ClassCastException
    }
}
