package com.lullaby.pattern;

/**
 * 单例模式
 */
public class CreateSingletonPattern {

    public static void main(String[] args) {

        ScnSingletonPattern singletonPattern = ScnSingletonPattern.getInstance();
        singletonPattern.print();
    }

    static class ScnSingletonPattern {

        private static final ScnSingletonPattern instance = new ScnSingletonPattern();

        private ScnSingletonPattern() {
        }

        public static ScnSingletonPattern getInstance() {
            return instance;
        }

        public void print() {
            System.out.println("This is SingletonPattern");
        }
    }
}
