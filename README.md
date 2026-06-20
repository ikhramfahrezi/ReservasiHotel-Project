# 🏨 Sistem Reservasi Kamar Hotel (Console Based)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans&logoColor=white)

Project akhir mata kuliah **Pemrograman 1**. Aplikasi ini adalah sistem *Create, Read, Update, Delete, Search* (CRUD) berbasis *console* untuk manajemen reservasi kamar hotel, dibangun menggunakan bahasa pemrograman Java dengan menerapkan prinsip Object-Oriented Programming (OOP).

## 🚀 Fitur Utama
Aplikasi ini sudah memenuhi spesifikasi teknis wajib, meliputi:
- **OOP & Encapsulation:** Menerapkan *class*, *private attributes*, serta *getter & setter*.
- **Collection:** Menggunakan `ArrayList` untuk menyimpan dan mengelola banyak data secara dinamis di memori.
- **CRUD Operations:** Fitur Tambah, Tampil, Ubah, Hapus, dan Cari data reservasi berjalan dengan baik menggunakan perulangan (`do-while`) dan percabangan (`switch-case`).
- **Exception Handling (Anti-Crash):** Validasi *input* super ketat (contoh: *input* durasi harus angka) menggunakan `Try-Catch` untuk mencegah program berhenti paksa (*crash*).
- **File I/O (Persistensi Data):** Data otomatis disimpan ke dalam file `.txt` (`data_hotel_[NIM].txt`) dan dimuat ulang saat aplikasi dijalankan kembali.

## 📂 Struktur Direktori
Project ini dipisahkan menjadi beberapa *package* agar menyerupai arsitektur yang baik (Model & Main):
```text
📁 ReservasiHotel_Project        
│
├── 📁 nbproject                 
├── 📁 build                    
│
├── 📁 src                       
│   └── 📁 reservasi             
│       │
│       ├── 📁 model             
│       │   └── 📄 Kamar.java    
│       │
│       └── 📁 main              
│           └── 📄 ReservasiHotel.java
│
└── 📄 data_hotel_NIM_LU.txt

🛠️ Cara Menjalankan Aplikasi
1. Clone repository ini ke komputer Anda:
Bash
git clone [https://github.com/username-kamu/nama-repo-kamu.git](https://github.com/username-kamu/nama-repo-kamu.git)
2. Buka project menggunakan IDE (disarankan Apache NetBeans).
3. Jalankan file ReservasiHotel.java yang berada di dalam package reservasi.main.
4. Ikuti instruksi menu pada jendela Output console. 

👨‍💻 Author
Nama: Ikhram Fahrezi
NIM: 241011402337
Instansi: Universitas Pamulang (UNPAM)
