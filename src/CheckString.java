public class CheckString {
    public static boolean Check(String[] str) {
        if (str.length < 3) {
            System.out.println("Строка не является математической операцией");
            return false;
        }
        if (str.length > 3) {
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            return false;
        }
        if ((RimEnum.isContains(str[0]) && !RimEnum.isContains(str[2])) || (!RimEnum.isContains(str[0]) && RimEnum.isContains(str[2]))) {
            System.out.println("Используются одновременно разные системы счисления");
            return false;
        }
        return true;
    }

    public static boolean checkRim(String[] str) {
        return RimEnum.isContains(str[0]) && RimEnum.isContains(str[2]);
    }

    public static boolean checkArab(String[] str) {
        return isDigit(str[0]) && isDigit(str[2]);
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkArabDiapason(String i) {
        for (int j = 1; j <= 10; j++) {
            if (j == Integer.parseInt(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRimDiapason(String i) {
        for (int j = 1; j <= 10; j++) {
            if (j == RimEnum.toArab(i)) {
                return true;
            }
        }
        return false;
    }
}