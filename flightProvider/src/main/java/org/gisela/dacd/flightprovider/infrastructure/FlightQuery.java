package org.gisela.dacd.flightprovider.infrastructure;

import com.google.gson.Gson;

public class FlightQuery {
    private Query query;

    public FlightQuery() {
        this.query = new Query();
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    static class Query {
        String market;
        String locale;
        String currency;
        QueryLeg[] queryLegs;
        String cabinClass;
        int adults;
        int[] childrenAges;
        String[] includedCarriersIds;
        String[] excludedCarriersIds;
        String[] includedAgentsIds;
        String[] excludedAgentsIds;
        boolean includeSustainabilityData;
        boolean nearbyAirports;
        boolean includeBaggageData;

        Query() {
            // Initialize with default values or add setters to modify these
        }
    }

    static class QueryLeg {
        PlaceId originPlaceId;
        PlaceId destinationPlaceId;
        Date date;
    }


    public void setData() {
        // Setting the values
        query.market = "ES";
        query.locale = "es-ES";
        query.currency = "EUR";

        query.queryLegs = new QueryLeg[1]; // Assuming one leg in the journey
        QueryLeg leg = new QueryLeg();
        leg.originPlaceId = new PlaceId("LPA");
        leg.destinationPlaceId = new PlaceId("TFS");
        leg.date = new Date(2024, 6, 9);

        query.queryLegs[0] = leg;

        query.cabinClass = "CABIN_CLASS_ECONOMY";
        query.adults = 1;
        query.childrenAges = new int[] {0};
        query.includedAgentsIds = new String[] {""};
        query.excludedAgentsIds = new String[] {""};
        query.includeSustainabilityData = true;
        query.nearbyAirports = true;
        query.includeBaggageData = true;
    }
}
