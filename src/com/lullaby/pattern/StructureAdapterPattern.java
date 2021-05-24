package com.lullaby.pattern;

/**
 * 适配器模式
 *
 * 将类的接口转换成另一个接口，比如将220V转化为笔记本所需的12V
 */
public class StructureAdapterPattern {

    public static void main(String[] args) {

        TargetInterface adapter = new PowerAdapter(new Power());
        adapter.convertTo110V();
    }

    public interface TargetInterface {
        void convertTo110V();
    }

    static class Power {

        public void output220V() {
            System.out.println("output 220V");
        }
    }

    static class PowerAdapter implements TargetInterface {

        private final Power power;

        public PowerAdapter(Power power) {
            this.power = power;
        }

        @Override
        public void convertTo110V() {
            this.power.output220V();
            System.out.println("convert to 110V");
        }
    }

}
