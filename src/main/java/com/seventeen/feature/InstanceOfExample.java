package com.seventeen.feature;

public class InstanceOfExample {
    public void matchInstanceOfPattern(Object o) {
        if (o instanceof String str) {
            System.out.println(str.toLowerCase());
        }
        //The following code is also valid
        if (o instanceof String str && !str.isEmpty()) {
            System.out.println(str.toLowerCase());
        }

        //The following code also valid
        if (!(o instanceof String str)) {
            throw new RuntimeException("Please provide string!");
        }
    }
}
