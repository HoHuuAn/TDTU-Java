package com.hohuuan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "DownloadServlet", value = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("filename");
        if (fileName == null || fileName.isEmpty()) {
            resp.getWriter().println("Invalid file name");
            return;
        }

        String filePath = getServletContext().getRealPath("uploads") + File.separator + fileName;
        File file = new File(filePath);

        if (!file.exists()) {
            resp.getWriter().println("File not found");
            return;
        }

        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = resp.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}

