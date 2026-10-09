import java.util.ArrayList;
import java.util.Scanner;

public class StatikNilai {
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();
        int nilai;

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        // do-while: nilai harus dibaca dulu sebelum bisa dicek apakah itu sentinel
        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                continue;
            }
            if (nilai < 0 || nilai > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }
            daftar.add(nilai);
        } while (nilai != SELESAI);

        System.out.println();

        if (daftar.isEmpty()) {
            System.out.println("Belum ada nilai sah yang dimasukkan.");
            return;
        }

        int total = 0;
        for (int n : daftar) {
            total += n;
        }
        double rataRata = (double) total / daftar.size();

        // Tertinggi dan terendah dimulai dari nilai pertama di daftar, yaitu
        // daftar.get(0) (pada contoh soal: 85), bukan dari 0. Kalau terendah
        // dimulai dari 0, tidak ada nilai yang lebih kecil dari 0 sehingga
        // hasilnya selalu 0 (salah). Memulai dari data asli juga menjamin
        // nilai awalnya pasti ada di dalam daftar.
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int n : daftar) {
            if (n > tertinggi) {
                tertinggi = n;
            }
            if (n < terendah) {
                terendah = n;
            }
        }

        // Putaran kedua: rata-rata baru diketahui setelah SEMUA nilai dibaca dan
        // dijumlahkan. Di putaran pertama (saat membaca) rata-rata belum ada,
        // jadi belum ada pembanding untuk menentukan siapa yang di atasnya.
        int diAtas = 0;
        for (int n : daftar) {
            if (n > rataRata) {
                diAtas++;
            }
        }

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());
        System.out.printf("Rata-rata       : %.2f%n", rataRata);
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);
        System.out.println("Di atas rata2   : " + diAtas + " orang");
    }
}