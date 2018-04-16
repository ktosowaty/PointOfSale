package pointofsale.mocks;

import pointofsale.io.LCDDisplay;

public class LCDDisplayMock implements LCDDisplay {
    public void display(String str) {
        System.out.println("LCDDisplayMock: " + str);
    }
}
