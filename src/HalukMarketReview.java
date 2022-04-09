import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HalukMarketReview {

    /* Basarili Market alış-veriş programı.
		 *
		 * 1. Adım: Ürünler ve fiyatları içeren listeleri oluşturunuz.
		 * 			No 	   Ürün 		  Fiyat
				   ====	 =======	 	=========
					00	 Domates   	 	 2.10 TL
					01	 Patates   	 	 3.20 TL
					02	 Biber     	 	 1.50 TL
					03	 Soğan      	 2.30 TL
					04	 Havuç     	   	 3.10 TL
					05	 Elma      	   	 1.20 TL
					06	 Muz     	 	 1.90 TL
					07	 Çilek 	 		 6.10 TL
					08	 Kavun      	 4.30 TL
					09	 Üzüm      	 	 2.70 TL
					10	 Limon     	 	 0.50 TL

		 * 2. Adım: Kullanıcının ürün nosuna göre listeden ürün seçmesini isteyiniz.
		 * 3. Adım: Kaç kg satın almak istediğini sorunuz.
		 * 4. Adım: Alınacak bu ürünü sepete ekleyiniz ve Sepeti yazdırınız.
		 * 5. Başka bir ürün alıp almak istemediğini sorunuz.
		 * 6. Eğer devam etmek istiyorsa yeniden ürün seçme kısmına yönlendiriniz.
		 * 7. Eğer bitirmek istiyorsa ödemeyi kontrol edip para ustu hesaplayarak  programı bitirinzi.
		 */


   static ArrayList<String> urunler = new ArrayList<>(Arrays.asList("Domates","Patates","Biber" ,"Soğan","Havuç",
           "Elma","Muz","Çilek","kavun","Üzüm","Limon"  ));

   static List<Double> fiyatlar = new ArrayList<>(Arrays.asList(2.1,      3.2,    1.5,    3.3,     3.1,   1.2,     1.9, 6.10,   4.3 ,    2.7,    0.5    ));

   static ArrayList<String> urunSparisler= new ArrayList<>();
   static ArrayList<Integer> urunKG = new ArrayList<>();

    static ArrayList<String> urunSparislerGorunus= new ArrayList<>();

   static Scanner scan = new Scanner(System.in);
   static int toplamOdeme =0;

    public static void main(String[] args) {

        secim11();






    }

    private static void secim11() {
        System.out.println("Domates 1 ,Patates 2 ,Biber 3  ,Soğan 4 ,Havuç  5, Elma 6 , Muz 7 , Çilek 8 ,kavun 9 ,Üzüm 10,Limon 11 " );
        System.out.println("Lütfen ürünü seçiniz");
        int scmUrun = scan.nextInt();
        System.out.println("lütfen kg giriniz");
        int scmKG = scan.nextInt();

        urunSparisler.add(urunler.get(scmUrun-1));
        urunKG.add(scmKG);
        System.out.println("urun = "+(urunler.get(scmUrun-1)+" KG = "+scmKG+"\nSepete Eklendi"));
        urunSparislerGorunus.add(urunler.get(scmUrun-1)+" "+scmKG +"kg");
        toplamOdeme+=fiyatlar.get(scmUrun-1)*scmKG;
        tamamDevamMi3();


    }

    private static void tamamDevamMi3() {
        String scm ="";
        do{
            System.out.println("işleme devam etmek ister misiniz E/H");
            scm = scan.next();
            if (scm.equalsIgnoreCase("e")){
                secim11();
                break;
            }else if (scm.equalsIgnoreCase("h")){
                kasa();
                break;

            }

        }while(!scm.equalsIgnoreCase("e") && !scm.equalsIgnoreCase("h") );
    }

    private static void kasa() {
        System.out.println("kasaya hos geldiniz");
        System.out.println(urunSparislerGorunus);
        System.out.println("toplam borcunuz = "+toplamOdeme);
        System.out.println("lütfen giriş yapacağınız meblayı giriniz");
        int girisMebla= scan.nextInt();
        if(girisMebla>=toplamOdeme) {
            System.out.println("para üstü = " + (girisMebla - toplamOdeme));
        }else if(girisMebla<toplamOdeme){
            System.out.println("yetersiz giris yaptınız");
        }else System.out.println("garip bir seyler oldu");
    }
}
