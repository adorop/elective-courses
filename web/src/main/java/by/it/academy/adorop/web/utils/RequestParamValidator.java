package by.it.academy.adorop.web.utils;

public class RequestParamValidator {

    private RequestParamValidator() {
    }

    public static boolean isEmpty(String param) {
        return param == null || param.equals("");
    }

    public static boolean isPositiveNumber(String param) {
        return !isEmpty(param) && param.matches("[0-9]+");
    }

    public static boolean isNumeric(String parameter) {
        return !isEmpty(parameter) && parameter.matches("-?[0-9]+");
    }
}
