package com.xyzcorp.containers;

import com.xyzcorp.people.American;
import com.xyzcorp.people.Person;
import org.junit.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class BoxTest {

    @Test
    public void testStaticFactory() {
        Box<Integer> box = Box.of(40);
        assertThat(box.getContent()).isEqualTo(40);
    }

    @Test
    public void testBox() {
        Box<String> bs = new Box<>("Hello"); //Box<String>
        Box<Integer> transformed = bs.map(s -> s.length()); //Return Box<Number>
        System.out.println(transformed.getContent() == 5);
    }

    /**
     * Notice here that the CharSequence is a "super" type of String
     * which is what the Box contains. The outside is a Number
     * so that establishes the "B" or return type. Therefore we need
     * something that is a Number or less, an Integer.
     */
    @Test
    public void testBoxWithAlternateTypes() {
        Box<String> bs = new Box<>("Hello"); //Box<String>

        /*
          Previous established with Box, because of this flexibility
          we can use CharSequence, and we are returning American
         */
        Function <CharSequence, Person> fun =
                new Function<CharSequence, Person>(){
            @Override
            public American apply(CharSequence charSequence) {
                return new American();
            }
        };

        //The above function will fit, that's the flexibility that we gain!
        Box<Person> map = bs.map(fun);

        Person person = map.getContent();
        System.out.println(person);
    }
}