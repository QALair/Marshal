package jaxb.board.trello;

import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Card;
import com.julienvey.trello.domain.TList;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Configuration
@Data
public class TrelloService {
    private Date data;
    @Value("${trelloUrl:https://api.trello.com}")
    private String trelloUrl;

    public static final String APIKEY = System.getenv("APIKEY");
    public static final String APITOKEN = System.getenv("APITOKEN");

    Trello trelloApi = new TrelloImpl(APIKEY, APITOKEN, new ApacheHttpClient());

    List<TList> lists = trelloApi.getBoardLists("62cffc97235c3941901bc5d9");

    public List<TList> getLists() {
        return lists;
    }

    public void setLists(List<TList> lists) {
        this.lists = lists;
    }

    public void moveCardToAnotherList(String cardId, String listId){
        Card card = new Card();
        card.setId(cardId);
        card.setIdList(listId);
        trelloApi.updateCard(card);
    }

}
