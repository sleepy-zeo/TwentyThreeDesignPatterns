package com.lullaby.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 享元模式
 *
 * 瓶盖的颜色是固定的几类，但是二维码信息是不同的
 */
public class StructureFlyWeightPattern {

    public static void main(String[] args) {

        BottleCap bottleCap1 = BottleFlyWeightFactory.getBottleCap("蓝色");
        BottleCap bottleCap2 = BottleFlyWeightFactory.getBottleCap("蓝色");

        // 享元成员
        System.out.println("zkh1" + bottleCap1 + "");
        System.out.println("zkh2" + bottleCap2 + "");

        // 这里是对象有差异的元素
        System.out.println("获奖结果" + bottleCap1.getQrContent(new QRContent()));
        System.out.println("获奖结果" + bottleCap2.getQrContent(new QRContent()));
    }

    static class BottleFlyWeightFactory {
        //享元池
        private static final Map<String, BottleCap> map = new HashMap<>();

        public static BottleCap getBottleCap(String color) {
            if (map.get(color) != null) {
                return map.get(color);
            } else {
                BottleCap cfw = new ConcreteBottleCap(color);
                map.put(color, cfw);
                return cfw;
            }
        }
    }

    interface BottleCap {

        String getColor();

        String getQrContent(QRContent qrContent);
    }

    static class ConcreteBottleCap implements BottleCap {

        private final String color;

        public ConcreteBottleCap(String color) {
            this.color = color;
        }

        @Override
        public String getColor() {
            return color;
        }

        @Override
        public String getQrContent(QRContent qrContent) {
            return "瓶盖颜色：" + this.color + "\n" + "二维码内容:" + qrContent.getQrContent();
        }
    }

    // 一般对象
    static class QRContent {

        private String qrContent;
        private String uuid;

        public QRContent() {
            uuid = String.valueOf(UUID.randomUUID());
        }

        public String getQrContent() {
            qrContent = "二维码唯一ID：" + uuid + "\n" + "根据ID得到中奖信息：" + (new Random().nextInt(6) + 1) + "等奖";
            return qrContent;
        }

        public void setQrContent(String qrContent) {
            this.qrContent = qrContent;
        }
    }
}
