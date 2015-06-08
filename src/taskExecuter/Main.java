package taskExecuter;

import realize.*;
import utils.CopyFile;
import utils.FindFile;

/**
 * Created by Макс on 03.06.2015.
 */
public class Main {

    public static void main(String[] args) {

        FindFile findFile = new FindFile();
        CopyFile copyFile = new CopyFile();

        MyTask task1 = new MyFindFilesTask(findFile, "D:\\Games\\", "big");
        MyTask task2 = new MyFindFilesTask(findFile, "D:\\", "game");
        MyTask task3 = new MyFindFilesTask(findFile, "D:\\", "", "doc");
        MyTask task4 = new MyCopyFileTask(copyFile,  "D:\\Games\\cheat.zip", "D:\\Games\\cheat2.zip");
        MyTask task5 = new MyCopyFileTask(copyFile,  "D:\\Games\\Stronghold.iso.EX.UA.torrent", "D:\\Games\\Stronghold.iso2.torrent");
        MyTask task6 = new MyFindFilesTask(findFile, "D:\\", "D:\\Games\\Myfile.txt");

        MyTaskStorage myTaskStorage = new MyTaskStorage();
        myTaskStorage.add(task1);
        myTaskStorage.add(task2);
        myTaskStorage.add(task3);
        myTaskStorage.add(task4);
        myTaskStorage.add(task5);
        myTaskStorage.add(task6);

        MyTaskExecutor myTaskExecutor1 = new MyTaskExecutor(myTaskStorage);
        MyTaskExecutor myTaskExecutor2 = new MyTaskExecutor(myTaskStorage);
        MyTaskExecutor myTaskExecutor3 = new MyTaskExecutor(myTaskStorage);

        myTaskExecutor1.start();
        myTaskExecutor2.start();
        myTaskExecutor3.start();

    }
}
