package com.lullaby.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 *
 * 当对象的状态发生改变的时候，所有观察该对象的观察者都会收到通知
 */
public class ObserverPattern {

    public static void main(String[] args) {

        Company importCompany = new ImportCompany();
        Company exportCompany = new ExportCompany();
        Rate rmbRate = new RmbRate();
        rmbRate.register(importCompany);
        rmbRate.register(exportCompany);
        rmbRate.change(-12);
    }

    static abstract class Rate {
        protected List<Company> companyList = new ArrayList<Company>();

        public void register(Company company) {
            companyList.add(company);
        }

        public void deregister(Company company) {
            companyList.remove(company);
        }

        public abstract void change(int number);
    }

    static class RmbRate extends Rate {
        public void change(int number) {
            for (Company obs : companyList) {
                obs.onRateChanged(number);
            }
        }
    }

    interface Company {
        void onRateChanged(int number);
    }

    static class ImportCompany implements Company {
        public void onRateChanged(int number) {
            if (number > 0) {
                System.out.println("ImportCompany 人民币汇率升值" + number + "个基点，降低了进口产品成本，提升了进口公司利润率。");
            } else if (number < 0) {
                System.out.println("ImportCompany 人民币汇率贬值" + (-number) + "个基点，提升了进口产品成本，降低了进口公司利润率。");
            }
        }
    }

    static class ExportCompany implements Company {
        public void onRateChanged(int number) {
            if (number > 0) {
                System.out.println("ExportCompany 人民币汇率升值" + number + "个基点，降低了出口产品收入，降低了出口公司的销售利润率。");
            } else if (number < 0) {
                System.out.println("ExportCompany 人民币汇率贬值" + (-number) + "个基点，提升了出口产品收入，提升了出口公司的销售利润率。");
            }
        }
    }
}
