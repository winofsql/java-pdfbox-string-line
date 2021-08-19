import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import java.awt.Color;

public class PdfText {

    private PDFont font;
    private PDPageContentStream stream;

    public PdfText( PDPageContentStream stream, PDFont font ){
        this.font = font;
        this.stream = stream;
    }

    public void drawStrng(String text, int size, float x, float y) {
        try {
            stream.beginText();
            stream.setFont(this.font, size);
            stream.newLineAtOffset(x +10, 772 - y);
            stream.showText( text );
            stream.endText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawLine(float x, float y,float x2, float y2) {
        try {
            // 罫線の始点座標を指定
            stream.moveTo(x, y);
            // 罫線の終点座標を指定
            stream.lineTo(x2, y2);
            // 罫線の色を指定
            stream.setStrokingColor(Color.GRAY);
            // 罫線の幅を指定
            stream.setLineWidth(1f);
            // 罫線を引く
            stream.stroke();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }	

}