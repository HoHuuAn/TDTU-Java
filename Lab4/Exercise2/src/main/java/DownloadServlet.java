import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;

@WebServlet(name = "DownloadServlet", value = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String filename = req.getParameter("file");
        if(filename == null || filename.isEmpty()){
            resp.getWriter().println("Invalid file name");
            return;
        }
        String speedString = req.getParameter("speed");
        int speed = 0;
        if (speedString != null) {
            try {
                speed = Integer.parseInt(speedString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        if (is == null){
            resp.getWriter().println("File not found");
            return;
        }
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition","attachment; filename=\""+ filename +"\"");
        resp.setHeader("Content-Length", String.valueOf(filename.length()));

        if (speed > 0) {
            resp.setHeader("X-Throttle", String.valueOf(speed));
        }

        byte[] buffer = new byte[1024];
        int bytesRead;

        while(true){
            if (!((bytesRead = is.read(buffer)) > 0)) break;
            resp.getOutputStream().write(buffer, 0, bytesRead);

            if (speed > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        is.close();
    }
}
