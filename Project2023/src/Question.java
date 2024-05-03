
public class Question {
	private String Qid;
    private String Qcontent;
    private String points;
    private Answer answer;
    
    public Question(String Qid, String Qcontent ,String points) {
        this.Qid = Qid;
        this.Qcontent = Qcontent;
        this.points = points;
    }
    
    public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getQid() {
        return Qid;
    }
    
    public void setQid(String Qid) {
        this.Qid = Qid;
    }
    
    public String getQcontent() {
        return Qcontent;
    }
    
    public void setQcontent(String Qcontent) {
        this.Qcontent = Qcontent;
    }
    
    public void setAnswer(Answer answer) {
		this.answer = answer;
    }
    
    public Answer getAnswer() {
    	return this.answer;
    }
    

}
