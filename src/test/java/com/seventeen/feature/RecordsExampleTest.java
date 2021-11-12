package com.seventeen.feature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordsExampleTest {
    //Canonical constructor
    RecordsExample.Footballer footballer = new RecordsExample.Footballer("Ranaldo", 60, "MU");

    @Test
    void test_record_print() {
        System.out.println("Footballer's name:" + footballer.name());
        System.out.println("Footballer's age:" + footballer.age());
        System.out.println("Footballer's team:" + footballer.team());
    }

    @Test
    void should_basketBaller_field() {
        RecordsExample.BasketBaller basketBaller = new RecordsExample.BasketBaller("AAAA", 33);
        assertEquals("aaaa", basketBaller.name());
        assertEquals(33, basketBaller.age());
    }

    @Test
    void should_exception_when_age_0() {
        assertThrows(RuntimeException.class, () -> new RecordsExample.BasketBaller("BBBB", 0));
    }

}