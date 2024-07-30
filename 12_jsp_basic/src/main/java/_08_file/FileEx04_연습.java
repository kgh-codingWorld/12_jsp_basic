package _08_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/fileEx04_연습")
public class FileEx04_연습 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("chapter08_file/fileEx_문제/fileEx04_연습.jsp"); 
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String saveDirectory = FileConfig.FILE_REPOSITORY_PATH;
		
		MultipartRequest mr = new MultipartRequest(request, saveDirectory, 1024 * 1024 * 100, "utf-8");
		Enumeration<?> files = mr.getFileNames();
		
		while(files.hasMoreElements()) {
			
			String element = (String) files.nextElement();
			if(mr.getOriginalFileName(element) != null) {
				
				String originalFileName = mr.getOriginalFileName(element);
				String extension = originalFileName.substring(originalFileName.indexOf("."));
				String fileUUID = UUID.randomUUID() + extension;
				
				File originalFile = new File(saveDirectory + originalFileName);
				File renameFile = new File(saveDirectory + extension);
				originalFile.renameTo(renameFile);
				
				System.out.println("originalFileName : " + originalFileName );
				System.out.println("fileUUID : " + fileUUID );
				System.out.println();
			}
		}
		
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
