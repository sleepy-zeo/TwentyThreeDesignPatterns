package com.lullaby.pattern;

/**
 * 代理模式
 *
 * 通过代理来简介访问对象，代理实际上会在目标代码前后增加一些逻辑
 */
public class StructureProxyPattern {

    public static void main(String[] args) {

        Subject subject = new Proxy();
        subject.request();
    }

    interface Subject {
        void request();
    }

    static class RealSubject implements Subject {
        public void request() {
            System.out.println("访问真实主题方法");
        }
    }

    static class Proxy implements Subject {

        private RealSubject realSubject;

        public void request() {
            if (realSubject == null) {
                realSubject = new RealSubject();
            }
            preRequest();
            realSubject.request();
            postRequest();
        }

        public void preRequest() {
            System.out.println("访问真实主题之前的预处理");
        }

        public void postRequest() {
            System.out.println("访问真实主题之后的后续处理");
        }
    }
}
