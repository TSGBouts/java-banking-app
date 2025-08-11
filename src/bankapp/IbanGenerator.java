package bankapp;

import java.math.BigInteger;
import java.security.SecureRandom;

public class IbanGenerator implements IbanGeneratable {
    private static final SecureRandom rnd = new SecureRandom();
    // Official Greek bank codes (ISO 9362 BBAN prefixes)
    private static final String[] GREEK_BANK_CODES = {
            "011", // National Bank of Greece
            "014", // Alpha Bank
            "017", // Eurobank
            "018", // Piraeus Bank
            "019"  // Attica Bank
    };

    @Override
    public String generateGreekIban() {
        // 1) select a valid bank code
        String bankCode = GREEK_BANK_CODES[rnd.nextInt(GREEK_BANK_CODES.length)];
        // 2) generate a 4-digit branch code (0001–9999)
        String branchCode = String.format("%04d", rnd.nextInt(10_000));
        // 3) build a 16-digit random account number
        StringBuilder acc = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            acc.append(rnd.nextInt(10));
        }
        // 4) assemble BBAN and compute check digits
        String bban  = bankCode + branchCode + acc;
        String check = computeCheckDigits(bban);
        return "GR" + check + bban;
    }

    private String computeCheckDigits(String bban) {
        // ISO 7064 MOD 97-10: move country code numeric + "00" to end
        String reform = bban + toNumeric() + "00";
        BigInteger num = new BigInteger(reform);
        int mod97      = num.mod(BigInteger.valueOf(97)).intValue();
        int checkValue = 98 - mod97;
        return String.format("%02d", checkValue);
    }

    private String toNumeric() {
        StringBuilder sb = new StringBuilder();
        for (char c : "GR".toCharArray()) {
            sb.append(Character.getNumericValue(c));
        }
        return sb.toString();
    }
}