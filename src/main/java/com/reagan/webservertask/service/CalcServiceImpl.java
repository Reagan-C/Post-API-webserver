package com.reagan.webservertask.service;


import com.reagan.webservertask.enums.Operation;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class CalcServiceImpl implements CalcService{
    //constants
    private  final String JSON_RESPONSE_STARTING = "{\n" ;
    private  final String SLACK_USERNAME = "\"slackUsername\": " + "\"Reagan\", ";
    private  final boolean BACKEND = true;
    private  final int AGE = 28;

    private  final String RESULT_STRING = "\"result\": ";
    private  final String OPERATION_TYPE_STRING = ", \"operation_type\": \"";


    private final String BIO = ", \"bio\": \"I am Reagan, a passionate junior backend engineer with java language" +
            " who has an eye for details\" \n";
    private  final String JSON_RESPONSE_ENDING = "}";
    private  final String RESPONSE =  JSON_RESPONSE_STARTING + SLACK_USERNAME + "\"backend\": " + BACKEND +
            ", \"age\": " + AGE + BIO + JSON_RESPONSE_ENDING;

    //fields
    private int x;
    private int y;

    private String operation_type;


    //methods
    @Override
    public Integer add(int x, int y) {
        return x + y;
    }

    @Override
    public Integer multiply(int x, int y) {
        return x * y;
    }

    @Override
    public Integer subtract(int x, int y) {
        return x - y;
    }

    @Override
    public Integer getResult() {
        int result = 0;
        checkType(operation_type);

        if (this.operation_type.toLowerCase().equals(Operation.ADDITION.getValue())){
            result += add(x,y);
        } else if (this.operation_type.toLowerCase().equals(Operation.SUBTRACTION.getValue())) {
            result += subtract(x,y);
        }else if(this.operation_type.toLowerCase().equals(Operation.MULTIPLICATION.getValue())){
            result += multiply(x,y);
        } else {
            setOperation_type(Operation.UNKNOWN.getValue());
        }
        return result;
    }

    //check if operator type contains an array of Strings and extract operation type and integers
    @Override
    public void checkType(String input) {
        List<String> keyword = List.of(input.toLowerCase().split(" "));

        if (keyword.isEmpty()) {
            operation_type = Operation.UNKNOWN.getValue();
        }else if (keyword.size() == 1) {
            operation_type = input;
        } else {
            checkInt(input);

            if (keyword.contains("add") || keyword.contains("plus") || keyword.contains("addition")) {
                operation_type = Operation.ADDITION.getValue();
            }
            if (keyword.contains("subtract") || keyword.contains("minus") || keyword.contains("difference")||
                    keyword.contains("subtraction") ){
                operation_type = Operation.SUBTRACTION.getValue();
            }
            if (keyword.contains("multiply") || keyword.contains("product") ||keyword.contains("multiplication")) {
                operation_type = Operation.MULTIPLICATION.getValue();
            }
        }
    }


    // check if operator type in string array format contains number
    @Override
    public void checkInt(String checkNumber) {
        List<String> arr = List.of(checkNumber.replace(".", "").split(" "));
        ArrayList<Integer> intArray = new ArrayList<>();
        for (String num : arr) {
            try {
                int number = Integer.parseInt(num);
                intArray.add(number);
            } catch (NumberFormatException e) {
                System.out.println("looping through operator string array...");
            }
        }
        if (intArray.size() == 2) {
            this.x = intArray.get(0);
            this.y = intArray.get(1);
        }
    }

}
