public class ExResult {

    private String name;
    private int totalResult;
    private boolean passed;
    private org.json.JSONArray results;



    public ExResult(String name, int totalResult, boolean passed, org.json.JSONArray results){

        this.setName(name);
        this.setTotalResult(totalResult);
        this.setPassed(passed);
        this.setResults(results);


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public org.json.JSONArray getResults() {
        return results;
    }

    public void setResults(org.json.JSONArray results) {
        this.results = results;
    }

    public String toString()
    {
        String st = "Name: " + name + "\n" + "TotalResult: " + totalResult + "\n" +
                "Passed: " + passed + "\n" + "Results: " + results;
        return st;
    }
}
