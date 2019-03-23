import org.json.JSONArray;

public class ExTask {

    private int taskNr;
    private String description;
    private JSONArray arguments;

    public ExTask(int taskNr, String description, JSONArray arguments)
    {
        this.setTaskNr(taskNr);
        this.setDescription(description);
        this.setArguments(arguments);
    }


    public int getTaskNr() {
        return taskNr;
    }

    public void setTaskNr(int taskNr) {
        this.taskNr = taskNr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JSONArray getArguments() {
        return arguments;
    }

    public void setArguments(JSONArray arguments) {
        this.arguments = arguments;
    }

    public String toString() {
        String st = null;
        st = "TaskNr: " + taskNr + ",  Description: " + description + ", Arguments: " + arguments;
        return st;
    }
}
