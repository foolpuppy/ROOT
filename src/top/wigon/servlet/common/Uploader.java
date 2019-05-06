package top.wigon.servlet.common;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/17 13:39
 **/
@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, //10 MB
        maxFileSize = 1024 * 1024 * 30, // 30 MB
        maxRequestSize = 1024 * 1024 * 50)//50 MB
public class Uploader extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UPLOAD_DIR = "img";
        String applicationPath = getServletContext().getRealPath("");
        //String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
        System.out.println("uploadPath:" + uploadPath);
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        System.out.println("upload directory path:" + fileUploadDirectory.getAbsolutePath());
        String fileName;
        for (Part part : req.getParts()) {
            //fileName = extractFileName(part);
            fileName = String.valueOf(UUID.randomUUID()).substring(0, 10);
            part.write(uploadPath + File.separator + fileName);
        }
        StringBuilder content = new StringBuilder();
        content.append("{\n" +
                "  \"code\": 0\n" +
                "  ,\"msg\": \"\"\n" +
                "  ,\"data\": {\n" +
                "    \"src\":");
        content.append(fileUploadDirectory.getAbsolutePath());
        content.append("  }\n" +
                "}");
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().write(content.toString());

    }

    private String extractFileName(Part part) {
        String fileName = "";
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return fileName;
    }
}