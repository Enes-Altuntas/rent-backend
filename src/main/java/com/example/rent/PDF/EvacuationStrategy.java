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

@Component
@Qualifier("Evacuation")
public class EvacuationStrategy implements PDFStrategy {
    @Override
    public String getType() {
        return "Evacuation";
    }

    @Override
    public byte[] generatePdf(Object data) {
        Flat flat = (Flat) data;

        Document document = new Document(PageSize.A4);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, byteArrayOutputStream);

        document.open();

        Paragraph h1 = new Paragraph("TAHLİYE TAAHHÜTNAMESİ");
        h1.setAlignment(Element.ALIGN_CENTER);
        document.add(h1);

        document.add(new Paragraph(" "));

        document.add(new Paragraph("        Halen kiracısı olarak kullanmakta olduğum, aşağıda yazılı adreste ki " +
                "taşınmazı, hiçbir ihbar ve ihtara gerek kalmadan kayıtsız ve şartsız olarak, aşağıda " +
                "belirtilen tarihte tahliye edeceğimi, aşağıda adı geçen kiraya veren mal sahibine teslim " +
                "aldığım gibi boş ve hasarsız olarak teslim edeceğimi, tahliye etmediğim takdirde hiçbir ihtar " +
                "ve hükme gerek kalmaksızın icrai takibata geçilerek cebri icra yoluyla beni tahliye ettirmesini, " +
                "icrai takibata geçerek yapacağı bilimum masrafları, uğrayacağı bilimum zarar ve ziyanları, bu " +
                "uğurda sarf olunacak bütün mahkeme, icra, avukat ve diğer masrafların tamamen bana ait olduğunu" +
                " kendi rızamla kabul, beyan ve taahhüt ederim."));

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Kiraya Veren Mal Sahibi: "));

        for (Owner owner : flat.getFlatOwners()) {
            document.add(new Paragraph(owner.getNameSurname() + " / " + owner.getTckn()));
        }
        
        document.add(new Paragraph(" "));

        String address = flat.getApartment().getNeighborhood() + " Mah." +
                flat.getApartment().getStreetName() + " Sok./Cad. " +
                flat.getApartment().getApartmentName() + " Apt. " +
                "No: " + flat.getApartment().getNumber() + " Daire: " + flat.getFlatNumber() + " " +
                flat.getApartment().getState() + "/" + flat.getApartment().getCity().toUpperCase();

        document.add(new Paragraph("Tahliye Edilecek Adres: " + address));

        document.add(new Paragraph(" "));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(flat.getFlatContract().getStartDate());

        document.add(new Paragraph("Kiranın Başlangıcı: " + dateString));

        document.add(new Paragraph("Tahliye Tarihi: . . . . . . . . . . . . . . . . ."));

        document.add(new Paragraph("Taahhütnamenin Alındığı Tarih: . . . . . . . . . . . . . . . . ."));

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        Paragraph footer = new Paragraph("TAAHHÜT EDEN(LER) VE İMZA(LARI)");
        footer.setAlignment(Element.ALIGN_CENTER);
        document.add(footer);

        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
