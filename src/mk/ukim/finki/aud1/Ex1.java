package mk.ukim.finki.aud1;

public class Ex1 {
    public static void main(String[] args) {
        for (int a = 1; a < 1000; ++a)
            for (int b = a + 1; b < 1000; ++b)
                if ((a * a + b * b + 1) % (a * b) == 0)
                    System.out.printf("%d %d \n", a, b);
    }
}
