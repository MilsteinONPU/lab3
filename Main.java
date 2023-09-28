package ad221.milstein

public class Main {

    // Метод для перевірки закінчення рядка на "ed"
    public static boolean endsWithEd(String inputStr) {
        return inputStr.endsWith("ed");
    }

    // Метод для знаходження суми цифр у рядку
    public static int sumOfDigits(String inputStr) {
        int digitSum = 0;
        for (char c : inputStr.toCharArray()) {
            if (Character.isDigit(c)) {
                digitSum += Character.getNumericValue(c);
            }
        }
        return digitSum;
    }

    // Метод для знаходження довжини найдовшого блоку символів
    public static int longestBlockLength(String inputStr) {
        int maxBlockLength = 0;
        int currentBlockLength = 1; // Мінімальна довжина блоку - 1
        for (int i = 1; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == inputStr.charAt(i - 1)) {
                currentBlockLength++;
            } else {
                if (currentBlockLength > maxBlockLength) {
                    maxBlockLength = currentBlockLength;
                }
                currentBlockLength = 1;
            }
        }
        return Math.max(maxBlockLength, currentBlockLength); // Повертаємо максимальну довжину блоку
    }

    // Метод для виводу слів у рядку
    public static void printWords(String inputStr) {
        String[] words = inputStr.split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }
    }

    // Метод для створення рядка з чергових символів двох рядків
    public static String interleaveStrings(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            result.append(str1.charAt(i)).append(str2.charAt(i));
        }

        if (str1.length() > minLength) {
            result.append(str1.substring(minLength));
        } else if (str2.length() > minLength) {
            result.append(str2.substring(minLength));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Виклик методів з прикладами
        System.out.println("1. закінчується на ED(\"walked\"): " + endsWithEd("walked"));  // true
        System.out.println("2. сумаЦифр(\"abc123xyz\"): " + sumOfDigits("abc123xyz"));  // 6
        System.out.println("3. довжинанайдовшогБлоку(\"aaBCS\"): " + longestBlockLength("aaBCS"));  // 2
        System.out.println("4. ВивідСлів(\"Один Два Три.\"): ");
        printWords("Один Два Три.");
        
        System.out.println("5. interleaveStrings(\"abc\", \"12345\"): " + interleaveStrings("abc", "12345"));  // "a1b2c345"
    }
}
