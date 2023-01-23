import java.io.*;
import java.util.*;

import javax.xml.transform.Source;

public class main{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        angka numerik = new angka();
        int inputuser = 0;
        while(inputuser != 1 && inputuser != 2) {
            System.out.println("Pilih masukkan yang diinginkan: ");
            System.out.println("1. Random");
            System.out.println("2. Keyboard Sendiri");
            
            inputuser = input.nextInt();
            if (inputuser == 1){
                numerik = new angka(1);
            }
            else if (inputuser == 2){
                numerik = new angka(2);
            }
        }
    input.close();
    }
}