//package com.app.fxplayer.modelgenerator;
//
//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.concurrent.Task;
//
//import java.io.File;
//
//public class CollectorManager  {
//    private static final File[] drives = {new File("C://"),new File("D://")};
//    private static Collector collector = new Collector(drives[0]);
//    public Collector init()  {
//        for (File f : drives)
//        {
//            collector = new Collector(f);
//            new Thread(collector).start();
//        }
//        return null;
//    }
//
//    public static Collector getCollector() {
//        return collector;
//    }
//}
