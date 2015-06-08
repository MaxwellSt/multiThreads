package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Макс on 03.06.2015.
 */
public class FindFile {

    private List<String> resultArray = new ArrayList<String>();

    public String[] find(String pathToDir, String searchWord) {

        File dir = new File(pathToDir);
        File[] listFiles = dir.listFiles();

        if (listFiles == null)
           return null;

        for (File iter : listFiles) {
            privateFind(pathToDir + "\\" + iter.getName(), searchWord);
        }

        String[] result = new String[resultArray.size()];
        int i = 0;
        for (String resFile:resultArray){
            result[i] = resFile;
            i += 1;
        }
        return result;
    }

    private void privateFind(String pathName, String searchWord) {

        File dir = new File(pathName);

        if (dir.getName().toLowerCase().indexOf(searchWord.toLowerCase()) > -1)
            this.resultArray.add(pathName);

        if (dir.isDirectory()) {
            File[] listFiles = dir.listFiles();

            if (listFiles == null)
                return;
            for (File iter : listFiles) {
                privateFind(pathName + "\\" + iter.getName(), searchWord);
            }
        }
    }
}
