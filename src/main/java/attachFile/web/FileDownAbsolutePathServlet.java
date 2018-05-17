package attachFile.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileDownAbsolutePath")
public class FileDownAbsolutePathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_PATH = "D:/A_TeachingMaterial/7.JspSring/uploadStorage";
	private final int BUFFER_1024 =1024; 
	public FileDownAbsolutePathServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		File f = new File(UPLOAD_PATH + File.separator + fileName);

		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		response.setContentType("application/octet-stream");
		response.setContentLength((int) f.length());

		FileInputStream fis = new FileInputStream(f);
		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_1024];
		int len = -1;

		while ((len = fis.read(buffer)) != -1) {
			sos.write(buffer, 0, len);

		}
		fis.close();
		sos.close();
	}

}
