package com.example.rent.PDF;

import com.example.rent.Entity.Flat.Flat;
import com.example.rent.Entity.Owner.Owner;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("NewContract")
public class NewContractPDFStrategy implements PDFStrategy {
    @Override
    public String getType() {
        return "NewContract";
    }

    @Override
    public byte[] generatePdf(Object data) {
        Flat flat = (Flat) data;

        Document document = new Document(PageSize.A4);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, byteArrayOutputStream);

        document.open();

        Paragraph h1 = new Paragraph("KİRA SÖZLEŞMESİ");
        h1.setAlignment(Element.ALIGN_CENTER);
        document.add(h1);

        document.add(new Paragraph(" "));

        document.add(new Paragraph("1-Taraflar"));

        List<String> ownerNames = new ArrayList<>();
        List<String> tckns = new ArrayList<>();
        List<String> phones = new ArrayList<>();

        for (Owner owner : flat.getFlatOwners()) {
            ownerNames.add(owner.getNameSurname());
            tckns.add(owner.getTckn());
            phones.add(owner.getPhoneNumber());
        }

        String resultOwnerNames = String.join(", ", ownerNames);
        document.add(new Paragraph("Kiraya Veren: " + resultOwnerNames));

        String resultOwnerTCKN = String.join(", ", tckns);
        document.add(new Paragraph("T.C. Kimlik No: " + resultOwnerTCKN));

        String resultOwnerPhones = String.join(", ", phones);
        document.add(new Paragraph("Tel No: " + resultOwnerPhones));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("Kiracı: " + flat.getRenter().getNameSurname()));

        document.add(new Paragraph("T.C. Kimlik No: " + flat.getRenter().getTckn()));

        document.add(new Paragraph("Tel No: " + flat.getRenter().getPhoneNumber()));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("2- Kiralanan ve Durumu"));

        String address = flat.getApartment().getNeighborhood() + " Mah." +
                flat.getApartment().getStreetName() + " Sok./Cad. " +
                flat.getApartment().getApartmentName() + " Apt. " +
                "No: " + flat.getApartment().getNumber() + " Daire: " + flat.getFlatNumber() + " " +
                flat.getApartment().getState() + "/" + flat.getApartment().getCity().toUpperCase();

        document.add(new Paragraph(address +
                " adresinde bulunan konut boş ve temiz olarak, tüm demirbaşları " +
                "(kapılar,pencereler, klima,radyatörler, mutfak dolaplar,yeni saten boyalı,banyo dolapları, " +
                "aspiratör,yerler parke, evyeler, bataryalar, klima) sağlam ve çalışır bir şekilde kiracıya teslim " +
                "edilmiştir. Kiralananın boşaltılıp, geri iadesi de aynı şekilde gerçekleştirilecektir."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("3- Kira Süresi"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(flat.getFlatContract().getStartDate());

        document.add(new Paragraph("Kira ilişkisi " + dateString +
                " tarihinden itibaren başlamak üzere, 1 (yıllık) yılık " +
                "süre için kurulmuş olup, süre bitiminde sonlandırılmak istendiği takdirde, bitim tarihinden en az bir " +
                "ay öncesine kadar karşı tarafa yazılı olarak bildirilecektir. Aksi takdirde sözleşme aynı şartlar " +
                "çerçevesinde bir yıllık olarak yenilenmiş sayılacaktır. Yenilenmiş sayılan kira sözleşmelerinin " +
                "sonlandırılmaları da, yine aynı şekilde süre sonundan en az bir ay öncesine kadar bildirime tabi " +
                "olacak, aksi takdirde kira ilişkisi birer senelik fasıllarla devam ede gelecektir."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("4- Kira Bedeli ve Ödeme Şekli"));

        document.add(new Paragraph("Kiralananın aylık kira bedeli " + flat.getFlatPrice() + " " +
                flat.getCurrency().getCurrencyValue() + " ( . . . . . . . . . . . . . . . . . . . . . . . . . . . . .  " +
                flat.getCurrency().getCurrencyValueLong() + " )  olup, " +
                "kiralar her ayın " + flat.getFlatContract().getPaymentDue() + ". günü mesai saati bitimine kadar " +
                "peşin, nakden ve defaten ödenecektir."));

        document.add(new Paragraph(" "));

        for (Owner owner : flat.getFlatOwners()) {
            document.add(new Paragraph("Ödemeler kiraya verenin " + owner.getBankName() + " " +
                    owner.getBankBranch() + " şubesinde ki " + owner.getAccountNumber() + " " +
                    "numaralı hesabına yatırmak suretiyle yapılacaktır. Kira bedeli net olup, stopaj, vergi vs. " +
                    "adı altında herhangi bir kesinti yapılamaz."
            ));

            document.add(new Paragraph("Banka IBAN No: " + owner.getIban()));

            document.add(new Paragraph(" "));
        }

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("5-Yeni Dönem Kiralan"));

        document.add(new Paragraph("Kiralar, birer senelik fasılalarla belirlenecek her dönemin başında, " +
                "TÜIK tarafından açıklanan tüketici fiyat endeksindeki yıllık artış oranındaki artış ortalamasına " +
                "göre arttırılacak, önceden hiçbir ihtar, uyarı ve hatırlatmada bulunmaya, göndermeye gerek " +
                "kalmaksızın. Kiracı tarafından artış yukarıdaki esaslar çerçevesinde kendiliğinden hesaplanarak, " +
                "kira her yeni yılın kira başlangıç tarihinden itibaren artımlı olarak ödenecek ve yatırılacaktır."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("6- Kullanım Şekli ve Devir Yasağı"));

        document.add(new Paragraph("Kiralanan " + flat.getFlatUsage().getUsageValue() + " olarak kullanılmak " +
                "üzere kiralanmış olup, bu amaç dışında kullanılmayacaktır. Kira ilişkisi başkasına devredilemeyecek," +
                " başka veya alt kiracı alınamayacak, " +
                "kiralanan kısmen veya tamamen başkasına kullandırılmayacaktır."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("7- Kira Ödemelerinin Aksatılması"));

        document.add(new Paragraph("Sürecinde ödenmeyen kiralara, ilgili ayın kira borcunun doğduğu tarihte " +
                "yürürlükte bulunan yıllık faiz oranının yüzde elli fazlasına isabet eden gecikme faizi oranı " +
                "uygulanacak ve ödenecek bedeller öncelikle gecikme faizlerine, masraflara sayılacaktır."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("8- Kullanım ve Yönetim Giderleri"));

        document.add(new Paragraph("Kiralananın tüm elektrik, su, doğalgaz harcama bedelleri, işletme giderleri, " +
                "aidatlar, yönetici kapıcı/bahçıvan/muhasebeci/güvenlikçi vb. ücretleri kiracıya ait olup, bunlardan " +
                "herhangi birinin ödenmemesi de tahliye nedeni oluşturacaktır. "));

        document.add(new Paragraph("Gereken tüm abonelikleri kiracı kendi adına kuracak olup, bunlardan " +
                "dolayı kiraya verenden herhangi bir talepte bulunulamayacaktır."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("9- Onarım ve Eklenti Giderleri"));

        document.add(new Paragraph("Ana yapıda kat malikleri kurulunca alınan kararlar çerçevesinde yaptırılacak " +
                "onarım ve tamiratların, binaya yapılacak eklentilerin, kısacası kiralanana demirbaş olarak yapılacak " +
                "işlerin ödemeleri kiraya verene ait olacaktır. Bunlara ilişkin olarak kiracı tarafından herhangi bir " +
                "ödeme ve kira kesintisi yapılamayacaktır."));

        document.add(new Paragraph("Kiralanan meskende, Kiraya Verenden izin almaksızın, herhangi bir değişikliğe" +
                " ve onarıma gidilemeyecektir. Kiraya Verenin izni ve yasal düzenlemelerin imkanı dahilinde yapılacak" +
                " değişikliklerin, eklentilerin ve iyileştirmelerin, tamiratlarının tüm giderleri Kiracıya ait olacak," +
                " bunlardan dolayı herhangi bir masraf talebinde bulunulamayacak, kira bedeli kesintisi yapılamayacak," +
                " değer artışı istenemeyecektir."));

        document.add(new Paragraph("İzin, kiralananın iadesinde eski haline döndürülmesi kaydı ile verilmiş " +
                "olduğu takdirde, Kiracı zarar vermeden kiralanan( eski haline getirmek ve ilk " +
                "haliyle teslim etmek zorunda bulunacaktır."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("10- Sözleşmenin Sona Ermesi"));

        document.add(new Paragraph("Kira ilişkisi belirlenen kira dönemlerinin sonunda ve Kiracı tarafından " +
                "yenilenmek istenmemesi halinde sona erebileceği gibi, tarafların karşılıklı anlaşmaları ile de her " +
                "zaman sona erdirilebilecektir. Kiraya Verenin izin ve onayı olmaksızın, kiralananın dönem sonundan " +
                "önce tahliyesi halinde, kiralananın benzer koşullarla kiraya verilmesi tarihine kadarki kira " +
                "bedelleri de alınabilecek, bu tarihe kadar kira ilişkisi devam edecektir."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("11- Diğer düzenlemeler"));

        document.add(new Paragraph("Sözleşmede yer almayan diğer konularda 6098 sayılı Türk Borçlar " +
                "Kanunu'nun getirdiği düzenlemeler aynen geçerli olacaktır."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("12- Tebligatlar ve Uyuşmazlıkların Çözümü"));

        document.add(new Paragraph("Tüm taraftar işbu sözleşmede yer alan adreslerinin kanuni ikametgah " +
                "adresleri olduğunu, bunların değişmesi halinde durumu en geç bir hafta içerisinde birbirlerine " +
                "yazılı olarak bildireceklerini, bu adreslere yapılacak tebligatların geçerli sayılacağını kabul ve " +
                "taahhüt etmektedirler. Doğabilecek uyuşmazlıklar karşılıklı görüşmeler yoluyla çözümlenmeye " +
                "çalışılacak, uzlaşma sağlanamaması halinde yargı organları yetkili çözüm yeri olacaktır."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("13- Depozito"));

        document.add(new Paragraph("Kiracı, mal sahibine . . . . . . . . . . " + flat.getCurrency().getCurrencyValue() +
                " (. . . . . . . . . . . . . . . . . . . . . . . . . . . . . " + flat.getCurrency().getCurrencyValueLong() +
                " ) Depozito elden vermiştir. Toplam 13 maddeden ibaret işbu kira sözleşmesi, her tarafa birer adet " +
                "verilmek üzere iki suret halinde birlikte düzenlenip, " + dateString + "tarihinde imza altına alınmıştır."));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("Kiraya Veren                                                                  " +
                "               Kiracı"));

        for (int i = 0; i < flat.getFlatOwners().size(); i++) {
            if (i == 0) {
                document.add(new Paragraph(flat.getFlatOwners().get(i).getNameSurname() + "                                                                  " +
                        "               " + flat.getRenter().getNameSurname()));
            } else {
                document.add(new Paragraph(flat.getFlatOwners().get(i).getNameSurname()));
            }
        }

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Garantör / Kefil:"));
        document.add(new Paragraph(". . . . . . . . . . . . . . . . . . . ."));
        document.add(new Paragraph("TC : . . . . . . . . . . . . . . . ."));
        document.add(new Paragraph("TEL : . . . . . . . . . . . . . . . "));

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Doğalgaz Tesisat No’su : . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . işareti : "));
        document.add(new Paragraph("Elektrik Tesisat No’su : . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . işareti : "));
        document.add(new Paragraph("Su Mukavele No’su : . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . işareti : "));

        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
