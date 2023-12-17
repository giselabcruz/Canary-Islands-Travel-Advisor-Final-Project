package org.gisela.dacd.sensorprovider.application;

import org.gisela.dacd.sensorprovider.domain.Hotel;
import org.gisela.dacd.sensorprovider.domain.Location;
import java.util.ArrayList;

public class HotelSupplier {
    // TODO: Application- servicio(clase) que se encarga de obtener informacion de los hoteles para una isla en concreto
    // TODO: Application- servicio(clase) que se encarga de obtener informacion de los VUELOS para una isla en concreto
    // TODO REFACTOR: Valorar si las aplicaciones pueden converger en la misma clase.

    public static ArrayList<Hotel> canaryIslandsHotels() {

        return new ArrayList<>() {
            {
                add(new Hotel("Hotel Riu Gran Canaria", "g230095-d530762", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Paradisus By Meliá Gran Canaria", "g562818-d238899", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Gloria Palace Amadores Thalasso & Hotel", "g635887-d530796", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Club Maspalomas Suites & Spa", "g230095-d645272", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Gloria Palace San Agustín Thalasso & Hotel", "g562818-d237094", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Lopesan Baobab Resort", "g2089121-d1488268", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("AxelBeach Maspalomas", "g562819-d4107099", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("HD Parque Cristobal Gran Canaria", "g562819-d600110", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Hotel Santa Catalina, a Royal Hideaway Hotel", "g187472-d228489", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Hotel Riu Palace Maspalomas", "g562819-d238913", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Hotel Cordial Mogán Playa", "g664857-d559667", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Marina Suites Hotel", "g635887-d530806", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Lopesan Costa Meloneras Resort & Spa", "g2089121-d241729", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Servatur Puerto Azul", "g635887-d287523", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("H10 Playa Meloneras Palace", "g230095-d268385", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Radisson Blu Resort & Spa, Gran Canaria Mogan", "g1177808-d10763397", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Gloria Palace Royal Hotel & Spa", "g4723275-d647726", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Lopesan Villa del Conde Resort & Thalasso", "g2089121-d1218129", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Hotel Nayra", "g562819-d3537619", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Gran Canaria Princess", "g562819-d289643", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Veintiuno", "g187472-d13480199", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Servatur Waikiki", "g562819-d237082", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Hotel Cristina by Tigotan Las Palmas - Adults Only (+16)", "g187472-d228541", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Design Plus Bex Hotel", "g187472-d13227156", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Hotel Riosol", "g1177808-d287482", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("NH Imperial Playa", "g187472-d234398", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("BlueBay Beach Club", "g562818-d677815", new Location("Gran_Canaria", 28.0997, -15.4134)));
                add(new Hotel("Barceló Margaritas", "g562819-d287443", new Location("Gran_Canaria", 28.0997, -15.4134)));


                add(new Hotel("Secrets Bahía Real Resort & Spa", "g580322-d287995", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Barceló Fuerteventura Mar", "g658907-d255145", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Barcelo Corralejo Sands", "g580322-d1141877", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Barceló Corralejo Bay", "g580322-d678447", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Iberostar Selection Fuerteventura Palace", "g659632-d288584", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Occidental Jandía Mar", "g13513937-d557197", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Alua Suites Fuerteventura", "g580322-d573425", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Alua Village Fuerteventura", "g673234-d659467", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Hotel Riu Oliva Beach Resort", "g580322-d237064", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Playa Park Zensation", "g580322-d288058", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Las Marismas De Corralejo", "g580322-d573422", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Elba Castillo San Jorge & Antigua Suite Hotel", "g658907-d262426", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("H10 Ocean Suites", "g580322-d502297", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Bristol Sunset Beach", "g580322-d10784977", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("INNSiDE by Meliá Fuerteventura - Adults only", "g783945-d12002434", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Meliá Fuerteventura", "g783945-d237051", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Barceló Fuerteventura Castillo", "g658907-d237059", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Bahiazul Resort Fuerteventura", "g21147257-d1151363", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Sheraton Fuerteventura Beach, Golf & Spa Resort", "g658907-d601739", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Elba Carlota Beach And Convention Resort", "g658278-d653219", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("H10 Tindaya", "g659634-d579375", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Sol Fuerteventura Jandia All Suites", "g562817-d483649", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Resort Fuerteventura Origo Mare by Pierre & Vacances", "g1216635-d6420508", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Hotel Ereza Mar - Solo Adultos", "g658907-d4582981", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Eurostars Las Salinas", "g658907-d573459", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Hotel Cotillo Beach", "g1047914-d674034", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("Fuerteventura Princess", "g673234-d500267", new Location("Fuerteventura", 28.5004, -13.8627)));
                add(new Hotel("H10 Playa Esmeralda", "g659634-d287968", new Location("Fuerteventura", 28.5004, -13.8627)));


                add(new Hotel("H10 Lanzarote Princess", "g652121-d289256", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Aequora Lanzarote Suites", "g662290-d285669", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Hotel Riu Paraiso Lanzarote", "g662290-d500092", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Hotel LIVVO Volcán Lanzarote", "g652121-d249375", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Sol Lanzarote All Inclusive", "g662290-d280840", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Iberostar Selection Lanzarote Park", "g652121-d319549", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Secrets Lanzarote Resort & Spa", "g580321-d282759", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Barceló Lanzarote Active Resort", "g659633-d234400", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("H10 Timanfaya Palace", "g652121-d289261", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Hotel Dunas Club", "g580322-d288580", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Dreams Lanzarote Playa Dorada Resort & Spa", "g652121-d262432", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Barceló Teguise Beach - Adults Only", "g659633-d287948", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("H10 Rubicón Palace", "g652121-d289259", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("HD Beach Resort & Spa", "g659633-d1117135", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Hotel Palacio Ico", "g652122-d13122500", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("H10 Suites Lanzarote Gardens", "g659633-d289673", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Blue Sea Costa Bastián", "g659633-d569408", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Sandos Papagayo", "g652121-d286724", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Apartamentos LIVVO Morromar", "g662290-d501888", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Arrecife Gran Hotel & Spa", "g187478-d507813", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Princesa Yaiza Hotel Resort", "g652121-d290459", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Caserio de Mozaga", "g1064373-d234402", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("ILUNION Costa Sal Lanzarote", "g662290-d292135", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("BlueBay Lanzarote", "g659633-d284108", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("H10 White Suites", "g652121-d289255", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Barceló Lanzarote Royal Level", "g659633-d23796065", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Elba Lanzarote Royal Village Resort", "g652121-d11876205", new Location("Lanzarote", 28.963, -13.5477)));
                add(new Hotel("Hotel Lanzarote Village", "g662290-d502189", new Location("Lanzarote", 28.963, -13.5477)));


                add(new Hotel("Evita Beach Aptos y Suites Exclusivas", "g1190272-d2645782", new Location("La_Graciosa", 29.255217, -13.504110)));
                add(new Hotel("Apartments La Graciosa", "g3360203-d3411835", new Location("La_Graciosa", 29.255217, -13.504110)));
                add(new Hotel("Apartamentos El Marinero - Avenida", "g3360203-d17628872", new Location("La_Graciosa", 29.255217, -13.504110)));
                add(new Hotel("Apartamentos GraciosaMar", "g1190272-d945848", new Location("La_Graciosa", 29.255217, -13.504110)));
                add(new Hotel("Apartamentos La Pardela Exclusive", "g3360203-d25244761", new Location("La_Graciosa", 29.255217, -13.504110)));


                add(new Hotel("Iberostar Bouganville Playa", "g662606-d296925", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Gran Melia Palacio De Isora", "g1773834-d945835", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Hard Rock Hotel Tenerife", "g315919-d4341700", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Iberostar Selection Sábila", "g662606-d291408", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Dreams Jardin Tropical", "g662606-d248458", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Iberostar Selection Anthelia", "g662606-d285140", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Hotel Botánico & The Oriental Spa Garden", "g187481-d252888", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("H10 Atlantic Sunset", "g315919-d15327583", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Mynd Adeje", "g664636-d17202898", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Hotel Landmar Costa los Gigantes", "g673853-d1105939", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Santa Barbara Golf and Ocean Club", "g672806-d596048", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("GF Gran Costa Adeje", "g662606-d291481", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Gran Melia Palacio De Isora", "g1773834-d945835", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Alua Atlántico Golf Resort", "g672806-d286669", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Meliá Jardines del Teide - Adults only", "g662606-d248456", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Bahía del Duque", "g662606-d248457", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Drago Nest Hostel", "g675094-d12481454", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Spring Hotel Vulcano", "g562820-d248468", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Best Semiramis", "g187481-d1221148", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("GF Fanabe", "g662606-d500302", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Sol Tenerife", "g562820-d248465", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Hotel Las Águilas Tenerife, Affiliated by Meliá", "g187481-d566003", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Sol Arona Tenerife", "-g659661-d248469", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("H10 Costa Adeje Palace", "g662606-d289674", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Hacienda del Conde Meliá Collection - Adults only", "g187479-d8776260", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Hotel Cleopatra Palace", "g562820-d483829", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Hollywood Mirage", "g659661-d549097", new Location("Tenerife", 28.5392, -16.203)));
                add(new Hotel("Iberostar Heritage Grand Mencey", "g187482-d1555517", new Location("Tenerife", 28.5392, -16.203)));


                add(new Hotel("Parador de la Gomera", "g187470-d190895", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Hotel Jardín Tecina", "g1187912-d324473", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Ibo Alfaro Hotel Rural - OFFLINE HOTEL", "g674060-d670383", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Apartamentos Los Telares", "g674060-d729666", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Hotel Gran Rey", "g674782-d616495", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Bar Hotel Sonia", "g1024999-d1811048", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Charco Del Conde", "g674782-d670025", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Tamahuche Rural Hotel", "g1024999-d616810", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Hotel Torre Del Conde", "g187470-d566709", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Hotel Villa Gomera", "g187470-d614341", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Hotel Rural Triana", "g1024999-d15811971", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Hotel La Colombina", "g187470-d2039274", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Jardin Las Hayas", "g1877764-d1182998", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Hotel Escuela Rural Casa Los Herrera", "g674060-d23373330", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Complejo Turístico Las TRES PALMERAS", "g21309597-d1167588", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Hotel Rural Villa Hermigua", "g674060-d1169732", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Hotel Playa Calera", "g21309597-d1379967", new Location("La_Gomera", 28.0916, -17.1133)));
                add(new Hotel("Hotel Jardin Concha", "g12600165-d1637868", new Location("La_Gomera", 28.0916, -17.1133)));


                add(new Hotel("Hotel Hacienda De Abajo", "g1177806-d3577949", new Location("La_Palma", 28.6835, -17.7642)));
                add(new Hotel("La Palma Princess", "g1175543-d638034", new Location("La_Palma", 28.6835, -17.7642)));
                add(new Hotel("Esencia de La Palma by Princess", "g1175543-d21175914", new Location("La_Palma", 28.6835, -17.7642)));
                add(new Hotel("Hacienda San Jorge", "g642213-d535420", new Location("La_Palma", 28.6835, -17.7642)));
                add(new Hotel("Parador de la Palma", "g642213-d482745", new Location("La_Palma", 28.6835, -17.7642)));
                add(new Hotel("H10 Taburiente Playa", "g659966-d289252", new Location("La_Palma", 28.6835, -17.7642)));
                add(new Hotel("Hotel Las Olas", "g642213-d488944", new Location("La_Palma", 28.6835, -17.7642)));
                add(new Hotel("Hotel San Telmo", "g187476-d1760436", new Location("La_Palma", 28.6835, -17.7642)));
                add(new Hotel("Hotel Emblemático Holiday Time", "g187476-d17288155", new Location("La_Palma", 28.6835, -17.7642)));
                add(new Hotel("La Caleta", "g659966-d629213", new Location("La_Palma", 28.6835, -17.7642)));
                add(new Hotel("Dulce Valle Villas & Spa", "g187475-d9583111", new Location("La_Palma", 28.6835, -17.7642)));


                add(new Hotel("Parador de El Hierro", "g187474-d277394", new Location("El_Hierro", 27.8063, -17.9158)));
                add(new Hotel("Puntagrande Hotel", "g2139290-d627753", new Location("El_Hierro", 27.8063, -17.9158)));
                add(new Hotel("Balneario Pozo de la Salud", "g1189149-d1193818", new Location("El_Hierro", 27.8063, -17.9158)));
                add(new Hotel("Hotel Ida Inés", "g2139290-d603283", new Location("El_Hierro", 27.8063, -17.9158)));
                add(new Hotel("Lua", "g2467431-d21119345", new Location("El_Hierro", 27.8063, -17.9158)));
                add(new Hotel("Hotel Villa El Mocanal", "g1190055-d630598", new Location("El_Hierro", 27.8063, -17.9158)));
                add(new Hotel("Complejo Rural La Brujita", "g1190058-d1193275", new Location("El_Hierro", 27.8063, -17.9158)));
            }
        };
    }
}
