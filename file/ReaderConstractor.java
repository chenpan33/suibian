package day02ZiFuliu.heima;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderConstractor {
    public static void main(String[] args) throws IOException {
        //方式一
        File file = new File("a.txt");
        FileReader fileReader=new FileReader(file);
       //方式二
        // FileReader fileReader=new FileReader("b.txt");

    }
}
