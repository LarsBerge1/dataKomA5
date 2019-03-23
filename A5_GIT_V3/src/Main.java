


public class Main {
    public static void main(String[] args) {

        String path = "dkrest/test/get2";

        httpGET example = new httpGET("104.248.47.74", 80);
        String respons = example.sendGet(path);
        JSONParseLars parser = new JSONParseLars();
        parser.josonParsing(respons);





    }
}
