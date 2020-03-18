package domain;

import domain.card.Card;
import domain.card.Cards;

import java.util.List;

public class CardCalculator {
    private static final int BLACK_JACK = 21;
    private static final int SUM_CONTAIN_ACE = 10;
    private static final int DEALER_STANDARD_ADDITIONAL_CARD = 16;

    private CardCalculator() {
    }

    public static int calculateAceStrategy(Cards cards) {
        if (cards == null) {
            throw new NullPointerException("입력한 카드가 없습니다.");
        }

        int playerCardsSum = calculateCards(cards.getCards());
        if (cards.containAce() && isPlayerCardsSumWithAceStrategyUnderBlackJack(playerCardsSum)) {
            playerCardsSum += SUM_CONTAIN_ACE;
        }
        return playerCardsSum;
    }

    private static boolean isPlayerCardsSumWithAceStrategyUnderBlackJack(int playerCardsSum) {
        return playerCardsSum + SUM_CONTAIN_ACE <= BLACK_JACK;
    }

    private static int calculateCards(List<Card> cards) {
        return (int) cards.stream()
                .mapToLong(Card::getCardNumber)
                .sum();
    }

    public static boolean isPlayerCardsSumOverDealerCardsSum(Cards playerCards, Cards dealerCards) {
        if (playerCards == null || dealerCards == null) {
            throw new NullPointerException("유저 또는 딜러의 카드를 입력하지 않았습니다.");
        }

        int playerCardsSum = calculateAceStrategy(playerCards);
        int dealerCardsSum = calculateAceStrategy(dealerCards);

        if (playerCardsSum <= BLACK_JACK && dealerCardsSum > BLACK_JACK) {
            return true;
        }
        if (playerCardsSum > BLACK_JACK) {
            return false;
        }
        return playerCardsSum >= dealerCardsSum;
    }

    public static boolean isCardsSumBlackJack(Cards cards) {
        return calculateAceStrategy(cards) == BLACK_JACK;
    }

    public static boolean isPlayerCardSumUnderBlackJack(Cards playerCards) {
        return calculateAceStrategy(playerCards) <= BLACK_JACK;
    }

    public static boolean isDealerCardsSumUnderSixteen(Cards dealerCards) {
        return calculateAceStrategy(dealerCards) <= DEALER_STANDARD_ADDITIONAL_CARD;
    }
}
