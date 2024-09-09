package com.hohuuan;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name="UploadServlet", value = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("GET Method is not supported");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        Part part = req.getPart("file");
        boolean overrideIfExists = (req.getParameter("override") != null);

        if (part == null) {
            resp.getWriter().println("Please choose a file");
            return;
        }

        String upLoadPath = getServletContext().getRealPath("uploads");
        File upLoadDir = new File(upLoadPath);
        if (!upLoadDir.exists()) {
            upLoadDir.mkdir();
        }

        String fileName = part.getSubmittedFileName();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

        String[] supportedExtensions = {"txt", "doc", "docx", "img", "pdf", "rar", "zip"};
        boolean isSupported = false;
        for (String extension : supportedExtensions) {
            if (extension.equals(fileExtension)) {
                isSupported = true;
                break;
            }
        }

        if (!isSupported) {
            resp.getWriter().println("Unsupported file extension");
            return;
        }
        String newFileName = (name != null && !name.isEmpty()) ? name + "." + fileExtension : fileName;

        String destination = upLoadPath + File.separator + newFileName;
        File file = new File(destination);
        boolean exist = file.exists();
        if (exist && !overrideIfExists) {
            resp.getWriter().println("File already exists");
            return;
        }

        part.write(destination);

        if (exist) {
            resp.getWriter().println("File has been overridden");
        } else {
            resp.getWriter().println("<html><body>");
            resp.getWriter().println("File has been uploaded. Click <a href=\"download?filename=" + newFileName + "\">here</a> to download the file.");
            resp.getWriter().println("</body></html>");
        }
    }
}