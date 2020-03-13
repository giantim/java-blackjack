package domain.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Dealer getDealer() {
        return (Dealer) players.stream()
                .filter(player -> player instanceof Dealer)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("딜러가 포함되어 있지 않습니다."));
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(players.stream()
                .filter(player -> player instanceof User)
                .map(player -> (User) player)
                .collect(Collectors.toList()));
    }
}
