package jaxb.board.trello;


import jaxb.domain.Argument;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrelloUrl {
    public static final String API_Url = "https://api.trello.com";
    public static final String APIKeyTokenParam = "key={applicationkey}&token={usertoken}";
    private String baseUrl;
    private Argument[] args = {};

    private TrelloUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static TrelloUrl createUrl(String baseUrl){
        return new TrelloUrl(baseUrl);
    }

    public static String createUrlWithNoArgs(String baseUrl) {
        return API_Url + baseUrl + APIKeyTokenParam;
    }

    public TrelloUrl params(Argument... args) {
        this.args = args;
        return this;
    }


    public String asString(){
        StringBuilder builder = new StringBuilder(API_Url);
        builder.append(baseUrl);
        builder.append(APIKeyTokenParam);

        for (Argument arg : args){
            builder.append("&");
            builder.append(arg.getArgName());
            builder.append("=");
            builder.append(arg.getArgValue());
        }
        return builder.toString();
    }

}
