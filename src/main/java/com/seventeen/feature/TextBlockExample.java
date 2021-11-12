package com.seventeen.feature;

public class TextBlockExample {
    public String noLineTextBlock() {
        return """
                Footballers \
                with double space indentation \
                and "SW TEST ACADEMY TEAM" Rocks! \
                """;
    }

    public String insertBlockVariables() {
        return """
                Footballers
                  with double space indentation
                    and "%s" Rocks!
                """.formatted("SW TEST ACADEMY TEAM");
    }
}
