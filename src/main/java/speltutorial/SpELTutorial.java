package speltutorial;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;


public class SpELTutorial {

    public static void main(String[] args) {
//        stringParse();
//         stringConcat();
//        callMethod();
//        nestedProperty();
//        constructor();
//        evaluateAgainstObject();
//        typeConversion();
        parserConfig();
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

    private static void evaluateAgainstObject() {
        TestBean testBean = new TestBean(20);

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("value");

        EvaluationContext context = new StandardEvaluationContext(testBean);
        System.out.println("With context: " + exp.getValue(context));

        System.out.println("Without context: " + exp.getValue(testBean));
    }

    private static void typeConversion() {
        class Simple {
            public List<Boolean> booleanList = new ArrayList<Boolean>();
        }

        Simple simple = new Simple();

        simple.booleanList.add(true);

        StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);
        ExpressionParser parser = new SpelExpressionParser();

    // false is passed in here as a string. SpEL and the conversion service will
    // correctly recognize that it needs to be a Boolean and convert it
        Expression expression = parser.parseExpression("booleanList[0]");
        expression.setValue(simpleContext, "false");

    // b will be false
        Boolean b = simple.booleanList.get(0);
        System.out.println(b);
    }

    private static void parserConfig(){
        class Demo {
            public List<String> list = new ArrayList<String>();
        }

        // Turn on:
        // - auto null reference initialization
        // - auto collection growing
        SpelParserConfiguration config = new SpelParserConfiguration(true,true);

        ExpressionParser parser = new SpelExpressionParser(config);

        Expression expression = parser.parseExpression("list[3]");

        Demo demo = new Demo();

        System.out.println(demo.list.size());
        System.out.println("list[3] érték: " + expression.getValue(demo));
        System.out.println(demo.list.size());

        // demo.list will now be a real collection of 4 entries
        // Each entry is a new empty String
    }


}
