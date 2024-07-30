package _08_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/update")
public class Update extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			// 1) 새로운 파일 업로드
			MultipartRequest mr = new MultipartRequest(request, FileConfig.FILE_REPOSITORY_PATH, 1024 * 1024 * 30, "utf-8");
			
			String deleteFileName = request.getParameter("deleteFileName");
			
			// 2) 기존 파일 삭제
			new File(FileConfig.FILE_REPOSITORY_PATH + deleteFileName).delete();
			
			// 1) + 2) = 수정기능 구현
			
			String jsScript = """
					<script>
						alert('수정 되었습니다.');
						location.href = 'fileMain';
					</script>""";

			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();	
			out.print(jsScript);
	}

}
