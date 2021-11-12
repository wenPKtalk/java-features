package com.seventeen.feature;

public class RecordsExample {
    /**
     * With below record declaration, we automatically define:
     * Private final fields for age, name and team.
     * Canonical constructors for all fields,
     * getter for all fields,
     * equals,hashcode,and toString for all fields.
     */
    record Footballer(String name, int age, String team) {
    }

    record BasketBaller(String name, int age) {
        BasketBaller{
            if (age < 1) {
                throw new RuntimeException("Age less than 1 is not allowed");
            }

            name = name.toLowerCase();
        }

        //Explicit accessor
        public int age(){
            return this.age;
        }
    }
}
