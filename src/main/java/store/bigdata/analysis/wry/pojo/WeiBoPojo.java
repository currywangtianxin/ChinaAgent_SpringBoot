package store.bigdata.analysis.wry.pojo;

public class WeiBoPojo {
	private String source;
	private int score;
	@Override
	public String toString() {
		return "WeiBoPojo [source=" + source + ", score=" + score + "]";
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public WeiBoPojo(String source, int score) {
		super();
		this.source = source;
		this.score = score;
	}
	public WeiBoPojo() {
		super();
	}
	
}
