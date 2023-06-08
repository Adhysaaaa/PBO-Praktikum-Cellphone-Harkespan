package implementasi.phone;
import java.util.List;
import java.util.Scanner;

public class CellphoneMain {
    public static void main(String[] args){
        Cellphone cp = new Cellphone("Nokia", "3310");
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Lihat Semua Kontak");
            System.out.println("3. Cari Kontak berdasarkan Nama");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan \n dari input sebelumnya
            
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama kontak: ");
                    String namaKontak = scanner.nextLine();
                    System.out.print("Masukkan nomor kontak: ");
                    String nomorKontak = scanner.nextLine();
                    cp.tambahContact(namaKontak, nomorKontak);
                    System.out.print("Top Up Pulsa: ");
                    int pulsaKontak = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan \n dari input sebelumnya
                    cp.topUpPulsa(pulsaKontak);
                    cp.checkPulsa();
                    break;
                    
                case 2:
                    cp.tampilContacts();
                    break;
                case 3:
                    System.out.print("Masukkan nama yang ingin dicari: ");
                    String searchName = scanner.nextLine();
                    System.out.println("Mencari kontak dengan nama: " + searchName);
                    List<Contact> foundContacts = cp.searchContactByName(searchName);
                    if (foundContacts.isEmpty()) {
                        System.out.println("Kontak tidak ditemukan.");
                    } else {
                        System.out.println("Kontak yang ditemukan:");
                        for (Contact contact : foundContacts) {
                            System.out.println("Nama: " + contact.getNama());
                            System.out.println("Nomor: " + contact.getNomor());
                            System.out.println("--------------------");
                        }
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih angka yang sesuai dengan menu.");
            }
        }
        
        // Menutup scanner
        scanner.close();
    }
}
