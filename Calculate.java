import java.util.Scanner;

public class Calculate {
    public Calculate() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение");
        String string = sc.nextLine();

        try {
            String result = calc(string);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

    public static String calc(String input) throws Exception {
        String[] tokens = input.trim().split(" ");
        if (tokens.length == 1) {
            throw new Exception("Неверный формат ввода. Строка не является математичесекой операцией. Введите два операнда и один оператор через пробел");
        } else if (tokens.length != 3) {
            throw new Exception("Неверный формат ввода. Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        } else {
            int num1 = Integer.parseInt(tokens[0]);
            String operator = tokens[1];
            int num2 = Integer.parseInt(tokens[2]);
            if (num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10) {
                int result;
                switch (operator) {
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "*" -> result = num1 * num2;
                    case "/" -> result = num1 / num2;
                    default -> throw new Exception("Неизвестный оператор. Используйте +, -, * или /.");
                }

                return String.valueOf(result);
            } else {
                throw new Exception("Числа должны быть в диапазоне от 1 до 10 включительно.");
            }
        }
    }
}