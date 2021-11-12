package com.seventeen.feature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InstanceOfExampleTest {

    InstanceOfExample example = new InstanceOfExample();

    @Test
    void should_print_instanceOf_example() {
        Object o = "I am a String as an object";
        example.matchInstanceOfPattern(o);
    }

    @Test
    void should_exception_instanceOf_example() {
        Object o = 123;
        Assertions.assertThrows(RuntimeException.class, () -> example.matchInstanceOfPattern(o));
    }
}
