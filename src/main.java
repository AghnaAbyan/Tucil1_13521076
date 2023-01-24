import java.io.*;
import java.util.*;

public class main{
    public static List<String> randomList(){
        List<String> arrayCard = new ArrayList<>();
        arrayCard.add("A");arrayCard.add("2");arrayCard.add("3");arrayCard.add("4");
        arrayCard.add("5");arrayCard.add("6");arrayCard.add("7");arrayCard.add("8");
        arrayCard.add("9");arrayCard.add("10");arrayCard.add("J");arrayCard.add("Q");
        arrayCard.add("K");
        Collections.shuffle(arrayCard);
        return arrayCard.subList(0, 4);
    }

    public static void createFile(String filename, List<String> list){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for (String s: list){
                bw.write(s);
                bw.newLine();
            }
            System.out.println("File created and write succesfully");
            bw.close();
        }
        catch (IOException e){
            System.out.println("An Error Has Occured");
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner masukan = new Scanner(System.in);
        String kartu;

        List<String> card_input = new ArrayList<String>();
        boolean valid;
        int inputuser = 0, n = 0;
        while(inputuser != 1 && inputuser != 2) {
            System.out.println("Pilih masukkan yang diinginkan: ");
            System.out.println("1. Random");
            System.out.println("2. Keyboard Sendiri");
            

            inputuser = input.nextInt();
            if (inputuser == 1){
                card_input = randomList();
            }
            else if (inputuser == 2){
            System.out.println("Masukkan 4 angka/huruf (A,2,3,4,5,6,7,8,9,10,J,Q,K)");
            while (n < 4){
                valid = false;
                while (!valid){
                    kartu = masukan.nextLine();
                    if (card.convertCardToInt(kartu) == 0){
                        System.out.println("Masukan Tidak Sesuai");
                        }
                    else{
                        card_input.add(kartu);
                        valid = true;
                        n++;
                        }
                    }
                }
            }
        }
        String[] cards = (String[]) card_input.toArray(new String[0]);
        DuaPuluhEmpat game = new DuaPuluhEmpat();

        long startTime = System.currentTimeMillis();
        List<String> hasil = game.solusi(cards);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        String nama_file;

        System.out.println("Apakah ingin menyimpan solusi? (Y/N)");
        char final2 = masukan.next().charAt(0);
        while(final2 != ('Y') && final2 !=('N')){
            if (final2 == ('Y')){
                break;
            }
            else if (final2 == ('N')){
                break;
            }
            System.out.println("Apakah ingin menyimpan solusi? (Y/N)");
            final2 = masukan.next().charAt(0);
        }
        Scanner nama = new Scanner(System.in);
        if (final2 == 'Y'){
            System.out.println("Masukkan Nama File:");
            nama_file = nama.nextLine();
            nama_file = nama_file + ".txt";
            createFile(nama_file, hasil);
        }

        System.out.println("Execution time: " + totalTime + " ms");
        input.close();
        masukan.close();
        nama.close();
    }
}