package ru.aston.hometask.third.chainOfResponsibilities.barista;

import ru.aston.hometask.third.chainOfResponsibilities.CoffeeRequest;

public interface Barista {

    boolean handleRequest(CoffeeRequest request);

    void setNextBarista(Barista nextBarista);

    boolean canHandle(CoffeeRequest request);

    String getBaristaName();
}
