import java.util.Scanner;

public class Arrayratanilai30 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;
        do {
            System.out.print("Masukkan banyaknya mahasiswa: ");
            n = input.nextInt();
            if (n <= 0) {
                System.out.println("Jumlah harus lebih dari 0.");
            }
        } while (n <= 0);

        int[] nilaiMhs = new int[n]; 
        int total = 0;
        double rata2;
        int jumlahLulus = 0;

        for (int i = 0; i < nilaiMhs.length; i++) {
            System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + ": ");
            nilaiMhs[i] = input.nextInt();
            total += nilaiMhs[i];

            if (nilaiMhs[i] > 70) {
                jumlahLulus++;
            }
        }

        rata2 = (double) total / nilaiMhs.length;
        System.out.println();
        System.out.println("Total nilai: " + total);
        System.out.println("Rata-rata: " + rata2);

        int tertinggi = nilaiMhs[0];
        int terendah = nilaiMhs[0];
        for (int i = 1; i < nilaiMhs.length; i++) {
            if (nilaiMhs[i] > tertinggi) tertinggi = nilaiMhs[i];
            if (nilaiMhs[i] < terendah) terendah = nilaiMhs[i];
        }
        System.out.println("Nilai tertinggi: " + tertinggi);
        System.out.println("Nilai terendah: " + terendah);

        String predikat;
        if (rata2 >= 85) {
            predikat = "SANGAT BAIK";
        } else if (rata2 >= 70) {
            predikat = "BAIK";
        } else {
            predikat = "PERLU PENDAMPINGAN";
        }
        System.out.println("Predikat kelas: " + predikat);
        System.out.println("Jumlah mahasiswa lulus: " + jumlahLulus);

        input.close();
    }
}