import org.json.JSONArray;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;


public class ExMain {

    static String pathPostAut = "dkrest/auth";
    static String pathPostTask = "dkrest/solve";
    static String email = "@stud.ntnu.no";
    static String phoneNumber = "phone";
    static String host = "104.248.47.74";
    static int port = 80;

    public static void main(String[] args) {

        JSONObject authorize = new JSONObject();
        authorize.put("email", email);
        authorize.put("phone", phoneNumber);

        ExPost post = new ExPost(host, port);
        String autRespons = post.sendPost(pathPostAut, authorize);
        ExAutResponse autResponse = ExJsonParse.parseAutResponse(autRespons);
        //Display the response from the server:
        System.out.println(autResponse);

        // http://104.248.47.74/dkrest/gettask/<taskNr>?sessionId=<sessionId>

        ExGet get = new ExGet(host, port);
        ExPost postTask = new ExPost(host, port);
        ExTask task1 = null;
        if (autResponse.isSuccess()) {
            int taskNr = 1;
            String pathTask = "dkrest/gettask/" + taskNr + "?sessionId=" + autResponse.getSessionId();
            String task = get.sendGet(pathTask);
            task1 = ExJsonParse.parseTask(task);
            System.out.println(task1);
        }
        ExTaskResponse taskResponse1 = null;
        if (task1 != null) {
            JSONObject ans = new JSONObject();
            ans.put("sessionId", autResponse.getSessionId());
            ans.put("msg", "Hello");
            String taskPostResponse = postTask.sendPost(pathPostTask, ans);
            taskResponse1 = ExJsonParse.parseTaskResponse(taskPostResponse);
            System.out.println(taskResponse1);
        }

        ExTask task2 = null;
        if (taskResponse1.isSuccess()) {

            //Ask for task 2
            int taskNr = 2;
            String pathTask = "dkrest/gettask/" + taskNr + "?sessionId=" + autResponse.getSessionId();
            String taskString = get.sendGet(pathTask);
            task2 = ExJsonParse.parseTask(taskString);
            System.out.println(task2);
        }
        ExTaskResponse taskResponse2 = null;
        if (task2 != null) {
            //Respond to the task:
            JSONObject ans = new JSONObject();
            JSONArray arg = task2.getArguments();
            String receivedMessage = arg.getString(0);
            ans.put("sessionId", autResponse.getSessionId());
            ans.put("msg", receivedMessage);
            String taskPostResponse = postTask.sendPost(pathPostTask, ans);
            taskResponse2 = ExJsonParse.parseTaskResponse(taskPostResponse);
            System.out.println(taskResponse2);
        }

        //Get task 3 if task 2 was correct:
        ExTask task3 = null;
        if (taskResponse2.isSuccess()) {
            //Ask for task 3
            int taskNr = 3;
            String pathTask = "dkrest/gettask/" + taskNr + "?sessionId=" + autResponse.getSessionId();
            String taskString = get.sendGet(pathTask);
            task3 = ExJsonParse.parseTask(taskString);
            System.out.println(task3);

        }

        //Solve and respond to task 3:
        ExTaskResponse taskResponse3 = null;
        if (task3 != null) {
            //Solve the task:
            int sum = 1;
            int value = 0;
            for (int i = 0; i < task3.getArguments().length(); ++i) {
                value = task3.getArguments().getInt(i);
                sum = sum * value;
            }
            //Respond to the task:
            JSONObject ans = new JSONObject();
            ans.put("sessionId", autResponse.getSessionId());
            ans.put("result", sum);
            String taskPostResponse = postTask.sendPost(pathPostTask, ans);
            taskResponse3 = ExJsonParse.parseTaskResponse(taskPostResponse);
            System.out.println(taskResponse3);
        }

        //Get task 4 if task 3 was correct:
        ExTask task4 = null;
        if (taskResponse3.isSuccess()) {
            //Ask for task 4
            int taskNr = 4;
            String pathTask = "dkrest/gettask/" + taskNr + "?sessionId=" + autResponse.getSessionId();
            String taskString = get.sendGet(pathTask);
            task4 = ExJsonParse.parseTask(taskString);
            System.out.println(task4);
        }

        // Solve and respond to task 4:
        ExTaskResponse taskResponse4 = null;
        if (task4 != null) {
            String pinHash = task4.getArguments().getString(0);
            System.out.println();
            System.out.println(pinHash);

            //Crack the pin by comparing with given hash:
            boolean correct = false;
            String result = null;
            int i = 0;
            while (!correct && i < 9999) {
                try {
                    String pinString = Integer.toString(i);
                    result = PasswordMD5.hashMD5(pinString);
                } catch (NoSuchAlgorithmException e) {
                    System.out.println("error");
                }
                if (pinHash.equals(result)) {
                    correct = true;
                } else {
                    i++;
                }

            }

            //Respond to the task:
            JSONObject ans = new JSONObject();
            ans.put("sessionId", autResponse.getSessionId());
            ans.put("pin", i);
            String taskPostResponse = postTask.sendPost(pathPostTask, ans);
            taskResponse4 = ExJsonParse.parseTaskResponse(taskPostResponse);
            System.out.println(taskResponse4);
        }

/**
        //Get task 5 if task 4 was correct:
        ExTask task2016 = null;
        if (taskResponse4.isSuccess()) {
            //Ask for extra task:
            int taskNr = 2016;
            String pathTask = "dkrest/gettask/" + taskNr + "?sessionId=" + autResponse.getSessionId();
            String taskString = get.sendGet(pathTask);
            task2016 = ExJsonParse.parseTask(taskString);
            System.out.println(taskString);
            System.out.println(task2016);
        }


        // Solve and respond to task 5:

        ExTaskResponse taskResponse2016 = null;
        if (task2016 != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            String ip = task2016.getArguments().getString(0);
            String sub = task2016.getArguments().getString(1);
            System.out.println("Given ip from server:" + ip);
            System.out.println("Subnet: " + sub);

            String[] i = ip.split("\\.");


            int l = Integer.parseInt(i[3]);
            l++;

            //Add it back to the string:
            String ipResponse = i[0] + "." + i[1] + "." + i[2] + "." + l;
            System.out.println("IP response: " + ipResponse);


            //Respond to the task:

            JSONObject ans = new JSONObject();
            ans.put("sessionId", autResponse.getSessionId());
            ans.put("ip", ipResponse);

            String taskPostResponse = postTask.sendPost(pathPostTask, ans);
            taskResponse2016 = ExJsonParse.parseTaskResponse(taskPostResponse);
            System.out.println(taskResponse2016);
        }

**/
        // http://104.248.47.74/dkrest/results/5678
        // Ask for the reuslts:

        ExResult result = null;
        if (taskResponse4.isSuccess()) {

            //Ask for the result, call it task 5

            String pathResult = "dkrest/results/" + autResponse.getSessionId();
            String taskString = get.sendGet(pathResult);
            result = ExJsonParse.parseResult(taskString);
            System.out.println(result);


        }



    }}




