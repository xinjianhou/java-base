package enums;

public enum Country {

    ONE(1, "齐国"), TWO(2, "楚国"), THREE(3, "燕国"), FOUR(4, "韩国"), FIVE(5, "赵国"), SIX(6, "卫国");

    private Integer code;

    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    Country(int i, String s) {
        this.code = i;
        this.name = s;
    }

    public static Country getByCode(int code) {
        Country[] array = Country.values();
        for (Country c : array) {
            if (c.getCode() == code) {
                return c;
            }

        }
        return null;
    }
}
