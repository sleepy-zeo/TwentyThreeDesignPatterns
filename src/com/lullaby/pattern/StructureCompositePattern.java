package com.lullaby.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 *
 * 类似于电脑的文件夹，文件夹里有各类文件，还可以有子文件夹
 */
public class StructureCompositePattern {

    public static void main(String[] args) {

        File rootFile = new Folder("Root");

        // 在根目录下创建几个文件和文件夹
        rootFile.addFile(new NormalFile("README.md"));
        rootFile.addFile(new NormalFile(".gitignore"));
        rootFile.addFile(new NormalFile("build.gradle"));

        File homeFile = new Folder("app");
        homeFile.addFile(new NormalFile("Test.java"));

        rootFile.addFile(homeFile);

        rootFile.display();
    }

    interface File {
        void addFile(File file);
        void removeFile(File file);
        List<File> getFiles();
        void display();
    }

    static class Folder implements File {
        private String name;

        private List<File> fileList;

        public Folder(String name) {
            this.name = name;
            this.fileList = new ArrayList<>();
        }

        @Override
        public void addFile(File file) {
            this.fileList.add(file);
        }

        @Override
        public void removeFile(File file) {
            this.fileList.remove(file);
        }

        @Override
        public List<File> getFiles() {
            return fileList;
        }

        @Override
        public void display() {
            System.out.println(toString());
        }

        @Override
        public String toString() {
            return "Folder(" + name + ")[" +
                    "fileList=" + fileList +
                    ']';
        }
    }

    static class NormalFile implements File {

        private String name;

        public NormalFile(String name) {
            this.name = name;
        }

        @Override
        public void addFile(File file) {
            throw new UnsupportedOperationException("普通文件不支持");
        }

        @Override
        public void removeFile(File file) {
            throw new UnsupportedOperationException("普通文件不支持");
        }

        @Override
        public List<File> getFiles() {
            throw new UnsupportedOperationException("普通文件不支持");
        }

        @Override
        public void display() {

        }

        @Override
        public String toString() {
            return "NormalFile[" +
                    "name='" + name + '\'' +
                    ']';
        }
    }
}
