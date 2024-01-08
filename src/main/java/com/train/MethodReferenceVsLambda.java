package com.train;

public class MethodReferenceVsLambda {
    public static void main(String[] args) {
        Runnable universelImpactRunnable = () -> new ChuckNorris().roundHouseKick();
        System.out.println("-----------------------");
        Runnable galaxyImpactRunnable = new ChuckNorris()::roundHouseKick;
        System.out.print("The galaxy is finished = ");
        universelImpactRunnable.run();
        universelImpactRunnable.run();

        galaxyImpactRunnable.run();
        galaxyImpactRunnable.run();
    }

    static class ChuckNorris {
        private static int numberKicks;
        private final int galaxyDamage;

        public ChuckNorris() {
            System.out.println("new chuck norris!");
            this.galaxyDamage = numberKicks++;
        }

        void roundHouseKick() {
            System.out.println(this.galaxyDamage);
        }
    }
}
