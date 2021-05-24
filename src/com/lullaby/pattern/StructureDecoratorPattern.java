package com.lullaby.pattern;

/**
 * 装饰模式
 *
 * 简单来说就是在原有的基础上增加一些东西，装饰器是多层次的，因此检查起来很复杂
 */
public class StructureDecoratorPattern {

    public static void main(String[] args) {
        Component component;
        component = new ConcreteComponent();
        //第一次修饰
        component = new DecoratorOne(component);
        //第二次修饰
        component = new DecoratorTwo(component);
        //修饰后运行
        component.operate();
    }

    interface Component {
        void operate();
    }

    static class ConcreteComponent implements Component {

        @Override
        public void operate() {
            System.out.println("concrete operate");
        }
    }

    static abstract class Decorator implements Component {

        private final Component component;

        //通过构造函数传递给被修饰者
        public Decorator(Component component) {
            this.component = component;
        }

        //委托给被修饰者执行
        @Override
        public void operate() {
            if (component != null) {
                this.component.operate();
            }
        }
    }

    static class DecoratorOne extends Decorator {

        public DecoratorOne(Component component) {
            super(component);
        }

        private void decorate() {
            System.out.println("DecoratorOne method decorates");
        }

        @Override
        public void operate() {
            this.decorate();
            super.operate();
        }

    }

    static class DecoratorTwo extends Decorator {

        public DecoratorTwo(Component component) {
            super(component);
        }

        private void decorate() {
            System.out.println("DecoratorTwo method decorates");
        }

        @Override
        public void operate() {
            this.decorate();
            super.operate();
        }

    }
}
