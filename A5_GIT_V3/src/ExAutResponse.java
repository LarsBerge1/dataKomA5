//Simple class to hold the autorize response from the server.


public class ExAutResponse {
    private String comment;
    private int userId;
    private int sessionId;
    private boolean success;


    public ExAutResponse(String comment, int userId, int sessionId, boolean success)
    {
        this.setComment(comment);
        this.setUserId(userId);
        this.setSessionId(sessionId);
        this.setSuccess(success);
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String toString()
    {
        String st = null;
        st = "Comment: " + comment + ",  UserId: " + userId + ", SessionId: " + sessionId +
                ", Success: " + success;
        return st;
    }
}
