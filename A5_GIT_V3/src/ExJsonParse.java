import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExJsonParse {


    public static ExAutResponse parseAutResponse(String st) {

        ExAutResponse autResponse = null;
        boolean success = false;
        int sessionId = 0;
        int userId = 0;
        String comment = null;

        try {
            JSONObject jsonObject = new JSONObject(st);
            if (jsonObject.has("success")) {
                success = jsonObject.getBoolean("success");
            }
            if (jsonObject.has("sessionId")) {
                sessionId = jsonObject.getInt("sessionId");
            }
            if (jsonObject.has("userId")) {
                userId = jsonObject.getInt("userId");
            }
            if (jsonObject.has("comment")) {
                comment = jsonObject.getString("comment");
            }

            autResponse = new ExAutResponse(comment,userId,sessionId,success);

        } catch (JSONException e) {
            // It is important to always wrap JSON parsing in try/catch
            // If the string is suddently not in the expected format,
            // an exception will be generated
            System.out.println("Got exception in JSON parsing: " + e.getMessage());
        }
        System.out.println("");

        return autResponse;
    }

    public static ExTask parseTask(String st) {

        ExTask task = null;
        int taskNr = -1;
        String description = null;
        JSONArray arguments = null;

        try {
            JSONObject jsonObject = new JSONObject(st);
            if (jsonObject.has("taskNr")) {
                taskNr = jsonObject.getInt("taskNr");
            }
            if (jsonObject.has("description")) {
                description = jsonObject.getString("description");
            }
            if (jsonObject.has("arguments")) {
                arguments = jsonObject.getJSONArray("arguments");
            }

            task = new ExTask(taskNr,description,arguments);

        } catch (JSONException e) {
            // It is important to always wrap JSON parsing in try/catch
            // If the string is suddently not in the expected format,
            // an exception will be generated
            System.out.println("Got exception in JSON parsing: " + e.getMessage());
        }
        System.out.println("");

        return task;
    }


    public static ExTaskResponse parseTaskResponse(String st) {

        ExTaskResponse taskResponse = null;
        boolean success = false;
        String comment = null;

        try {
            JSONObject jsonObject = new JSONObject(st);
            if (jsonObject.has("success")) {
                success = jsonObject.getBoolean("success");
            }
            if (jsonObject.has("comment")) {
                comment = jsonObject.getString("comment");
            }


            taskResponse = new ExTaskResponse(success,comment);

        } catch (JSONException e) {
            // It is important to always wrap JSON parsing in try/catch
            // If the string is suddently not in the expected format,
            // an exception will be generated
            System.out.println("Got exception in JSON parsing: " + e.getMessage());
        }
        System.out.println("");

        return taskResponse;
    }

    public static ExResult parseResult(String st) {

        ExResult result = null;
        String name = null;
        int totalResult = -1;
        boolean passed = false;
        JSONArray results = null;

        try {
            JSONObject jsonObject = new JSONObject(st);
            if (jsonObject.has("student")) {
                name = jsonObject.getString("student");
            }
            if (jsonObject.has("totalResult")) {
                totalResult = jsonObject.getInt("totalResult");
            }
            if (jsonObject.has("passed")) {
                passed = jsonObject.getBoolean("passed");
            }

            if (jsonObject.has("results")) {
                results = jsonObject.getJSONArray("results");
            }


            result = new ExResult(name, totalResult, passed, results);

        } catch (JSONException e) {
            // It is important to always wrap JSON parsing in try/catch
            // If the string is suddently not in the expected format,
            // an exception will be generated
            System.out.println("Got exception in JSON parsing: " + e.getMessage());
        }
        System.out.println("");

        return result;
    }


}
