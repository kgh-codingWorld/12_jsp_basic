package _08_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/upload2")
public class Upload2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파일을 저장할 디렉토리 설정
		//String saveDirectory = "C:\\Users\\15_web_kgh\\git\\12_jsp_basic\\12_jsp_basic\\src\\main\\webapp\\chapter08_file\\fileRepository\\"; // 끝에 \\ 확인 매우 중요
		String saveDirectory = FileConfig.FILE_REPOSITORY_PATH;
		
		// 파일 크기의 총합을 100MB로 설정하고 MultipartRequest 객체 생성
		MultipartRequest mr = new MultipartRequest(request, saveDirectory, 1024 * 1024 * 100, "utf-8");
		
		// 업로더 이름 가져오기
		String uploader = mr.getParameter("uploader");
		System.out.println("uploader : " + uploader);
		
		// 업로드된 파일 이름 목록 가져오기
		Enumeration<?> files = mr.getFileNames();
		
		while(files.hasMoreElements()) { // hasMoreElements() = next()
			
			// 다음 파일 이름 가져오기
			String element = (String) files.nextElement();
			
			// 원본 파일명이 있으면 > 파일을 업로드 했으면
			if(mr.getOriginalFileName(element) != null) {
				// 원본 파일 이름 가져오기
				String originalFileName = mr.getOriginalFileName(element);
				System.out.println("파일명 : " + originalFileName);
				
				// 고유 식별 번호(UUID) 생성
				UUID uuid = UUID.randomUUID(); // UUID.randomUUID(); 해쉬 생성 메서드
				System.out.println("고유식별번호 : " + uuid);
				
				// 확장자 추출
				String extention = originalFileName.substring(originalFileName.lastIndexOf("."));
				System.out.println("확장자 추출 : " + extention);
				
				// 업로드할 파일명 생성
				String uploadFileName = uuid + extention;
				System.out.println("업로드 파일명 : " + uploadFileName);
				System.out.println();
				
				// 파일명 수정
				File originalFile = new File(saveDirectory + originalFileName); // 기존에 업로드한 파일을 파일 객체로 변환
				File uploadFile = new File(saveDirectory + uploadFileName); 	// 변환된 파일명으로 새로운 파일 객체 생성
				originalFile.renameTo(uploadFile); 								// 기존에 업로드한 파일을 변환된 파일명으로 이름 변경
				
				
			}
			
			
			// 파일 업로드 완료 메시지 출력 및 페이지 이동
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

