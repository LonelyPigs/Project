package homework.h9.jdbc;

public class TestMain {
    public static void main(String[] args) {
        //测试
        StudentOperator so = new StudentOperator();
        //so.findByIdLike("2002%").forEach(System.out::println);
        //so.findOrderByField("sdept").forEach(System.out::println);
        so.findByIdLikeOrderLimit("2002%", 2, 2).forEach(System.out::println);
    }
}
