package com.lullaby.pattern;

/**
 * 外观模式✔
 *
 * 例子:
 * 1. 去医院看病需要挂号-门诊-划价-取药，让家属觉得很复杂，如果提供了接待人员，只让接待人员来处理，就很方便
 * 2. 电脑提供了一键开关机，如果没有这个统一的开关接口，我们就需要去一个一个硬件的去操作
 */
public class StructureFacadePattern {

    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.turnOn();

        System.out.println("-----");

        facade.turnOff();
    }

    static class CPU {
        public void turnOn() {
            System.out.println("CPU-On");
        }

        public void turnOff() {
            System.out.println("CPU-Off");
        }
    }

    static class GPU {
        public void turnOn() {
            System.out.println("GPU-On");
        }

        public void turnOff() {
            System.out.println("GPU-Off");
        }
    }

    static class Memory {
        public void turnOn() {
            System.out.println("Memory-On");
        }

        public void turnOff() {
            System.out.println("Memory-Off");
        }
    }

    static class Disk {
        public void turnOn() {
            System.out.println("Disk-On");
        }

        public void turnOff() {
            System.out.println("Disk-Off");
        }
    }

    static class Facade {
        private CPU cpu;
        private GPU gpu;
        private Memory memory;
        private Disk disk;

        public Facade() {
            this.cpu = new CPU();
            this.gpu = new GPU();
            this.memory = new Memory();
            this.disk = new Disk();
        }

        public void turnOn() {
            this.cpu.turnOn();
            this.gpu.turnOn();
            this.memory.turnOn();
            this.disk.turnOn();

        }

        public void turnOff() {
            this.cpu.turnOff();
            this.gpu.turnOff();
            this.memory.turnOff();
            this.disk.turnOff();
        }
    }
}
