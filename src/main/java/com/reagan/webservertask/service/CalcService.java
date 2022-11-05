package com.reagan.webservertask.service;

import com.reagan.webservertask.enums.Operation;

public interface CalcService {

    Integer add(int x, int y);

    Integer multiply(int x, int y);

    Integer  subtract(int x, int y);

    Integer getResult();
    void checkType(String input);
    void checkInt(String input);
}
