package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public List<String> readFile(String path){
        List<String> fileList = new ArrayList<>();
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String d;
            while((d=br.readLine())!= null){
                fileList.add(d);
            }
            br.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return fileList;
    }
}
