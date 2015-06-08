package utils;

import realize.MyCopyFileTask;
import realize.MyTask;

import java.io.FileFilter;

/**
 * Created by Макс on 03.06.2015.
 */
public class Test {

    public static void main(String[] args) {

        CopyFile copyFile = new CopyFile();

        MyTask task5 = new MyCopyFileTask(copyFile, "D:\\Games\\Stronghold.iso.EX.UA.torrent", "D:\\Games\\Stronghold.iso2.torrent");

//        FindFile findFile = new FindFile();
//
//        for (String resFile:findFile.find("D:\\Games\\", "big")){
//            System.out.println(resFile);
//        }
//
//        System.out.println("******************************************");
//
//        for (String resFile:findFile.find("D:\\", "", "raw")){
//            System.out.println(resFile);
//        }
//    }
    }
}
