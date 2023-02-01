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
import java.util.Date;

@Component
@Qualifier("FifthYearWarning")
public class FifthYearWarningStrategy implements PDFStrategy {
    @Override
    public String getType() {
        return "FifthYearWarning";
    }

    @Override
    public byte[] generatePdf(Object data) {
        Flat flat = (Flat) data;

        Document document = new Document(PageSize.A4);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, byteArrayOutputStream);

        document.open();

        Paragraph h1 = new Paragraph("İHTARNAME");
        h1.setAlignment(Element.ALIGN_CENTER);
        document.add(h1);

        document.add(new Paragraph(" "));

        document.add(new Paragraph("İHTAR EDEN :"));

        for (Owner owner : flat.getFlatOwners()) {
            document.add(new Paragraph(owner.getNameSurname() + " - " + owner.getTckn()));
            document.add(new Paragraph(owner.getAddress()));
        }

        String address = flat.getApartment().getNeighborhood() + " Mah." +
                flat.getApartment().getStreetName() + " Sok./Cad. " +
                flat.getApartment().getApartmentName() + " Apt. " +
                "No: " + flat.getApartment().getNumber() + " Daire: " + flat.getFlatNumber() + " " +
                flat.getApartment().getState() + "/" + flat.getApartment().getCity().toUpperCase();

        document.add(new Paragraph(" "));

        document.add(new Paragraph("MUHATAP    :"));

        document.add(new Paragraph(flat.getRenter().getNameSurname() + " - " + flat.getRenter().getTckn()));

        document.add(new Paragraph(address));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(new Date());

        document.add(new Paragraph(" "));

        document.add(new Paragraph("KONU           : " + dateString + " tarihi itibariyle yeni dönem kira " +
                "bedelinin aylık net " + flat.getFlatPrice() + " " + flat.getCurrency().getCurrencyValue() + " olarak ödenmesi ihtarıdır"));

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Sayın Muhatap;"));

        document.add(new Paragraph(" "));

        String startDate = sdf.format(flat.getFlatContract().getStartDate());

        document.add(new Paragraph(startDate + " başlangıç tarihli yazılı kira sözleşmesi uyarınca " +
                address + " adresindeki " + flat.getFlatUsage().getUsageValue() + " vasıflı taşınmazda kiracı sıfatı " +
                "ile bulunmaktasınız. "));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("Gelişen ekonomik koşullar ve emsal kira bedelleri dikkate alınarak " +
                dateString + " tarihi itibariyle yeni dönem kira bedelini aylık net " + flat.getFlatPrice() +
                " " + flat.getCurrency().getCurrencyValue() + " olarak ödemenizi, aksi takdirde aleyhinize kira " +
                "tespit davasi açacağımızı, bu durumda sarfedilecek yargılama giderlerinin de tarafınıza yükleneceğini, " +
                "tüm yasal haklarımız saklı kalmak kaydı ile ihtar ve ihbar ederiz."));

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Sayın Noter;"));

        document.add(new Paragraph(" "));

        document.add(new Paragraph("İşbu ihtarnamenin bir suretinin muhataba APS ile tebliğini, bir " +
                "suretinin dairenizde muhafazasını, tebliğ şerhini havi bir " +
                "suretinin de tarafıma iadesini talep ederim . "));

        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
