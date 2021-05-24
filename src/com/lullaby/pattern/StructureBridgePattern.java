package com.lullaby.pattern;

/**
 * 桥接模式
 *
 * 用性要求较高的场景，比如有多种类型数据库，每个数据库也可以配置不同的driver
 */
public class StructureBridgePattern {

    public static void main(String[] args) {

        Database mysql = new Mysql(new JdbcDriver());
        mysql.accessDb();

        Database mysql2 = new Mysql(new DruidDriver());
        mysql2.accessDb();

    }

    interface Driver {
        void doSomething();
    }

    static class JdbcDriver implements Driver {
        @Override
        public void doSomething() {
            System.out.println("use jdbc to operate db");
        }
    }

    static class DruidDriver implements Driver {
        @Override
        public void doSomething() {
            System.out.println("use druid to operate db");
        }
    }

    public static abstract class Database {
        private final Driver driver;

        public Database(Driver driver) {
            this.driver = driver;
        }

        public Driver getDriver() {
            return driver;
        }

        public abstract void accessDb();
    }

    static class Mysql extends Database {

        public Mysql(Driver driver) {
            super(driver);
        }

        @Override
        public void accessDb() {
            System.out.println("access mysql");
            getDriver().doSomething();
        }
    }

}
