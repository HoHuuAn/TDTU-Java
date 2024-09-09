import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(name = "ImageServlet1", value = "/image1")
public class ImageServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("naruto.jpg");

        resp.setHeader("Content-type","image/jpg");

        byte[] buffer = new byte[1024];
        int bytesRead;

        while(true){
            assert is != null;
            if (!((bytesRead = is.read(buffer)) > 0)) break;
            resp.getOutputStream().write(buffer, 0, bytesRead);
        }
        is.close();
    }
}
