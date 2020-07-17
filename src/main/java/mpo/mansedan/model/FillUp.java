package mpo.mansedan.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class FillUp {

    @CsvBindByName
    String date;

    @CsvBindByName
    String gasStation;

    @CsvBindByName
    float costPerGallon;

    @CsvBindByName
    float totalPurchased;

    @CsvBindByName
    float milage;

    @CsvBindByName
    String manualMpg;

    // not in CSV
    // int calculatedMpg; // TODO: figure out what i mean by this

    @CsvBindByName
    String tripA;

    @CsvBindByName
    float totalGas;
}
