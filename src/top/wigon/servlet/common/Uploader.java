package top.wigon.servlet.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        String fileName = "";
        for (Part part : req.getParts()) {
            fileName = UUID.randomUUID().toString().substring(0, 8) + extractFileName(part);
            part.write(uploadPath + File.separator + fileName);
        }
//        System.out.println("上传成功:" + fileUploadDirectory.getAbsolutePath() +File.separator+ fileName);
        StringBuilder content = new StringBuilder();
       /* content.append("{");
        content.append("code: 0");
        content.append(",msg: \"\"");
        content.append(",data: {");
        content.append("src:");
        content.append("/img/").append(fileName);
        content.append("  }}");*/
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", map2);
        map2.put("src", "img\\" + fileName);
        resp.setContentType("text/plain; charset=UTF-8;");
        ObjectMapper objectMapper = new ObjectMapper();
        resp.getWriter().write(objectMapper.writeValueAsString(map));
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