package speltutorial;

public class TestBean {
    private Integer value;

    public TestBean(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        System.out.println("Getter called!");
        return value;
    }

}
