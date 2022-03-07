package com.aghs.mobilevaccinationalgo.restcontroller;

import com.aghs.mobilevaccinationalgo.Algo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

class SlotData {
    private int dosesPerVan;
    private HashMap<Long, Long> slotsPerSpot;

    public int getDosesPerVan() {
        return dosesPerVan;
    }

    public void setDosesPerVan(int dosesPerVan) {
        this.dosesPerVan = dosesPerVan;
    }

    public HashMap<Long, Long> getSlotsPerSpot() {
        return slotsPerSpot;
    }

    public void setSlotsPerSpot(HashMap<Long, Long> slotsPerSpot) {
        this.slotsPerSpot = slotsPerSpot;
    }
}

@RestController
@RequestMapping("/api")
public class AlgorithmRestController {

    @PostMapping("/algorithm")
    public ResponseEntity getOutput(@RequestBody SlotData data) {
        System.out.println(data.getDosesPerVan());
        System.out.println(data.getSlotsPerSpot());
        List<List<Long>> result = Algo.algorithm(data.getDosesPerVan(), data.getSlotsPerSpot());
        System.out.println(result);
        return new ResponseEntity<List<List<Long>>>(result, HttpStatus.OK);
    }
}
