package com.lullaby.pattern;

/**
 * 工厂模式
 */
public class CreateFactoryPattern {

    public static void main(String[] args) {

        Farm sgFarm = new SGfarm();
        sgFarm.produceAnimal().show();
        sgFarm.producePlant().show();
        Farm srFarm = new SRfarm();
        srFarm.produceAnimal().show();
        srFarm.producePlant().show();
    }

    interface Animal {
        void show();
    }

    static class Horse implements Animal {

        public Horse() {
            System.out.println("produce a horse");
        }

        public void show() {
            System.out.println("horse shows");
        }
    }

    static class Cattle implements Animal {

        public Cattle() {
            System.out.println("produce a cattle");
        }

        public void show() {
            System.out.println("cattle shows");
        }
    }

    interface Plant {
        void show();
    }

    static class Fruit implements Plant {

        public Fruit() {
            System.out.println("produce a fruit");
        }

        public void show() {
            System.out.println("fruit shows");
        }
    }

    static class Vegetables implements Plant {

        public Vegetables() {
            System.out.println("produce vegetables");
        }

        public void show() {
            System.out.println("vegetables shows");
        }
    }

    interface Farm {
        Animal produceAnimal();
        Plant producePlant();
    }

    static class SGfarm implements Farm {
        public Animal produceAnimal() {
            System.out.println("produce cattle in sg farm");
            return new Cattle();
        }

        public Plant producePlant() {
            System.out.println("produce vegetables in sg farm");
            return new Vegetables();
        }
    }

    static class SRfarm implements Farm {
        public Animal produceAnimal() {
            System.out.println("produce horse in sr farm");
            return new Horse();
        }

        public Plant producePlant() {
            System.out.println("produce fruit in sr farm");
            return new Fruit();
        }
    }
}
