package com.lullaby.pattern;

/**
 * 过滤器链模式
 */
public class StructureFilterPattern {

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new EggFilter());
        filterChain.addFilter(new AobingFilter());
        filterChain.addFilter(new BaicaiFilter());
        filterChain.addFilter(new JitouFilter());

        System.out.println("--- filter chain running ---");
        try {
            filterChain.doFilter("CvMax");
        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
        System.out.println("--- filter chain finished ---");

    }

    interface Filter {
        void doFilter(String data, FilterChain chain);
    }

    static class FilterChain {
        private Filter[] filters;
        private int index;
        private int capacity;

        private int position;

        public FilterChain() {
            capacity = 2;
            filters = new Filter[capacity];
            index = 0;

            position = 0;
        }

        public void addFilter(Filter filter) {
            filters[index++] = filter;
            if (index >= capacity) {
                capacity *= 2;
                Filter[] destFilters = new Filter[capacity];
                System.arraycopy(filters, 0, destFilters, 0, index);
                filters = destFilters;
            }
        }

        public void doFilter(String data) {
            if (position < index) {
                filters[position++].doFilter(data, this);
            }

        }
    }

    static class EggFilter implements Filter {
        @Override
        public void doFilter(String data, FilterChain chain) {
            System.out.println("EggFilter before doFilter data: " + data);
            chain.doFilter(data);
            System.out.println("EggFilter after doFilter data: " + data);

        }
    }

    static class AobingFilter implements Filter {
        @Override
        public void doFilter(String data, FilterChain chain) {
            System.out.println("AobingFilter before doFilter data: " + data);
            chain.doFilter(data);
            System.out.println("AobingFilter after doFilter data: " + data);
        }
    }

    static class BaicaiFilter implements Filter {
        @Override
        public void doFilter(String data, FilterChain chain) {
            System.out.println("BaicaiFilter before doFilter data: " + data);
            if (data.equals("CvMax")){
                throw new RuntimeException("data not valid");
            }
            chain.doFilter(data);
            System.out.println("BaicaiFilter after doFilter data: " + data);
        }
    }

    static class JitouFilter implements Filter {
        @Override
        public void doFilter(String data, FilterChain chain) {
            System.out.println("JitouFilter before doFilter data: " + data);
            chain.doFilter(data);
            System.out.println("JitouFilter after doFilter data: " + data);
        }
    }
}
