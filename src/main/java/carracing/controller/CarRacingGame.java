package carracing.controller;

import carracing.domain.Car;
import carracing.domain.CarCompany;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.List;

import static carracing.domain.Race.moveCars;

public class CarRacingGame {
    public static void main(String[] args) {
        //자동차 대수 및 이동 횟수 입력
        InputView inputView = new InputView();
        int carNum = inputView.inputCarNum();
        int moveNum = inputView.inputMoveNum();

        //입력 대수만큼 자동차 객체 생성
        CarCompany carCompany = new CarCompany();
        List<Car> cars = carCompany.createCar(carNum);

        ResultView resultView = new ResultView();
        //실행결과 텍스트 출력
        resultView.resultStart();

        for (int i = 0; i < moveNum; i++) {
            //자동차 이동
            cars = moveCars(cars);
            //출력
            resultView.outputResult(cars);
        }
    }
}