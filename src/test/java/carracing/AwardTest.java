package carracing;

import carracing.domain.Award;
import carracing.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AwardTest {
    private List<Car> cars;

    @BeforeEach
    void createCars() {
        cars = new ArrayList<>();
        cars.add(new Car("kim", 4));
        cars.add(new Car("woo", 2));
        cars.add(new Car("hun", 3));
        cars.add(new Car("lee", 4));
    }

    @Test
    @DisplayName("자동차 순위 내림차순 정렬 테스트")
    void carSortRanking() {
        Award.sortRanking(cars);

        String[] carNames = new String[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            carNames[i] = cars.get(i).getName();
        }
        assertThat(carNames).containsExactly("kim", "lee", "hun", "woo");
    }

    @Test
    @DisplayName("우승한 자동차들 이름 확인 테스트")
    void getWinnerNames() {
        String winnerNames = Award.getWinnerNames(cars);

        assertThat(winnerNames).isEqualTo("kim, lee");
    }

    @Test
    @DisplayName("자동차가 우승한 자동차인지 확인")
    void getWinnerName() {
        int winnerLocation = 4;
        String winners = Award.getWinnerName(cars.get(3), winnerLocation);
        assertThat(winners).isEqualTo("lee");
    }
}
