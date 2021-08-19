import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class Main {

    // *****************************************************
    // エントリポイント
    // *****************************************************
    public static void main(String[] args) {

        System.out.println( "PDF作成" );
        
        try {
            // PDF
            PDDocument document = new PDDocument();

            // 新しいページのオブジェクトを作成します
            PDPage page = new PDPage();
            document.addPage(page);

            PDFont font = PDType0Font.load(document, new File("keifont.ttf"));

            PDPageContentStream stream = new PDPageContentStream(document, page);

            PdfText pdftext = new PdfText(stream, font);

            pdftext.drawStrng("日本語表示", 16, 0, 0 );
            pdftext.drawStrng("日本語表示", 60, 0, 100 );

            pdftext.drawLine(0, 0, 400, 800);

            stream.close();

            // ドキュメントを保存します
            document.save("sample.pdf");
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}