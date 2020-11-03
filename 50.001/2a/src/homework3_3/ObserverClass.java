package homework3_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObserverClass {
    interface Observer{
        void update(double airPollutionIndex);
    }

    static class Subscriber implements Observer{
        private Subject subject;
        private String observerId;
        public static String outputMessage = "";

        public Subscriber(String observerId, Subject subject){
            this.subject=subject;
            this.observerId = observerId;
            this.subject.register(this);		// register itself
        }

        @Override
        public void update(double airPollutionIndex) {
            String s = this.observerId + " received notification: " + airPollutionIndex;
            System.out.println(s);
            outputMessage += (s + " ");
        }
    }

    interface Subject{
        void register(Observer o);
        void unregister(Observer o);
        void notifyObservers();
    }
//-------------------------------------------------------

    //TODO: modify AirPollutionAlert to implement interface Subject, under Observer design pattern
    static class AirPollutionAlert implements Subject{
        private double airPollutionIndex;
        private List<Observer> observers = new ArrayList<>();

        public void setAirPollutionIndex(double airPollutionIndex) {
            this.airPollutionIndex = airPollutionIndex;
            if (airPollutionIndex > 100)
                notifyObservers();
        }

        @Override
        public void register(Observer o) {
            observers.add(o);
        }

        @Override
        public void unregister(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer o: observers)
                o.update(airPollutionIndex);
        }
    }

    public static void main(String[] args) {
        AirPollutionAlert singaporeAlert = new AirPollutionAlert();
        Subscriber man = new Subscriber("man", singaporeAlert);
        Subscriber simon = new Subscriber("simon", singaporeAlert);

        singaporeAlert.register(man);
        singaporeAlert.register(simon);

        singaporeAlert.setAirPollutionIndex(200);
        singaporeAlert.setAirPollutionIndex(50);
        singaporeAlert.setAirPollutionIndex(120);

        singaporeAlert.unregister(man);
        singaporeAlert.setAirPollutionIndex(300);
    }
}
