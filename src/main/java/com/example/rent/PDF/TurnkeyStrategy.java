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
@Qualifier("Turnkey")
public class TurnkeyStrategy implements PDFStrategy {
    @Override
    public String getType() {
        return "Turnkey";
    }

    @Override
    public byte[] generatePdf(Object data) {
        Flat flat = (Flat) data;

        Document document = new Document(PageSize.A4);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, byteArrayOutputStream);

        document.open();

        Paragraph h1 = new Paragraph("TAŞINMAZ ve ANAHTAR TESLİM TUTANAĞI");
        h1.setAlignment(Element.ALIGN_CENTER);
        document.add(h1);

        document.add(new Paragraph(" "));

        document.add(new Paragraph("TARİH                                  : . . . . . . . . . . . . . "));
        document.add(new Paragraph("KİRACI                                 : " + flat.getRenter().getNameSurname()));

        List<String> ownerNames = new ArrayList<>();

        for (Owner owner : flat.getFlatOwners()) {
            ownerNames.add(owner.getNameSurname());
        }

        String resultOwnerNames = String.join(", ", ownerNames);

        String address = flat.getApartment().getNeighborhood() + " Mah." +
                flat.getApartment().getStreetName() + " Sok./Cad. " +
                flat.getApartment().getApartmentName() + " Apt. " +
                "No: " + flat.getApartment().getNumber() + " Daire: " + flat.getFlatNumber() + " " +
                flat.getApartment().getState() + "/" + flat.getApartment().getCity().toUpperCase();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(flat.getFlatContract().getStartDate());

        document.add(new Paragraph("KİRAYA VEREN                  : " + resultOwnerNames));
        document.add(new Paragraph("KİRALANANIN ADRESİ      : " + address));
        document.add(new Paragraph("KİRA SÖZLEŞME TARİHİ   : " + dateString));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("      Yukarıda bilgileri verilen taşınmaz, belirsiz süreli kira " +
                "sözleşmesinin tarafların anlaşması üzerine, anlaşmalı olarak feshedilmesi nedeniyle tahliye " +
                "edilmiştir. Taşınmaz, kiracı tarafından, içindeki eşyalar eksizsiz bir şekilde teslim edilmiş " +
                "bulunmaktadır. Ayrıca taşınmaza ait tüm anahtarlar da teslim edilmiştir. Tarafların söz konusu " +
                "kira sözleşmesiyle ilgili olarak birbirlerini ibra etmiş bulunup, tarafların birbirinden söz konusu " +
                "kira sözleşmesine dayalı herhangi bir hak ve alacağımızın kalmadığını, adı geçen sözleşmeyi " +
                "karşılıklı olarak feshettiğimizi beyan ve kabul ederiz."));

        document.add(new Paragraph(" "));
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

        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
