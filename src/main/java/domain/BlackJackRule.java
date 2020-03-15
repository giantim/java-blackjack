package domain;

import domain.card.Card;
import domain.player.Player;
import domain.player.User;

public class BlackJackRule {
    private static final int BLACK_JACK = 21;

    public boolean isHit(User user, Answer answer) {
        if (user.isBlackJack() || user.sumCardNumber() > BLACK_JACK) {
            return false;
        }
        return answer.isYes();
    }

    public void hit(Player player, Card card) {
        player.hitCard(card);
    }
}
