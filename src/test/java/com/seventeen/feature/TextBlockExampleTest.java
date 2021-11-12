package com.seventeen.feature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextBlockExampleTest {
    TextBlockExample textBlockExample = new TextBlockExample();

    @Test
    void textBlocksNoLineBreaksTest() {
        String except = "Footballers with double space indentation and \"SW TEST ACADEMY TEAM\" Rocks! ";
        assertEquals(except, textBlockExample.noLineTextBlock());
    }

    @Test
    void textBlocksInsertingVariablesTest() {
        String except = """
                Footballers
                  with double space indentation
                    and "SW TEST ACADEMY TEAM" Rocks!
                """;
        assertEquals(except, textBlockExample.insertBlockVariables());
    }
}