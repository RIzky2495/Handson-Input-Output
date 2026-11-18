enum AccountType {
    SAVINGS("SA", 0.03), CREDIT("CR", 0.18), DEPOSIT("DP", 0.05);

    private final String code;
    private final double interestRate;

    private AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }
    public String getCode() { return code; }
    public double getInterestRate() { return interestRate; }
}

class Main {
    public static void main(String[] args) {
        for (AccountType t : AccountType.values()) {
            System.out.printf("Nama: %-8s Kode: %s  Bunga: %.1f%%%n",
                t.name(), t.getCode(), t.getInterestRate() * 100);
        }
    }
}
