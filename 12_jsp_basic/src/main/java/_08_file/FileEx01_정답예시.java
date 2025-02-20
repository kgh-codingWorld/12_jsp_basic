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

@WebServlet("/fileEx01_정답예시")
public class FileEx01_정답예시 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("chapter08_file/fileEx_정답예시/fileEx01_정답예시.jsp"); 
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartRequest multipartRequest = new MultipartRequest(request, FileConfig.FILE_REPOSITORY_PATH , 1024 * 1024 * 100 , "utf-8" );
		Enumeration<?> files = multipartRequest.getFileNames();
		
		String uploader = multipartRequest.getParameter("uploader");
		
		if (files.hasMoreElements()) { 
			
			String element = (String)files.nextElement();  	   			 
			String originalFileName = multipartRequest.getOriginalFileName(element); 
			 
			System.out.println("uploader : " + uploader);
			System.out.println("originalFileName : " + originalFileName );
			System.out.println();
			
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
