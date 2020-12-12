package koitt.ratta.doeat.domain;

public class ContentVOWrapper {
	
	public ContentVOWrapper(ContentVO content) {
		this.content = content;
	}
	
	private ContentVO content;
	
	/**
	 * HTML 내에서 제일 처음 img를 찾아서 경로+파일명을 반환
	 */
	public String getFirstImgFilePath() {
		
		String html = content.getContent();
		html = html.substring(html.indexOf("<img"));
		html = html.substring(html.indexOf("src=")+4);
		html = html.substring(0, html.indexOf(">"));
		
		return html;
	}
	
}
