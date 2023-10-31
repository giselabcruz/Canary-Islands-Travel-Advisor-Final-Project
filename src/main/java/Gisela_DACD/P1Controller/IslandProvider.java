package Gisela_DACD.P1Controller;

import Gisela_DACD.P1Model.Island;

import java.util.ArrayList;

public class IslandProvider {
    public static ArrayList<Island> initializeIslands() {
        return new ArrayList<>() {
            {
                add(new Island("Gran_Canaria", 28.0997, -15.4134));
                add(new Island("Fuerteventura", 28.5004, -13.8627));
                add(new Island("Lanzarote", 28.963, -13.5477));
                add(new Island("La_Graciosa", 29.255217, -13.504110));
                add(new Island("Tenerife", 28.5392, -16.203));
                add(new Island("La_Gomera", 28.0916, -17.1133));
                add(new Island("La_Palma", 28.6835, -17.7642));
                add(new Island("El_Hierro", 27.8063, -17.9158));
            }
        };
    }
}
