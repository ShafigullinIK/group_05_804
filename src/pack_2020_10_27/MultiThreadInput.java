package pack_2020_10_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiThreadInput extends Thread {

    BufferedReader reader;

    public MultiThreadInput(){
        reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
    }

    @Override
    public void run() {
        while(true) {
            try{
                String s = reader.readLine();
                System.out.println(s);
            } catch (IOException e){

            }
        }
    }
}
