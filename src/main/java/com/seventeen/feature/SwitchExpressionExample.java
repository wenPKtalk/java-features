package com.seventeen.feature;

public class SwitchExpressionExample {
    public void exampleOldSwitch(FootballPosition footballPosition) {
        switch (footballPosition) {
            case GOALKEEPER:
                System.out.println("Goal Keeper: Buffon");
                break;
            case DEFENCE:
                System.out.println("Defence: Ramos");
                break;
            case MIDFIELDER:
                System.out.println("Midfielder: Messi");
                break;
            case STRIKER:
                System.out.println("Striker: Zlatan");
                break;
            default:
                System.out.println("Please select a footballer from the BENCH!");
        }
    }

    /**
     * New feature:
     * 1. Use "->" instead of ":"
     * Allow multiple constants per case,
     * Does not have fall-through semantics (i.e,Does not require breaks)
     * Make variables defined inside a case branch local to this branch
     * A "default" branch has to be provided
     */

    public void exampleNewSwitch(FootballPosition position) {
        switch (position) {
            case GOALKEEPER -> System.out.println("Goal Keeper: Buffon");
            case DEFENCE -> System.out.println("Defence: Ramos");
            case MIDFIELDER -> System.out.println("Midfielder: Messi");
            case STRIKER -> System.out.println("Striker: Zlatan");
            default -> System.out.println("Please select a footballer from the BENCH!");
        }
    }

    /**
     * If the right-hand side of a single case requires more code, it can be written inside a block,and the value
     * is return using yield
     */
    public void exampleReturnWithSwitch(FootballPosition position) {
        String footballer = switch (position) {
            case GOALKEEPER, DEFENCE -> {
                System.out.println("Defensive Footballer Selection!");
                yield "Defence: Ramos";
            }
            case MIDFIELDER, STRIKER -> {
                System.out.println("Offensive Footballer Selection!");
                yield "Midfielder: Messi";
            }
            default -> "Please select a footballer from the BENCH!";
        };
        System.out.println(footballer);
    }
}
