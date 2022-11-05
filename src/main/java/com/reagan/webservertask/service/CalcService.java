package com.reagan.webservertask.service;

public interface CalcService {

    Integer add(int x, int y);

    Integer multiply(int x, int y);

    Integer  subtract(int x, int y);

    Integer getResult();
    void checkType(String input);
    void checkInt(String input);
}
