package stringliteral;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;


public class StringLiteral {
    public static void main(String[] args) {
        stringParse();
        stringConcat();
        callMethod();
        nestedProperty();
        constructor();
    }

    private static void stringParse() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();

        System.out.println(message);
    }

    private static void stringConcat() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();

        System.out.println(message);
    }

    private static void callMethod() {
        ExpressionParser parser = new SpelExpressionParser();
        // invokes 'getBytes()'
        Expression exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();

        System.out.println(bytes);
    }

    private static void nestedProperty() {
        ExpressionParser parser = new SpelExpressionParser();
        // invokes 'getBytes().length'
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();
        System.out.println(length);
    }

    private static void constructor() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);

        System.out.println(message);
    }


}
