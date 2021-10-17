import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String[] str = scanner.nextLine().split(" ");

            if (!CheckString.Check(str)) {
                break;
            }

            if (CheckString.checkRim(str)) {
                if (CheckString.checkRimDiapason(str[0]) && CheckString.checkRimDiapason(str[2])) {
                    int a = RimEnum.toArab(str[0]);
                    int b = RimEnum.toArab(str[2]);
                    int result = Calculation.count(a, b, str[1]);
                    if (result <= 0) {
                        System.out.println("В римской системе нет отрицательных чисел");
                        break;
                    }
                    System.out.println(RimEnum.toRim(result));
                } else {
                    System.out.println("Числа выходят за допустимый диапазон");
                    break;
                }
            } else
            if (CheckString.checkArab(str)) {
                if (CheckString.checkArabDiapason(str[0]) && CheckString.checkArabDiapason(str[2])) {
                    int a = Integer.parseInt(str[0]);
                    int b = Integer.parseInt(str[2]);
                    int result = Calculation.count(a, b, str[1]);
                    System.out.println(result);
                } else {
                    System.out.println("Числа выходят за допустимый диапазон");
                    break;
                }
            } else {
                System.out.println("Хреновый формат числа");
                break;
            }
        }
    }
}
