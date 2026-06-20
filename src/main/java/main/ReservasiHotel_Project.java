/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

/**
 *
 * @author ikhramfahrezi
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.Kamar;

public class ReservasiHotel_Project {
    static ArrayList<Kamar> dataKamar = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    static final String FILE_NAME =
        "data/data_hotel_241011402337.txt";

    public static void main(String[] args) {
        muatData(); 
        
        int pilihan = -1;
        do {
            System.out.println("\n=========================================");
            System.out.println("   SISTEM RESERVASI KAMAR HOTEL       ");
            System.out.println("=========================================");
            System.out.println("1. Tambah Data Reservasi");
            System.out.println("2. Tampil Data Reservasi");
            System.out.println("3. Ubah Data Reservasi");
            System.out.println("4. Hapus Data Reservasi");
            System.out.println("5. Cari Data Reservasi");
            System.out.println("6. Simpan Data ke File");
            System.out.println("0. Keluar Aplikasi");
            System.out.print("Pilih menu (0-6): ");
            
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
                switch (pilihan) {
                    case 1: tambahData(); break;
                    case 2: tampilData(); break;
                    case 3: ubahData(); break;
                    case 4: hapusData(); break;
                    case 5: cariData(); break;
                    case 6: simpanData(); break;
                    case 0: 
                        System.out.println("Menyimpan data dan keluar dari program. Terima kasih!");
                        simpanData();
                        break;
                    default:
                        System.out.println("Error: Menu tidak tersedia! Silakan ketik angka 0 sampai 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Input tidak valid! Masukkan ANGKA (0-6), bukan huruf atau simbol.");
            }
        } while (pilihan != 0);
    }

    static void tambahData() {
        System.out.println("\n--- Tambah Data Reservasi ---");
        System.out.print("No Kamar      : ");
        String no = scanner.nextLine();
        
        if (cariIndeks(no) != -1) {
            System.out.println("Error: Nomor kamar '" + no + "' sudah ada di sistem! Gunakan nomor lain.");
            return;
        }

        String tipe = "";
        boolean tipeValid = false;
        while (!tipeValid) {
            System.out.println("Pilihan Tipe Kamar: [Standard, Superior, Deluxe, Suite]");
            System.out.print("Tipe Kamar    : ");
            tipe = scanner.nextLine();
            if (tipe.equalsIgnoreCase("Standard") || tipe.equalsIgnoreCase("Superior") || 
                tipe.equalsIgnoreCase("Deluxe") || tipe.equalsIgnoreCase("Suite")) {
                tipeValid = true;
            } else {
                System.out.println("Error: Tipe kamar '" + tipe + "' tidak valid! Silakan ketik sesuai pilihan di atas.");
            }
        }

        System.out.print("Nama Tamu     : ");
        String nama = scanner.nextLine();
        if (nama.trim().isEmpty()) {
            nama = "Tanpa Nama"; // Jaga-jaga kalau user cuma tekan enter
        }
        
        int durasi = 0;
        boolean durasiValid = false;
        while (!durasiValid) {
            try {
                System.out.print("Durasi (Malam): ");
                durasi = Integer.parseInt(scanner.nextLine());
                if (durasi > 0) {
                    durasiValid = true;
                } else {
                    System.out.println("Error: Durasi menginap harus lebih dari 0 malam!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Durasi harus berupa ANGKA (contoh: 2), bukan huruf!");
            }
        }

        String status = "";
        boolean statusValid = false;
        while (!statusValid) {
            System.out.print("Status Kamar (Terisi/Kosong/Booking): ");
            status = scanner.nextLine();
            if (status.equalsIgnoreCase("Terisi") || status.equalsIgnoreCase("Kosong") || status.equalsIgnoreCase("Booking")) {
                statusValid = true;
            } else {
                System.out.println("Error: Status tidak valid! Wajib diisi 'Terisi', 'Kosong', atau 'Booking'.");
            }
        }

        dataKamar.add(new Kamar(no, tipe, nama, durasi, status));
        System.out.println(">>> Sukses: Data reservasi berhasil ditambahkan!");
    }

    static void tampilData() {
        System.out.println("\n--- Daftar Reservasi Kamar ---");
        if (dataKamar.isEmpty()) {
            System.out.println("Data masih kosong. Silakan tambah data terlebih dahulu.");
            return;
        }
        
        System.out.printf("%-10s | %-15s | %-20s | %-10s | %-10s\n", 
                "No Kamar", "Tipe Kamar", "Nama Tamu", "Durasi", "Status");
        System.out.println("-----------------------------------------------------------------------------");
        for (Kamar k : dataKamar) {
            System.out.printf("%-10s | %-15s | %-20s | %-10d | %-10s\n", 
                    k.getNoKamar(), k.getTipeKamar(), k.getNamaTamu(), k.getDurasiInap(), k.getStatus());
        }
    }

    static void ubahData() {
        System.out.println("\n--- Ubah Data Reservasi ---");
        System.out.print("Masukkan No Kamar yang ingin diubah: ");
        String no = scanner.nextLine();
        int indeks = cariIndeks(no);

        if (indeks != -1) {
            Kamar k = dataKamar.get(indeks);
            System.out.println("Data Ditemukan! Kosongkan (tekan Enter) jika tidak ingin mengubah data tertentu.");
            
            boolean tipeValid = false;
            while (!tipeValid) {
                System.out.println("Pilihan Tipe Kamar: [Standard, Superior, Deluxe, Suite]");
                System.out.print("Tipe Kamar baru [" + k.getTipeKamar() + "]: ");
                String tipe = scanner.nextLine();
                if (tipe.isEmpty()) {
                    tipeValid = true; 
                } else if (tipe.equalsIgnoreCase("Standard") || tipe.equalsIgnoreCase("Superior") || 
                           tipe.equalsIgnoreCase("Deluxe") || tipe.equalsIgnoreCase("Suite")) {
                    k.setTipeKamar(tipe);
                    tipeValid = true;
                } else {
                    System.out.println("Error: Tipe kamar tidak valid! Ketik sesuai pilihan atau biarkan kosong.");
                }
            }

            System.out.print("Nama Tamu baru [" + k.getNamaTamu() + "]: ");
            String nama = scanner.nextLine();
            if (!nama.trim().isEmpty()) k.setNamaTamu(nama);

            boolean durasiValid = false;
            while (!durasiValid) {
                System.out.print("Durasi baru [" + k.getDurasiInap() + "]: ");
                String durasiStr = scanner.nextLine();
                if (durasiStr.isEmpty()) {
                    durasiValid = true; 
                } else {
                    try {
                        int durasiBaru = Integer.parseInt(durasiStr);
                        if (durasiBaru > 0) {
                            k.setDurasiInap(durasiBaru);
                            durasiValid = true;
                        } else {
                            System.out.println("Error: Durasi harus lebih dari 0 malam!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Durasi harus berupa ANGKA!");
                    }
                }
            }

            boolean statusValid = false;
            while (!statusValid) {
                System.out.print("Status baru [" + k.getStatus() + "]: ");
                String status = scanner.nextLine();
                if (status.isEmpty()) {
                    statusValid = true; 
                } else if (status.equalsIgnoreCase("Terisi") || status.equalsIgnoreCase("Kosong") || status.equalsIgnoreCase("Booking")) {
                    k.setStatus(status);
                    statusValid = true;
                } else {
                    System.out.println("Error: Status wajib diisi 'Terisi', 'Kosong', atau 'Booking'!");
                }
            }

            System.out.println(">>> Sukses: Data berhasil diubah!");
        } else {
            System.out.println("Error: Data dengan No Kamar '" + no + "' tidak ditemukan.");
        }
    }

    static void hapusData() {
        System.out.println("\n--- Hapus Data Reservasi ---");
        System.out.print("Masukkan No Kamar yang ingin dihapus: ");
        String no = scanner.nextLine();
        int indeks = cariIndeks(no);

        if (indeks != -1) {
            dataKamar.remove(indeks);
            System.out.println(">>> Sukses: Data berhasil dihapus!");
        } else {
            System.out.println("Error: Data dengan No Kamar '" + no + "' tidak ditemukan.");
        }
    }

    static void cariData() {
        System.out.println("\n--- Cari Data Reservasi ---");
        System.out.print("Masukkan No Kamar atau Nama Tamu: ");
        String keyword = scanner.nextLine().toLowerCase();
        
        boolean ditemukan = false;
        System.out.printf("%-10s | %-15s | %-20s | %-10s | %-10s\n", 
                "No Kamar", "Tipe Kamar", "Nama Tamu", "Durasi", "Status");
        System.out.println("-----------------------------------------------------------------------------");
        
        for (Kamar k : dataKamar) {
            if (k.getNoKamar().toLowerCase().contains(keyword) || 
                k.getNamaTamu().toLowerCase().contains(keyword)) {
                System.out.printf("%-10s | %-15s | %-20s | %-10d | %-10s\n", 
                        k.getNoKamar(), k.getTipeKamar(), k.getNamaTamu(), k.getDurasiInap(), k.getStatus());
                ditemukan = true;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Pencarian gagal: Tidak ada data yang cocok dengan '" + keyword + "'.");
        }
    }

    static int cariIndeks(String noKamar) {
        for (int i = 0; i < dataKamar.size(); i++) {
            if (dataKamar.get(i).getNoKamar().equalsIgnoreCase(noKamar)) {
                return i;
            }
        }
        return -1;
    }

    static void simpanData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Kamar k : dataKamar) {
                pw.println(k.getNoKamar() + ";" + k.getTipeKamar() + ";" + 
                           k.getNamaTamu() + ";" + k.getDurasiInap() + ";" + k.getStatus());
            }
            System.out.println(">>> Sukses: Data berhasil disimpan ke " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error: Gagal menyimpan data! Detail: " + e.getMessage());
        }
    }

    static void muatData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Info: File data belum ada. Sistem akan membuat data baru.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 5) {
                    dataKamar.add(new Kamar(bagian[0], bagian[1], bagian[2], 
                                            Integer.parseInt(bagian[3]), bagian[4]));
                }
            }
            System.out.println(">>> Berhasil memuat data dari " + FILE_NAME);
        } catch (Exception e) {
            System.out.println("Error: Gagal memuat data! Detail: " + e.getMessage());
        }
    }
}
