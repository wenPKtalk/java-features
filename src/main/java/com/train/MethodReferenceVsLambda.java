package com.train;

public class MethodReferenceVsLambda {
    public static void main(String[] args) {
        //lazy initialize
        Runnable universelImpactRunnable = () -> new ChuckNorris().roundHouseKick();
        System.out.println("-----------------------");
        /*
         * Will invoke make numberKicks to 1
         * and galaxyDamage = 0;
         */
        Runnable galaxyImpactRunnable = new ChuckNorris()::roundHouseKick;
        System.out.print("The galaxy is finished = ");
        universelImpactRunnable.run(); // will invoke constructor galaxyDamage = 1; numberKicks to 2
        universelImpactRunnable.run(); // will invoke constructor galaxyDamage = 2; numberKicks to 3

        galaxyImpactRunnable.run(); //numberKicks is 0
        galaxyImpactRunnable.run();//numberKicks is 0
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
