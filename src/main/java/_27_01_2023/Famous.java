package _27_01_2023;

public class Famous {
    Famous getFamous(Famous[] famous) {
        Famous f = null;
        int first = 0;
        int last = famous.length - 1;

        while (first != last) {
            if(famous[first].knows(famous[last])) {
                first++;
            } else {
                last--;
            }
        }

        for (int i = 0; i < famous.length; i++) {
            if(i != first && (famous[i].knows(famous[first]) || famous[first].knows(famous[i]))) {
                f = null;
            }
            f = famous[first];
        }
        return f;
    }

    private boolean knows(Famous famous) {
        return false;
    }
}
