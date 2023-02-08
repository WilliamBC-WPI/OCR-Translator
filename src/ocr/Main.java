package ocr;

public class Main {
    public static void main(String[] args) {

        //Creating an OCR translator object and running inputs on it
        OCRTranslator ocr = new OCRTranslator();
        ocr.translate(" _     _  _       _   _  _   _   _ ", "| | |  _| _| |_| |_  |_   | |_| |_|", "|_| | |_  _|   |  _| |_|  | |_|   |");
        ocr.translate(" ", "|","|");
        ocr.translate("_ ", "_|", "_|");
    }
}
