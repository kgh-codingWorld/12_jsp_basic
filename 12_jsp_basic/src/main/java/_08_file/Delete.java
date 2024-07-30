package _08_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String deleteFileName = request.getParameter("deleteFileName");
		
		File deleteFile = new File(FileConfig.FILE_REPOSITORY_PATH + deleteFileName);
		
		String jsScript = "";
		if (deleteFile.exists()) { // 파일이 존재하면
			deleteFile.delete(); // 파일삭제
			
			jsScript = """
					<script>
						alert('삭제 되었습니다.');
						location.href = 'fileMain';
					</script>""";
			
		}
		else {
			jsScript = """
					<script>
						alert('존재하지 않는 파일입니다.');
						history.go(-1);
					</script>""";
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
		out.print(jsScript);
		
	}

}
