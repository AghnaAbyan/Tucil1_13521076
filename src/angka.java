import java.io.*;
import java.util.*;

import javax.xml.transform.Source;

public class angka {
    ArrayList<Integer> fournumbers;
    Scanner input = new Scanner(System.in);
    
    public angka(){
        this.fournumbers = new ArrayList<>();
    }
    public angka(int ops){
        this.fournumbers = new ArrayList<>();
        String[] ListElmtNum = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        
        if (ops == 1){
            this.fournumbers = this.randomacak();
        }
        else if (ops == 2){
            while (fournumbers.size() < 4){
                String inputangka = input.next();
                for (String i : ListElmtNum)
                {
                    if (inputangka.equals(i))
                    {
                        switch (inputangka){
                            case "A":
                                fournumbers.add(1);
                                break;
                            case "2":
                                fournumbers.add(2);
                                break;
                            case "3":
                                fournumbers.add(3);
                                break;
                            case "4":
                                fournumbers.add(4);
                                break;
                            case "5":
                                fournumbers.add(5);
                                break;
                            case "6":
                                fournumbers.add(6);
                                break;
                            case "7":
                                fournumbers.add(7);
                                break;
                            case "8":
                                fournumbers.add(8);
                                break;
                            case "9":
                                fournumbers.add(9);
                                break;
                            case "10":
                                fournumbers.add(10);
                                break;
                            case "J":
                                fournumbers.add(11);
                                break;
                            case "Q":
                                fournumbers.add(12);
                                break;
                            case "K":
                                fournumbers.add(13);
                                break;
                        }
                    }
                }
            }
        }
    System.out.println(fournumbers);
    }

    ArrayList<String> array2list(String[] lists){
        ArrayList<String> hasil = new ArrayList<String>(lists.length);
        for(String x : lists){
            hasil.add(x);
        }
        return hasil;
    }

    ArrayList<Integer> randomacak(){
        String[] ListElmtNum = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        ArrayList<String> list = array2list(ListElmtNum);
        ArrayList<Integer> hasil = new ArrayList<Integer>();
        Random acak = new Random();

        while (hasil.size() < 4){
            int pengacakan = acak.nextInt(list.size());
            String inputangka = list.get(pengacakan);
            switch (inputangka){
                case "A":
                    hasil.add(1);
                    break;
                case "2":
                    hasil.add(2);
                    break;
                case "3":
                    hasil.add(3);
                    break;
                case "4":
                    hasil.add(4);
                    break;
                case "5":
                    hasil.add(5);
                    break;
                case "6":
                    hasil.add(6);
                    break;
                case "7":
                    hasil.add(7);
                    break;
                case "8":
                    hasil.add(8);
                    break;
                case "9":
                    hasil.add(9);
                    break;
                case "10":
                    hasil.add(10);
                    break;
                case "J":
                    hasil.add(11);
                    break;
                case "Q":
                    hasil.add(12);
                    break;
                case "K":
                    hasil.add(13);
                    break;
            }
            list.remove(pengacakan);
        }
    return hasil;
    }
}

