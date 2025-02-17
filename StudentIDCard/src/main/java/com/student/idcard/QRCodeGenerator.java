package com.student.idcard;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

public class QRCodeGenerator {
    public static void generateQRCode(String url, String filePath) throws Exception {
        int width = 300;  // Width of the QR Code
        int height = 300; // Height of the QR Code

        // Generate the QR Code
        BitMatrix matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(matrix, "PNG", path);

        System.out.println("✅ QR Code Generated: " + filePath);
    }

    public static void main(String[] args) {
        try {
            // Your SIS Portal URL
            String url = "https://sis.idealtech.edu.in/";

            // Save QR Code as an image
            String filePath = "student_qr.png";
            generateQRCode(url, filePath);

            System.out.println("📌 Scan the QR Code to visit: " + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}