import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BookService service = new BookService();

        while (true) {
            System.out.println("\n=== Book CRUD ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Ubah Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (pilih) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Judul: ");
                    String title = scanner.nextLine();
                    System.out.print("Penulis: ");
                    String author = scanner.nextLine();
                    service.addBook(new Book(id, title, author));
                }
                case 2 -> {
                    System.out.println("Daftar Buku:");
                    for (Book b : service.getAllBooks()) {
                        System.out.println(b);
                    }
                }
                case 3 -> {
                    System.out.print("ID Buku yang diubah: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Judul Baru: ");
                    String title = scanner.nextLine();
                    System.out.print("Penulis Baru: ");
                    String author = scanner.nextLine();
                    if (service.updateBook(id, title, author)) {
                        System.out.println("Buku berhasil diubah.");
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                }
                case 4 -> {
                    System.out.print("ID Buku yang dihapus: ");
                    int id = scanner.nextInt();
                    if (service.deleteBook(id)) {
                        System.out.println("Buku dihapus.");
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                }
                case 0 -> {
                    System.out.println("Keluar...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }

        }

    }

}
