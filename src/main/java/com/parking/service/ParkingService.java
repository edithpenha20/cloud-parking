package com.parking.service;

import com.parking.exception.ParkingNotFoundException;
import com.parking.model.Parking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

//    static {
//        var id = getUUID();
//        var id1 = getUUID();
//        Parking parking = new Parking(id, "DMS-1111", "SC", "CELTA", "PRETO");
//        Parking parking1 = new Parking(id1, "AMS-1111", "SP", "CELTA", "BRANCO");
//        parkingMap.put(id, parking);
//    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if(parking == null) {
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    public Parking createParking(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    public void deleteParking(String id) {
        findById(id);
        parkingMap.remove(id);
    }


    public Parking updateParking(String id, Parking parkingCreate) {
        Parking parkingUpdate = findById(id);
        parkingUpdate.setColor(parkingCreate.getColor());
        parkingMap.replace(id, parkingUpdate);
        return parkingUpdate;
    }

//    public void exitparking(Parking parkingCreate) {
//    }
}
