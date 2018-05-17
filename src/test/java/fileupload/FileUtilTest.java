package fileupload;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.FileUtil;
/**
 * 
* FileUploadServletTest.java
*
* @author Y.S.W
* @since 2018. 5. 9.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
* 이름변경
* FileUtilTest
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 5. 9. Y.S.W 최초 생성
*
* </pre>
 */
public class FileUtilTest {

	@Before
	public void setUp() throws Exception {
	}
/**
 * 
* Method : getFileNameTest
* 최초작성일 : 2018. 5. 16.
* 작성자 : "Y.S.W"
* 변경이력 :
* Method 설명 :Content-disposition 헤더에서 파일명 추출
 */
	@Test
	public void getFileNameTest() {
		/***Given***/
		String ContentDisposition = "form-data; name=\"attach_file_name\"; filename=\"Chrysanthemum.jpg\"";

		/***When***/
		String fileName = FileUtil.getFileName(ContentDisposition);
		
		/***Then***/
		assertEquals("Chrysanthemum.jpg", fileName);
	}

}
