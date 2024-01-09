package org.gisela.dacd.flightprovider.infrastructure;

public class PlaceId {
    String iata;
    String entityId;

    public PlaceId(String iata) {
        this.iata = iata;

    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
