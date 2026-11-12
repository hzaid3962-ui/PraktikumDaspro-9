import java.util.Scanner;
public class Tugas2Kafe30 {

    static int cariMenu(String[] menu, String namaDicari) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].equalsIgnoreCase(namaDicari)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] menu = {"Nasi Goreng", "Mie Goreng", "Roti Bakar", "Kentang Goreng",
                         "Teh Tarik", "Cappucino", "Chocolate Ice"};
        int[] harga = {15000, 13000, 10000, 12000, 8000, 18000, 20000};

        System.out.println("=== DAFTAR MENU KAFE KAMPUS ===");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %-16s Rp %,d%n", (i + 1), menu[i], harga[i]);
        }

        System.out.println();
        System.out.print("Cari menu (ketik nama menu): ");
        String keyCari = input.nextLine();
        int hasil = cariMenu(menu, keyCari.trim());
        if (hasil != -1) {
            System.out.println("Menu ditemukan: " + menu[hasil] + " - Rp " + String.format("%,d", harga[hasil]));
        } else {
            System.out.println("Menu \"" + keyCari + "\" tidak tersedia.");
        }

        System.out.println();
        int jumlah;
        do {
            System.out.print("Jumlah item yang ingin dipesan: ");
            jumlah = input.nextInt();
            if (jumlah <= 0) {
                System.out.println("Jumlah harus lebih dari 0.");
            }
        } while (jumlah <= 0);
        input.nextLine();

        String[] pesanan = new String[jumlah]; 
        int[] hargaPesanan = new int[jumlah];
        int total = 0;

        for (int i = 0; i < jumlah; i++) {
            int idx;
            do {
                System.out.print("Pesanan ke-" + (i + 1) + " (nama menu): ");
                String nama = input.nextLine().trim();
                idx = cariMenu(menu, nama); 
                if (idx == -1) {
                    System.out.println("Menu tidak tersedia, silakan input ulang.");
                }
            } while (idx == -1);

            pesanan[i] = menu[idx];
            hargaPesanan[i] = harga[idx];
            total += harga[idx];
        }

        System.out.println();
        System.out.println("====================");
        System.out.println("  DAFTAR PESANAN    ");
        System.out.println("====================");
        for (int i = 0; i < jumlah; i++) {
            System.out.printf("%d. %-16s Rp %,10d%n", (i + 1), pesanan[i], hargaPesanan[i]);
        }
        System.out.println("----------------------------------");
        System.out.printf("%-19s Rp %,10d%n", "TOTAL BIAYA", total);
        System.out.println("==================================");

        input.close();
    }
}