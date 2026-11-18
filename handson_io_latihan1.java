enum AccountType {
    SAVINGS("Akun Tabungan"),
    CREDIT("Akun Kredit"),
    DEPOSIT("Akun Deposito");

    private final String deskripsi;
    AccountType(String deskripsi) { this.deskripsi = deskripsi; }

    @Override
    public String toString() { return deskripsi; }
}

class Account {
    private AccountType type;
    public Account(AccountType type) { this.type = type; }
    public AccountType getType() { return type; }
}

class Main {
    public static void main(String[] args) {
        for (AccountType t : AccountType.values()) {
            System.out.println(t.name() + " -> " + t);
        }
        Account a = new Account(AccountType.DEPOSIT);
        System.out.println("Tipe akun: " + a.getType());
    }
}
