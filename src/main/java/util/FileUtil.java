package util;
/**
 * 
* FileUtil.java
*
* @author Y.S.W
* @since 2018. 5. 10.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 5. 10. Y.S.W 최초 생성
*
* </pre>
 */
public class FileUtil {
	public static String getFileName(String contentDisposition) {
		//"form-data; name=\"profile\"; filename=\"Chrysanthemum.jpg\"";
		String fileName = null;
		String[] headers = contentDisposition.split(";");
		
		for (String header : headers) {
			if (header.contains("filename=")) {
				fileName = header.substring(" filename=".length()+1, header.length()-1);
				break;
			}
		}
//		filename=[\w]*$
		return fileName;
	}

}
