package com.lullaby.pattern;

/**
 * 状态模式
 *
 * 我要做一件事，这件事能导致什么后果我不管，由当前状态来决定
 *
 * Context: 含有不同状态的对象
 * State: 状态接口，规定了状态的行为
 * XxxState: State实现类，Context有多少状态就有多少实现类
 */
public class BehaveStatePattern {

    public static void main(String[] args) {

        Context context = new Context();
        context.setCurrentState(new LoginState());
        context.delGoods();
        context.payGoods();

        System.out.println("---");
        context.setCurrentState(new LogoutState());
        context.delGoods();
        context.payGoods();
    }

    interface State {
        void delGoods();

        void payGoods();
    }

    static class Context {

        private State currentState;

        public void setCurrentState(State currentState) {
            this.currentState = currentState;
        }

        public void delGoods() {
            if (currentState != null) {
                currentState.delGoods();
            }
        }

        public void payGoods() {
            if (currentState != null) {
                currentState.payGoods();
            }
        }
    }

    static class LogoutState implements State {

        @Override
        public void delGoods() {
            System.out.println("跳转到登录页");

        }

        @Override
        public void payGoods() {
            System.out.println("跳转到登录页");
        }
    }

    static class LoginState implements State {

        @Override
        public void delGoods() {
            System.out.println("已删除指定商品");
        }

        @Override
        public void payGoods() {
            System.out.println("已完成付款");
        }
    }
}
