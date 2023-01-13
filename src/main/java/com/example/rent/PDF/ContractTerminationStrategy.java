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
@Qualifier("ContractTermination")
public class ContractTerminationStrategy implements PDFStrategy {
    @Override
    public String getType() {
        return "ContractTermination";
    }

    @Override
    public byte[] generatePdf(Object data) {
        Flat flat = (Flat) data;

        Document document = new Document(PageSize.A4);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, byteArrayOutputStream);

        document.open();

        Paragraph dateHeader = new Paragraph("Tarih:                ");
        dateHeader.setAlignment(Element.ALIGN_RIGHT);
        document.add(dateHeader);

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        Paragraph h1 = new Paragraph("KONTRAT FESİH KAĞIDI");
        h1.setAlignment(Element.ALIGN_CENTER);
        document.add(h1);

        document.add(new Paragraph(" "));

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

        document.add(new Paragraph("      " + dateString + " tarihli kira kontratı" +
                " ile " + resultOwnerNames + "’ten kiralamış olduğum " + address + " adresinde ki  konutu . . . . . . . . . . . .  tarihinde " +
                "insan ve eşyadan arınmış olarak mal sahibine teslim ettim."));

        document.add(new Paragraph("Bütün devlet dairelerine olan daire ile alakalı borçlarımı ödedim." +
                " Ayrıca kontratta 13.Maddede Yazılı Olan . . . . . . . . . . . .  depozitoyu " +
                "mal sahibi " + resultOwnerNames + "’ten nakden bizzat elden aldım."));

        document.add(new Paragraph("Mal sahibinden hiçbir alacağım yoktur. " +
                "İlgili kira kontratı . . . . . . . . . . . .  tarihinde fesih edilmiştir. "));

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Kiracı İsim-Soyisim"));
        document.add(new Paragraph(flat.getRenter().getNameSurname()));

        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
