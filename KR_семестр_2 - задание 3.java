import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String referenceText = "Являясь всего лишь частью общей картины, ключевые особенности структуры проекта набирают популярность среди определенных слоев населения, а значит, должны быть разоблачены. Однозначно, интерактивные прототипы призывают нас к новым свершениям, которые, в свою очередь, должны быть заблокированы в рамках своих собственных рациональных ограничений. Равным образом, существующая теория способствует повышению качества переосмысления внешнеэкономических политик. Предварительные выводы неутешительны: сложившаяся структура организации играет важную роль в формировании приоретизации разума над эмоциями. Приятно, граждане, наблюдать, как непосредственные участники технического прогресса лишь добавляют фракционных разногласий и представлены в исключительно положительном свете. Задача организации, в особенности же внедрение современных методик в значительной степени обусловливает важность дальнейших направлений развития. С другой стороны, консультация с широким активом создаёт необходимость включения в производственный план целого ряда внеочередных мероприятий с учётом комплекса укрепления моральных ценностей.";

        Map<Character, Double> referenceFreq = buildNormalizedFrequencyMap(referenceText);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите зашифрованный текст:");
        String encryptedText = scanner.nextLine().toLowerCase();
        scanner.close();

        Map<Character, Double> encryptedFreq = buildNormalizedFrequencyMap(encryptedText);

        int bestShift = findBestShift(referenceFreq, encryptedFreq);

        String decryptedText = decrypt(encryptedText, bestShift);
        System.out.println("Расшифрованный текст:");
        System.out.println(decryptedText);
    }

    private static Map<Character, Double> buildNormalizedFrequencyMap(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        int total = 0;
        for (char c : text.toCharArray()) {
            if (isRussianLetter(c)) {
                char lowerC = Character.toLowerCase(c);
                counts.put(lowerC, counts.getOrDefault(lowerC, 0) + 1);
                total++;
            }
        }
        Map<Character, Double> normalized = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            normalized.put(entry.getKey(), (double) entry.getValue() / total);
        }
        return normalized;
    }

    private static boolean isRussianLetter(char c) {
        return (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я');
    }

    private static int findBestShift(Map<Character, Double> referenceFreq, Map<Character, Double> encryptedFreq) {
        int bestShift = 0;
        double bestScore = Double.NEGATIVE_INFINITY;

        for (int shift = 0; shift < 33; shift++) {
            double currentScore = 0.0;
            for (Map.Entry<Character, Double> entry : encryptedFreq.entrySet()) {
                char encryptedChar = entry.getKey();
                double encryptedFrequency = entry.getValue();
                char decryptedChar = shiftChar(encryptedChar, shift);
                double referenceFrequency = referenceFreq.getOrDefault(decryptedChar, 0.0);
                currentScore += encryptedFrequency * referenceFrequency;
            }
            if (currentScore > bestScore) {
                bestScore = currentScore;
                bestShift = shift;
            }
        }
        return bestShift;
    }

    private static char shiftChar(char c, int shift) {
        if (!isRussianLetter(c)) return c;
        c = Character.toLowerCase(c);
        int code = (c - 'а' - shift + 33) % 33;
        return (char) (code + 'а');
    }

    private static String decrypt(String encryptedText, int shift) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            decrypted.append(shiftChar(c, shift));
        }
        return decrypted.toString();
    }
}