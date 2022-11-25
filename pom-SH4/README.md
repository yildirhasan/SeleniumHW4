Testler Tb 5 de gerceklenmistir pom yapisiyla , pageler ve test classlari olusturulmustur , @findby annotaioni kullanarak pagelerde locatorlar ve methodlar , test page i latinda da ilgli test senaryolari ile testler gerceklenmektedir.Asagidaki komutlari kullarak calisitirabilirsiniz .

`mvn -Dtest=UserCrationTest test `, `mvn -Dtest=YedekParcaTest test ` diyerek run edebilirsiniz .

Test Caseleri asagidaki gibidir bazi testlerin altinda birden fazla test bulunmaktadir test() test2() test3() diye

`ClassifedDetailTest`

IlanDetaydanIlanSikayetEtme ilan homepage de otomobile tiklanir ordan tum arba ilanlari tiklanir ve ardindan gelen listedeki ilk ilana tiklanip, ilan detay acilir ilan detay acildiktan sonra ilan sikayet edilir tiklanir , sikayet icin pop up geldigi kontrol edilir ve reason secilir , comment alanina sikayet yazilir gondere basilir Basarili sekilde ilanin sikayet edildigi popUp i acildigi ve acilan pop updaki success mesajinin dogru geldigi kontrol edilir
BireyselUserileFavoriEklemeveLogin anasayfayada otomobile kismina tiklanir , tum vitrin ilanlari tiklanir ardindan ilk ilana tiklanir ilan detay sayfasi acildiktan sonra , favorilere ekle tiklanir burada , login olmayan user oldugu icin pop up acilir ve acilan favori pop up da gelen login mesaj kontrol edilir Sonrasinda bireysel user ile login olunur
KurumsalUserileFavoriEklemeveLogin Anasayfayada yedek parcaya tiklanir sonrasinda acilan sayfada tum vitrin ilanlari denir ve gelen sayfadaki ilk ilana tiklanir Ilan detay acilir ve ilan favorilere ekler e tiklanir , login olmayan user oldugu icin favori pop up acilir ve acilan pop upda favori ile iligli login mesaji kontrol edilirSonrasinda Kurumsal user ile login olunur

`CreatClassifiedTest`

1.Anasayfa acilir ,giris yap denir ve username ve password girildiikten sonra ucretsiz ilan ver tiklanir Kategori olarak Ozel ders Verenler secilir ve Lise Universite ye tiklanir devam et denir sonrasinad ilan adi aciklamsi ucret bilgisi girilir Ders alani secilir sonrsainda cinsiyet tercihleri yapilir , il ilce ve mahale biglisi girildikten sonra haritada yer tiklanir Anlasma imzalanir ve devam et e basilir sonrasinda preview adimi gelr burada ilerle denir doping adiminda devam et deendikten sonra Basarili ilan verildigi success mesaji gorulur ve onun kontrolu ile ilan verme tamamlanir

`LoginTest`

1.Anasayfadan giris yap a tiklanir username ve password girilir login submit olur ve oage in bana ozel oldugu ile giris yapitigi konrol edilir 2.Anasayfadan giris yap a basilir username tiklanir sonrasinda sifremi unuttum denir gelen sayfada mail adresi alaninda text assertion yapilir Mail adresi girilir ve gondere basilir 3..Anasayfadan girise basilir username girilirr sifre girilmeden subtmie tiklanir , sifre giriniz , error mesajini geldigi check edilir

`MessageTest`

1.Anasayfayada otomobile tiklanir tum vitrin ilanlari denir ve gelen sayfadan ilk ilanin id si alinir , ve ilk ilana tiklanir ilan detay acilir mesaj gonder yapilir eklenir login olmayan user oldugu icin pop up acilir ve pop up mesaji dogru geldigi kontrol edilir, Bireysel user ile login olunur ve ilgili ilan icin mesaj gonderilir 2.Kurumsal ilan icin ayni test kosulur

`RealEstate360Test`

Anasayfadan Emlak 360 a tiklanir acilan sayfaki logo Emlka-360 yazisi ile current urldeki Emlak360 title eslesdigi check edilir

`SearchTest`

1.Anasayfadan Detayli aramya tiklanir, emlak secilir fiyat bilgileri griili ve sehir secildikten sonra arama yapilir, urlin icinde yer bilgisi oldugu dogrulanir 2.Anasayfadan Populer aramaya ilk siradakine tiklar tiklanir ,acilan liste sayfasi olur ve bu sayfadan ilk ilan icin title ile fiyat bilgisi alinir Liste arama sayfadaki ilk ilana tiklanir ve ilan detaya gidilir , burada search sayfasindan aldigimiz fiyat ve title bilgisinin dogru oldugu kontrol edilir

`UserCrationTest`

Anasayfadan kayit ol basilir username surname mail anlasma yapilir create acacount tiklanir success mesaj ve popup in goruntulendigi ve emailin dogru sekilde match ettigi check edilir , basarili sekilde bireysel user olusturulur

`YedekParcaTest`

Anasayfadan Yedek Parca ya tiklanir , tum vitrin ilanlarina tiklanir , acilan liste sayfasinda solda filtreme seceneklerinden durumuna ikinci el olarak isaretlenip tekrar ara buttonuna basilir ve search yaptirilir , search sonrasi url den filtrelemenin dogru geldigi contains ile kontrolu yapilir , burdaki sayfadan aramada bulunan ilk ilanin id si alinir ve ona tiklanir , acilan sayfadki ilan current url icinde id nin oldugu kontrol edlir