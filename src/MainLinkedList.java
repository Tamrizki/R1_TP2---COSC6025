import java.util.Scanner;

public class MainLinkedList {
    static class Node {
        String kodeBuku;
        String judul;
        String penulis;
        Node next;

        public Node(String kodeBuku, String judul, String penulis) {
            this.kodeBuku = kodeBuku;
            this.judul = judul;
            this.penulis = penulis;
            this.next = null;
        }
    }

    static class LinkedList {
        private Node head;
        private int count;

        public LinkedList() {
            this.head = null;
            this.count = 0;
        }

        // Mengembalikan jumlah buku yang saat ini tersimpan di linked list
        public int getCount() {
            return count;
        }

        // Menambahkan buku baru di akhir daftar linked list
        public void tambahBuku(String kodeBuku, String judul, String penulis) {
            Node nodeBaru = new Node(kodeBuku, judul, penulis);
            if (head == null) {
                head = nodeBaru;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = nodeBaru;
            }
            count++;
            System.out.println("Data berhasil ditambahkan!");
        }

        // Menghapus buku paling akhir dari daftar linked list
        public void hapusBukuTerakhir() {
            if (head == null) {
                System.out.println("Tidak ada data untuk dihapus.");
                return;
            }

            if (head.next == null) {
                System.out.println("Buku dengan kode " + head.kodeBuku + " berhasil dihapus.");
                head = null;
            } else {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                System.out.println("Buku dengan kode " + temp.next.kodeBuku + " berhasil dihapus.");
                temp.next = null;
            }
            count--;
        }

        // Mencari buku berdasarkan kode buku dan menampilkan detailnya jika ditemukan
        public void cariBuku(String kodeBuku) {
            if (head == null) {
                System.out.println("Buku tidak ditemukan.");
                return;
            }

            Node temp = head;
            while (temp != null) {
                if (temp.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                    System.out.println("Detail Buku Ditemukan:");
                    System.out.println("Kode: " + temp.kodeBuku + " | Judul: " + temp.judul + " | Penulis: " + temp.penulis);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Buku tidak ditemukan.");
        }

        // Menampilkan seluruh data buku yang ada di linked list
        public void tampilkanSemua() {
            if (head == null) {
                System.out.println("Daftar Buku kosong.");
                System.out.println("Total Buku: 0");
                return;
            }

            System.out.println("Daftar Buku:");
            Node temp = head;
            while (temp != null) {
                System.out.println("Kode: " + temp.kodeBuku + " | Judul: " + temp.judul + " | Penulis: " + temp.penulis);
                temp = temp.next;
            }
            System.out.println("Total Buku: " + count);
        }
    }

    // Program utama yang menampilkan menu dan menjalankan operasi linked list
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList daftarBuku = new LinkedList();
        int pilihan = 0;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    String kodeBuku;
                    while (true) {
                        System.out.print("Masukkan Kode Buku (Maks 5 Karakter): ");
                        kodeBuku = scanner.nextLine().trim();
                        if (kodeBuku.length() <= 5 && !kodeBuku.isEmpty()) {
                            break;
                        }
                        System.out.println("Kode buku tidak boleh kosong dan maksimal 5 karakter!");
                    }

                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();

                    daftarBuku.tambahBuku(kodeBuku, judul, penulis);
                    break;

                case 2:
                    daftarBuku.hapusBukuTerakhir();
                    break;

                case 3:
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    String cariKode = scanner.nextLine();
                    daftarBuku.cariBuku(cariKode);
                    break;

                case 4:
                    if (daftarBuku.getCount() < 5) {
                        System.out.println("[Peringatan] Jumlah data saat ini (" + daftarBuku.getCount() +
                                           " buku) belum mencapai syarat minimal 5 buku.");
                    }
                    daftarBuku.tampilkanSemua();
                    break;

                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}