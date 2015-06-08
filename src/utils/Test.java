package utils;

/**
 * Created by Макс on 03.06.2015.
 */
public class Test {

    public static void main(String[] args) {

//        CopyFile copyFile = new CopyFile();
//        copyFile.copy("D:\\Games\\cheat.zip", "D:\\Games\\cheat2.zip");

        FindFile findFile = new FindFile();

        for (String resFile:findFile.find("D:\\Games\\", "big")){
            System.out.println(resFile);
        }

        System.out.println("******************************************");

        for (String resFile2:findFile.find("D:\\Games\\", "", "tgx")){
            System.out.println(resFile2);
        }

    }
}
