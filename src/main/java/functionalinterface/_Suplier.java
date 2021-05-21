package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Suplier {
    public static void main(String[] args) {
        System.out.println(getDbConnectionUrl());
        System.out.println(getDbConnectionUrlSupplier.get());
    }

    static String getDbConnectionUrl(){
        return "jdbc://localhost:5432/users";
    }

    static Supplier<List<String>> getDbConnectionUrlSupplier = () ->
            List.of("jdbc://localhost:5432/users",
                    "jdbc://localhost:5432/customers");
}
