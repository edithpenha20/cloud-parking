package com.parking.service;

import com.parking.exception.ParkingNotFoundException;
import com.parking.model.Parking;
import com.parking.repository.ParkingRepository;
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

    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public Parking findById(String id) {
        return parkingRepository.findById(id).orElseThrow(() ->
                new ParkingNotFoundException(id));
    }

    public Parking createParking(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    public void deleteParking(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }


    public Parking updateParking(String id, Parking parkingCreate) {
        Parking parkingUpdate = findById(id);
        parkingUpdate.setColor(parkingCreate.getColor());
        parkingUpdate.setState(parkingCreate.getState());
        parkingUpdate.setModel(parkingCreate.getModel());
        parkingUpdate.setLicense(parkingCreate.getLicense());
        parkingRepository.save(parkingUpdate);
        return parkingUpdate;
    }

//    public void exitparking(Parking parkingCreate) {
//    }
}
