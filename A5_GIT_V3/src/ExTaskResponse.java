public class ExTaskResponse {

    private boolean success;
    private String comment;

    public ExTaskResponse(boolean success, String comment)
    {
        this.setComment(comment);
        this.setSuccess(success);
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString()
    {
        return  "Success: " + success + " Comment: " + comment;
    }
}
