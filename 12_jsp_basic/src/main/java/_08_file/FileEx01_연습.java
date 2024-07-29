package _08_file;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/fileEx01_연습")
public class FileEx01_연습 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("chapter08_file/fileEx_문제/fileEx01_연습.jsp"); 
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String saveDirectory = FileConfig.FILE_REPOSITORY_PATH;
		
		MultipartRequest mr = new MultipartRequest(request, saveDirectory, 1024 * 1024 * 100, "utf-8");
		Enumeration<?> files = mr.getFileNames();

		String uploader = mr.getParameter("uploader");
		
		if(files.hasMoreElements()) {
			
			String element = (String) files.nextElement();
			String originalFileName = mr.getOriginalFileName(element);
			
			System.out.println("uploader : " + uploader);
			System.out.println("originalFileName : " + originalFileName);
			
			String jsScript = """
					<script>
						alert('파일을 업로드 하였습니다.');
						location.href = 'fileMain';
					</script>""";
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print(jsScript);
		}
	}

}
