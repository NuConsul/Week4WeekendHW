package com.chemwater.mylibrary.helper;

public class TemperatureUnitConverter {

    public static Double convertToCelsius(String kelvin) throws NumberFormatException {
        double inKelvin ;
        try {
            inKelvin = Double.parseDouble(kelvin) ;
        } catch (NumberFormatException e) {
            throw e ;
        }

        return inKelvin - 273.15 ;
    }

    public static Double convertToFahrenheit(float kelvin) throws NumberFormatException {
        double inKelvin ;
        try {
            inKelvin = kelvin ;//Double.parseDouble(kelvin) ;
        } catch (NumberFormatException e) {
            throw e ;
        }
        return (inKelvin - 273.15) * 1.8000 + 32.00 ;
    }

}