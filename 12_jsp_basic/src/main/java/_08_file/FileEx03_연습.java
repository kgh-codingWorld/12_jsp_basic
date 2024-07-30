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

@WebServlet("/fileEx03_연습")
public class FileEx03_연습 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("chapter08_file/fileEx_문제/fileEx03_연습.jsp"); 
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String saveDirectory = FileConfig.FILE_REPOSITORY_PATH; // 파일 저장 디렉토리 경로를 설정

	    MultipartRequest mr = new MultipartRequest(request, saveDirectory, 1024 * 1024 * 300, "utf-8"); // MultipartRequest 객체를 생성하여 파일 업로드를 처리
	    
	    Enumeration<?> files = mr.getFileNames(); // 업로드된 파일들의 이름을 Enumeration 타입으로 가져옴

	    while (files.hasMoreElements()) { // 업로드된 파일들에 대해 반복 처리 시작

	        String element = (String) files.nextElement(); // 현재 처리할 파일의 이름을 가져옴
	        
	        if(mr.getOriginalFileName(element) != null) { // 업로드된 원본 파일 이름이 존재하는지 확인

	            // 원본 파일 이름을 가져옴
	            String originalFileName = mr.getOriginalFileName(element);
	            
	            // 파일 확장자 추출
	            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
	            
	            // UUID를 생성하여 파일 이름에 확장자를 붙여 새로운 파일 이름 생성
	            String fileUUID = UUID.randomUUID() + extension;

	            // 원본 파일 객체 생성
	            File originalFile = new File(saveDirectory + originalFileName);
	            
	            // 새 파일 이름으로 파일 객체 생성
	            File renameFile = new File(saveDirectory + fileUUID);
	            
	            // 원본 파일의 이름을 새 파일 이름으로 변경
	            originalFile.renameTo(renameFile);

	            System.out.println("originalFileName : " + originalFileName);
	            System.out.println("fileUUID : " + fileUUID);
	            System.out.println();
	        }

	        String jsScript = """
	                <script>
	                    alert('파일을 업로드 하였습니다.');
	                    location.href = 'fileMain';
	                </script>
	                """;
	        
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.print(jsScript);
	    }
	}


}
