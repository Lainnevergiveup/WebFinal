package beans;

public class Question {
    private Integer id;
    private String cid;
    private String sid;
    private String title;
    private String question;
    private String answer;
    private String state;

    public Question(int id, String cid, String sid, String title, String question, String answer, String state) {
        this.id = id;
        this.cid = cid;
        this.sid = sid;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.state = state;
    }

    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", cid='" + cid + '\'' +
                ", sid='" + sid + '\'' +
                ", title='" + title + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
