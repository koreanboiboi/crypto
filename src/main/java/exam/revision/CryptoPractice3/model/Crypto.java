package exam.revision.CryptoPractice3.model;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Crypto {

    private String USD;
    private String JPY;
    private String SGD;

    public String getUSD() {
        return USD;
    }
    public void setUSD(String uSD) {
        USD = uSD;
    }
    public String getJPY() {
        return JPY;
    }
    public void setJPY(String jPY) {
        JPY = jPY;
    }
    public String getSGD() {
        return SGD;
    }
    public void setSGD(String sGD) {
        SGD = sGD;
    }

    public static Crypto create(JsonObject jo){
        Crypto c = new Crypto();
        c.setJPY(jo.getString("JPY"));
        c.setSGD(jo.getString("SGD"));
        c.setUSD(jo.getString("USD"));

        return c;
    }

    public JsonObject toJson(){

        return Json.createObjectBuilder()
                    .add("JPY", JPY)
                    .add("SGD", SGD)
                    .add("USD", USD)
                    .build();

    }
    
}
