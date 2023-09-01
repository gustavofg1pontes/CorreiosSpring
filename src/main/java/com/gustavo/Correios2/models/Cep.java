package com.gustavo.Correios2.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cep {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;


    public Cep() {
    }

    public Cep(String cep, String state, String city, String neighborhood, String street) {
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
    }

    @Override
    public String toString() {
        return "cep{"+cep + state + city + neighborhood + street + "}";
    }
}
