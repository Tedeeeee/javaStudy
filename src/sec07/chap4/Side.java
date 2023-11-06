package src.sec07.chap4;

public enum Side {
    RED("레드"), BLUE("블루");
    private String name;

    Side(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
