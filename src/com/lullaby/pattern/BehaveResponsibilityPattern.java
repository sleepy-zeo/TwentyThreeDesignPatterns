package com.lullaby.pattern;

import java.util.Arrays;

/**
 * 责任链模式
 *
 * 创建一个链条，数据经过链条的每个环节依次加工处理，环节彼此解耦
 */
public class BehaveResponsibilityPattern {

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new EggFilter());
        filterChain.addFilter(new BaicaiFilter());
        filterChain.addFilter(new AobingFilter());
        filterChain.addFilter(new JitouFilter());

        filterChain.processing("CVMAX");

    }

    interface Filter {
        void doFilter(String data);
    }

    static class FilterChain {
        private Filter[] filters;
        private int index;
        private int capacity;

        public FilterChain() {
            capacity = 2;
            filters = new Filter[capacity];
            index = 0;

        }

        public void addFilter(Filter filter) {
            filters[index++] = filter;
            System.out.println("filter address: " + filter);
            if (index >= capacity) {
                capacity *= 2;
                Filter[] destFilters = new Filter[capacity];
                System.arraycopy(filters, 0, destFilters, 0, index);
                filters = destFilters;

                System.out.println("-->" + Arrays.toString(filters));
            }
        }

        public void processing(String data) {
            for (int i = 0; i < index; ++i) {
                filters[i].doFilter(data);
            }
        }
    }

    static class EggFilter implements Filter {
        @Override
        public void doFilter(String data) {
            System.out.println("EggFilter doFilter data: " + data);
        }
    }

    static class AobingFilter implements Filter {
        @Override
        public void doFilter(String data) {
            System.out.println("AobingFilter doFilter data: " + data);

        }
    }

    static class BaicaiFilter implements Filter {
        @Override
        public void doFilter(String data) {
            System.out.println("BaicaiFilter doFilter data: " + data);

        }
    }

    static class JitouFilter implements Filter {
        @Override
        public void doFilter(String data) {
            System.out.println("JitouFilter doFilter data: " + data);

        }
    }
}
